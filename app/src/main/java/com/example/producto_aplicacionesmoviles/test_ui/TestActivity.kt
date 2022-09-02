package com.example.producto_aplicacionesmoviles.test_ui

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.isVisible
import androidx.lifecycle.Observer
import com.example.producto_aplicacionesmoviles.databinding.ActivityTestBinding
import com.example.producto_aplicacionesmoviles.test_ui.specialty.SpecialtyViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class TestActivity : AppCompatActivity() {

    private lateinit var binding: ActivityTestBinding

    private val specialtyViewModel : SpecialtyViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityTestBinding.inflate(layoutInflater)
        setContentView(binding.root)

//        specialtyViewModel.specialtyModel.observe(this, Observer { currentSpecialty ->
//            binding.tvQuote.text = currentSpecialty.name
//            binding.tvAuthor.text = currentSpecialty.id
//        })

        specialtyViewModel.isLoading.observe(this, Observer {
            binding.loading.isVisible = it
        })

        binding.viewContainer.setOnClickListener{
            specialtyViewModel.randomSpecialty()
        }
    }
}