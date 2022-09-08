package com.example.producto_aplicacionesmoviles.presentation.views.consultas

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.GridLayoutManager
import com.example.producto_aplicacionesmoviles.R
import com.example.producto_aplicacionesmoviles.databinding.FragmentConsultaHistoryBinding
import com.example.producto_aplicacionesmoviles.presentation.adapters.ConsultasAdapter
import com.example.producto_aplicacionesmoviles.viewmodels.AppointmentsViewModel
import com.example.producto_aplicacionesmoviles.viewmodels.UsersViewModel
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint()
class ConsultaHistoryFragment : Fragment() {
    private var _binding: FragmentConsultaHistoryBinding? = null
    private val binding get() = _binding!!
    private val appointmentViewModel: AppointmentsViewModel by viewModels()
    private val userViewModel: UsersViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentConsultaHistoryBinding.inflate(inflater, container, false)
        initRecyclerView()

        appointmentViewModel.appointmentsByPatientUserIdResponse.observe(viewLifecycleOwner, Observer { consultasPendientes->
           binding.rvConsultasPendientes.adapter = ConsultasAdapter(consultasPendientes)
        })
        userViewModel.userByAuthIdResponse.observe(viewLifecycleOwner, Observer {
            it.id?.let { it1 -> appointmentViewModel.getAppointmentsByPatientUserId(it1) }
        })

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        Firebase.auth.currentUser?.let { userViewModel.getUserByAuthId(it.uid) }

    }
    private fun initRecyclerView() {
        val grid = GridLayoutManager(this.context, 3)
        binding.rvConsultasPendientes.layoutManager = grid
        binding.rvConsultasPendientes.adapter = ConsultasAdapter(emptyList())
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}