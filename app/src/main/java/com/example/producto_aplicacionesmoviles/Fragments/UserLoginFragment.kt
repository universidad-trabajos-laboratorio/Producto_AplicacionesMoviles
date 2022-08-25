package com.example.producto_aplicacionesmoviles.Fragments

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.example.producto_aplicacionesmoviles.AppActivity
import com.example.producto_aplicacionesmoviles.databinding.FragmentUserLoginBinding
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase


class UserLoginFragment : Fragment() {
    private var _binding: FragmentUserLoginBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentUserLoginBinding.inflate(inflater, container, false)
        val view = binding.root
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.btnIngresar.setOnClickListener {
            val email = binding.inputTextLogin.text.toString()
            val password = binding.inputTextPassword.text.toString()
            println("INICIANDO SESION")
            Firebase.auth.signInWithEmailAndPassword(email, password)
                .addOnCompleteListener { task ->
                    if (task.isSuccessful) {
                        startActivity(Intent(this.activity, AppActivity::class.java))
                        this.activity?.finish()
                    } else {
                        Toast.makeText(
                            this.activity?.baseContext,
                            "Autenticacion fallida :c",
                            Toast.LENGTH_SHORT
                        ).show()
                        println("ERROR AL INICIAR SESION")
                    }
                }

        }

    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }

}