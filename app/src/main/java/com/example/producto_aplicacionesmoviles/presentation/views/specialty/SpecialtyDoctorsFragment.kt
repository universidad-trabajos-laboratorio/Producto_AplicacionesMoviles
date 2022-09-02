package com.example.producto_aplicacionesmoviles.presentation.views.specialty

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.producto_aplicacionesmoviles.R
import com.example.producto_aplicacionesmoviles.databinding.FragmentSpecialtyDoctorsBinding

class SpecialtyDoctorsFragment : Fragment() {
    private var _binding:FragmentSpecialtyDoctorsBinding?=null
    private val binding get() = _binding!!
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
       _binding = FragmentSpecialtyDoctorsBinding.inflate(inflater,container,false)
        return binding.root
    }

}