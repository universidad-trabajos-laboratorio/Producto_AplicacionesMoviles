package com.example.producto_aplicacionesmoviles.presentation.views.login

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.example.producto_aplicacionesmoviles.presentation.views.AppActivity
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
            login(binding.inputTextLogin.text.toString(), binding.inputTextPassword.text.toString())
        }
    }

    private fun login(email: String, password: String) {
        if (isCorrectCredentials(email, password)) {
            Firebase.auth.signInWithEmailAndPassword(email, password)
                .addOnCompleteListener { task ->
                    if (task.isSuccessful) {
                        openApp()
                        this.activity?.finish()
                    } else {
                        showMessageError(task.exception?.localizedMessage.toString())
                    }
                }
        }
    }

    private fun openApp() {
        startActivity(Intent(context, AppActivity::class.java))
    }

    private fun isCorrectCredentials(email: String, password: String): Boolean {
        if (email.isNotEmpty() && password.isNotEmpty()) {
            return true
        }
        showMessageError("Fields cannot be empty")
        return false
    }

    private fun showMessageError(message: String) {
        Toast.makeText(
            this.activity?.baseContext,
            message,
            Toast.LENGTH_SHORT
        ).show()
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }

}