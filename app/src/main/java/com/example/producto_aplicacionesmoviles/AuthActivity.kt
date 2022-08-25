package com.example.producto_aplicacionesmoviles

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.producto_aplicacionesmoviles.databinding.ActivityAuthBinding
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase

class AuthActivity : AppCompatActivity() {
    private lateinit var binding: ActivityAuthBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAuthBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }




//
//    private fun createAccount(email: String, password: String) {
//        println("CREANDO CUENTA")
//        auth.createUserWithEmailAndPassword(email, password).addOnCompleteListener{ task ->
//            if (task.isSuccessful) {
//                val user = auth.currentUser
//                val message = user?.email
//                println("EL CORREO DEL CAUSITA ES")
//                println(message)
//            } else {
//                Toast.makeText(baseContext, "Autenticacion fallida :c", Toast.LENGTH_SHORT).show()
//                println("ERROR AL CREAR CUENTA")
//            }
//        }
//    }


//    private fun signIn(email: String, password: String) {
//        println("INICIANDO SESION")
//        auth.signInWithEmailAndPassword(email, password).addOnCompleteListener { task ->
//            if (task.isSuccessful) {
//                val user = auth.currentUser
//                val message = user?.email
//                println("EL CORREO DEL CAUSITA ES")
//                println(message)
//            } else {
//                Toast.makeText(baseContext, "Autenticacion fallida :c", Toast.LENGTH_SHORT).show()
//                println("ERROR AL INICIAR SESION")
//            }
//        }
//    }
//    private fun signOut() {
//        auth.signOut()
//    }

}