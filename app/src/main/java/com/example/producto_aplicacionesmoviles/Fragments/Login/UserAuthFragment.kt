package com.example.producto_aplicacionesmoviles.Fragments.Login

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.producto_aplicacionesmoviles.R
import com.example.producto_aplicacionesmoviles.databinding.FragmentUserAuthBinding


class UserAuthFragment : Fragment() {

    private var _binding: FragmentUserAuthBinding? = null
    private val binding get() = _binding!!
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentUserAuthBinding.inflate(inflater, container, false)
        val view = binding.root
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.btnAbrirLogin.setOnClickListener {
            findNavController().navigate(R.id.action_userAuthFragment_to_userLoginFragment)
        }
        binding.btnAbrirRegistrarse.setOnClickListener {
            findNavController().navigate(R.id.action_userAuthFragment_to_userRegisterFragment)
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }


}