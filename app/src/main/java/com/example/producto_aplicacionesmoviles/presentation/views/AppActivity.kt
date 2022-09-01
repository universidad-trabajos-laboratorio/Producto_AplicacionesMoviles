package com.example.producto_aplicacionesmoviles.presentation.views


import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem

import androidx.navigation.NavController

import androidx.navigation.findNavController
import com.example.producto_aplicacionesmoviles.R
import com.example.producto_aplicacionesmoviles.databinding.ActivityAppBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint()
class AppActivity : AppCompatActivity() {


    private lateinit var navController:NavController
    private lateinit var binding:ActivityAppBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAppBinding.inflate(layoutInflater)
        setContentView(binding.root)
        navController = findNavController(R.id.nav_app_host_fragment)
        binding.botonNavigationApp.setOnItemSelectedListener { item->rulesNavigationApp(item) }

    }

    private fun rulesNavigationApp(item:MenuItem):Boolean{
        when(item.itemId){
            R.id.menu_home ->navController.navigate(R.id.homeFragment)
            R.id.menu_consultas ->navController.navigate(R.id.consultaHistoryFragment)
            R.id.menu_medicos ->navController.navigate(R.id.specialtyFragment)
            R.id.menu_perfil ->navController.navigate(R.id.perfilFragment)
        }
        return true
    }

}