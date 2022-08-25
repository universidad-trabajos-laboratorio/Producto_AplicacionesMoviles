package com.example.producto_aplicacionesmoviles

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase

class AppActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_app)
        val btnCerrarSesion:Button = findViewById(R.id.btn_cerrarSesion)
        btnCerrarSesion.setOnClickListener {
            Firebase.auth.signOut();
            startActivity(Intent(this,AuthActivity::class.java))
            finish()
        }
    }
}