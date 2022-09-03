package com.example.producto_aplicacionesmoviles.presentation.views.specialty

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.core.view.isVisible
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.GridLayoutManager
import com.example.producto_aplicacionesmoviles.R
import com.example.producto_aplicacionesmoviles.databinding.FragmentSpecialtyBinding

import com.example.producto_aplicacionesmoviles.presentation.adapters.SpecialtyAdapter
import com.example.producto_aplicacionesmoviles.viewmodels.SpecialtyViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint()
class SpecialtyFragment : Fragment() {
    private var _binding: FragmentSpecialtyBinding? = null
    private val binding get() = _binding!!
    private val specialtyViewModel: SpecialtyViewModel by viewModels()


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentSpecialtyBinding.inflate(inflater, container, false)
        initRecyclerView()

        specialtyViewModel.specialtiesResponse.observe(
            viewLifecycleOwner,
            Observer { currentSpeciatlyList ->
                binding.rvSpecialty.adapter =
                    SpecialtyAdapter(currentSpeciatlyList) { specialtyId ->
                        openDoctors(specialtyId)
                    }
            })

        specialtyViewModel.isLoading.observe(viewLifecycleOwner, Observer { stateLoading ->
            binding.progress.isVisible = stateLoading
        })

        return binding.root
    }

    private fun openDoctors(specialtyId: String) {
        val action = SpecialtyFragmentDirections.actionSpecialtyFragmentToSpecialtyDoctorsFragment(specialtyId)
        findNavController().navigate(action)
    }


    private fun initRecyclerView() {
        val grid = GridLayoutManager(this.context, 3)
        binding.rvSpecialty.layoutManager = grid
        binding.rvSpecialty.adapter = SpecialtyAdapter(emptyList()) { specialtyId ->
            openDoctors(specialtyId)
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }


}