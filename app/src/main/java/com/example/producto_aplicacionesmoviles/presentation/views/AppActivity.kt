package com.example.producto_aplicacionesmoviles.presentation.views


import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem

import androidx.navigation.NavController

import androidx.navigation.findNavController
import androidx.navigation.ui.*
import com.example.producto_aplicacionesmoviles.AppGraphDirections
import com.example.producto_aplicacionesmoviles.R
import com.example.producto_aplicacionesmoviles.databinding.ActivityAppBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint()
class AppActivity : AppCompatActivity() {


    private lateinit var navController:NavController
    private lateinit var binding:ActivityAppBinding
    private lateinit var appBarConfiguration:AppBarConfiguration


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAppBinding.inflate(layoutInflater)
        setContentView(binding.root)


        navController = findNavController(R.id.nav_app_host_fragment)

//        appBarConfiguration = AppBarConfiguration(navController.graph)

        appBarConfiguration = AppBarConfiguration(
            setOf(
                R.id.homeFragment,
                R.id.perfilFragment,
                R.id.specialtyFragment,
                R.id.consultaHistoryFragment
            )
        )
        //Toolbar
        setSupportActionBar(binding.toolbar)
        binding.toolbar.setupWithNavController(navController,appBarConfiguration)
//        setupActionBarWithNavController(navController,appBarConfiguration)

       binding.botonNavigationApp.setupWithNavController(navController)
       binding.botonNavigationApp.setOnItemReselectedListener { item->rulesNavigationApp(item) }

//       binding.botonNavigationApp.setOnItemSelectedListener { item->rulesNavigationApp(item) }

    }
    private fun rulesNavigationApp(item:MenuItem):Boolean{
        val actionHome = AppGraphDirections.actionGlobalNavigationHome()
        val actionConsultas = AppGraphDirections.actionGlobalNavigationConsultas()
        val actionSpecialty = AppGraphDirections.actionGlobalNavigationSpecialty()
        val actionPerfil = AppGraphDirections.actionGlobalNavigationPerfil()

        when(item.itemId){
            R.id.navigationHome ->navController.navigate(actionHome)
            R.id.navigationConsultas ->navController.navigate(actionConsultas)
            R.id.navigationSpecialty ->navController.navigate(actionSpecialty)
            R.id.navigationPerfil ->navController.navigate(actionPerfil)
        }
        return false
    }




//    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
////        menuInflater.inflate(R.menu.bottom_nav_menu,menu)
////        return true
//
//            return super.onCreateOptionsMenu(menu)
//    }
//
//    override fun onOptionsItemSelected(item: MenuItem): Boolean {
//    return item.onNavDestinationSelected(navController) || super.onOptionsItemSelected(item)
//    }

}