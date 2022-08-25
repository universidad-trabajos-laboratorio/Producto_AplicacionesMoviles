package com.example.producto_aplicacionesmoviles

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase

class MainActivity : AppCompatActivity() {

    private lateinit var auth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        auth = Firebase.auth
        val currentUser = auth.currentUser
        var miIntent: Intent
        if (currentUser != null) {
            miIntent = Intent(this, AppActivity::class.java)
            println("TU SESION YA ESTA INICIADA >:c")
            startActivity(miIntent)
            finish()
        } else {
            miIntent = Intent(this, AuthActivity::class.java)
            println("NO INICIASTE SESION PENDEIVIS >:c")
            startActivity(miIntent)
            finish()
        }
    }


}