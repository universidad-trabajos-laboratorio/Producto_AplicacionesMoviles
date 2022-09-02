package com.example.producto_aplicacionesmoviles.presentation.views.consultas

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.producto_aplicacionesmoviles.R
import com.example.producto_aplicacionesmoviles.databinding.FragmentConsultaCreateBinding

class ConsultaCreateFragment : Fragment() {
    private var _binding: FragmentConsultaCreateBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentConsultaCreateBinding.inflate(inflater, container, false)
        return binding.root
    }
}