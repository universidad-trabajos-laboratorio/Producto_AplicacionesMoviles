package com.example.producto_aplicacionesmoviles.presentation.views.consultas

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.producto_aplicacionesmoviles.R
import com.example.producto_aplicacionesmoviles.databinding.FragmentConsultaHistoryBinding

class ConsultaHistoryFragment : Fragment() {
    private var _binding: FragmentConsultaHistoryBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentConsultaHistoryBinding.inflate(inflater, container, false)
        return binding.root
    }
}