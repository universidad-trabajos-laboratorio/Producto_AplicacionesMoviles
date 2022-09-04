package com.example.producto_aplicacionesmoviles.presentation.views.perfil

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import com.example.producto_aplicacionesmoviles.R
import com.example.producto_aplicacionesmoviles.databinding.FragmentPerfilBinding
import com.example.producto_aplicacionesmoviles.presentation.views.AuthActivity
import com.example.producto_aplicacionesmoviles.viewmodels.UsersViewModel
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class PerfilFragment : Fragment() {
    private var _binding: FragmentPerfilBinding? = null
    private val binding get() = _binding!!
    private val userViewModel: UsersViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentPerfilBinding.inflate(inflater, container, false)


        userViewModel.userByAuthIdResponse.observe(viewLifecycleOwner, Observer { user ->
            binding.tvNameTitle.text = user.name
            binding.tvName.text = user.name
            binding.tvEmail.text = user.email
            binding.tvGender.text = user.gender
            binding.tvTipoDdocumento.text = user.document_type
            binding.tvValueDocumento.text = user.document_number
            binding.tvRole.text = user.rol
        })



        binding.btnCerrarSesion.setOnClickListener {

            Firebase.auth.signOut()
            startActivity(Intent(context, AuthActivity::class.java))
            this.activity?.finish()
        }

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val authId = Firebase.auth.currentUser!!.uid
        if(!authId.isNullOrEmpty()){
            userViewModel.getUserByAuthId(authId)
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }


}