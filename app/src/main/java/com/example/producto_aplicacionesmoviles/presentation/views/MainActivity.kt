package com.example.producto_aplicacionesmoviles.presentation.views

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val currentUser = Firebase.auth.currentUser
        var miIntent: Intent
        if (currentUser != null) {
            miIntent = Intent(this, AppActivity::class.java)
            startActivity(miIntent)
            finish()
        } else {
            miIntent = Intent(this, AuthActivity::class.java)
            startActivity(miIntent)
            finish()
        }
    }


}