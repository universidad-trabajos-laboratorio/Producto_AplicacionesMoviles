package com.example.producto_aplicacionesmoviles.presentation.views.specialty

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.producto_aplicacionesmoviles.databinding.FragmentDoctorDetailBinding

class DoctorDetailFragment : Fragment() {
    private var _binding: FragmentDoctorDetailBinding?=null
    private val binding get() = _binding!!
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentDoctorDetailBinding.inflate(inflater,container,false)
        return binding.root
    }


}