package com.example.producto_aplicacionesmoviles.test_ui.specialty

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.producto_aplicacionesmoviles.R
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class SpecialtiesActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_specialties_test)
        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                .replace(R.id.container, ItemFragment.newInstance(1))
                .commitNow()
        }
    }
}