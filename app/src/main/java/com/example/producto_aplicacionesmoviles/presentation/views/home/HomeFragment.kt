package com.example.producto_aplicacionesmoviles.presentation.views.home

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.producto_aplicacionesmoviles.AppGraphDirections
import com.example.producto_aplicacionesmoviles.R
import com.example.producto_aplicacionesmoviles.databinding.FragmentHomeBinding

class HomeFragment : Fragment() {
    private var _binding: FragmentHomeBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        binding.cardAboutHospital.setOnClickListener{
            val action = HomeFragmentDirections.actionHomeFragmentToAboutFragment()
            findNavController().navigate(action)
        }
        binding.cardDoctores.setOnClickListener{
            val action = AppGraphDirections.actionGlobalNavigationSpecialty()
            findNavController().navigate(action)
        }
        binding.cardRegistroConsulta.setOnClickListener{
            val action = AppGraphDirections.actionGlobalConsultaHistoryFragment()
            findNavController().navigate(action)
        }

        return binding.root
    }
    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}