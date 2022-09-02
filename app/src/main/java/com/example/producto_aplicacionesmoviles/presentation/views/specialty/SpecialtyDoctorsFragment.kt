package com.example.producto_aplicacionesmoviles.presentation.views.specialty

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.navigation.fragment.navArgs
import androidx.recyclerview.widget.GridLayoutManager

import com.example.producto_aplicacionesmoviles.databinding.FragmentSpecialtyDoctorsBinding
import com.example.producto_aplicacionesmoviles.presentation.adapters.SpecialtyDoctorAdapter
import com.example.producto_aplicacionesmoviles.viewmodels.SpecialtyDoctorsViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class SpecialtyDoctorsFragment : Fragment() {
    private var _binding: FragmentSpecialtyDoctorsBinding? = null
    private val binding get() = _binding!!
    private val specialtyDoctorsViewModel: SpecialtyDoctorsViewModel by viewModels()

    val args: SpecialtyDoctorsFragmentArgs by navArgs()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentSpecialtyDoctorsBinding.inflate(inflater, container, false)
        initRecycleView()
    specialtyDoctorsViewModel.doctorsBySpecialtyResponse.observe(viewLifecycleOwner,Observer{ specialtyDoctorList->
        binding.rvSpecialtyDoctors.adapter = SpecialtyDoctorAdapter(specialtyDoctorList)
    })

    specialtyDoctorsViewModel.isLoading.observe(viewLifecycleOwner,Observer{ isLoading->
        binding.progress.isVisible = isLoading
    })


        return binding.root
    }

    private fun initRecycleView() {
        val grid = GridLayoutManager(this.context, 2)
        binding.rvSpecialtyDoctors.layoutManager = grid
        binding.rvSpecialtyDoctors.adapter = SpecialtyDoctorAdapter(emptyList())
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.tvSpecialtyDoctorTitle.text = "¡Cardiólogos!"
        binding.tvSpecialtyDoctorDescription.text = "Personal calificado en cardeologia"
        binding.tvSpecialtyDoctorNameSecction.text = "Listado de Cardiólogos"
        val id = args.id.toString()
        specialtyDoctorsViewModel.getDoctorsBySpecialtyId(id)
    }

}