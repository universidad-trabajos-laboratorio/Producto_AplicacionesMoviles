package com.example.producto_aplicacionesmoviles.presentation.views.perfil

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.producto_aplicacionesmoviles.R
import com.example.producto_aplicacionesmoviles.databinding.FragmentPerfilBinding
import com.example.producto_aplicacionesmoviles.presentation.views.AuthActivity
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase

class PerfilFragment : Fragment() {
    private var _binding:FragmentPerfilBinding?=null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding=FragmentPerfilBinding.inflate(inflater,container,false)

        binding.btnCerrarSesion.setOnClickListener{

            Firebase.auth.signOut()
            startActivity(Intent(context,AuthActivity::class.java))
            this.activity?.finish()
        }

        return binding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }


}