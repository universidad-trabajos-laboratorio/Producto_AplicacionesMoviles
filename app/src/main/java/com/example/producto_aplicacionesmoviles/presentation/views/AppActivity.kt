package com.example.producto_aplicacionesmoviles.presentation.views


import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem

import androidx.navigation.NavController

import androidx.navigation.findNavController
import androidx.navigation.ui.*
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
        appBarConfiguration = AppBarConfiguration(
            setOf(
                R.id.homeFragment,
                R.id.perfilFragment,
                R.id.specialtyFragment,
                R.id.consultaHistoryFragment
            )
        )

        navController = findNavController(R.id.nav_app_host_fragment)


        //Toolbar
        setSupportActionBar(binding.toolbar)
        setupActionBarWithNavController(navController,appBarConfiguration)


        binding.botonNavigationApp.setOnItemSelectedListener { item->rulesNavigationApp(item) }
//        binding.botonNavigationApp.setupWithNavController(navController)
    }

    private fun rulesNavigationApp(item:MenuItem):Boolean{
        when(item.itemId){
            R.id.homeFragment ->navController.navigate(R.id.homeFragment)
            R.id.consultaHistoryFragment ->navController.navigate(R.id.consultaHistoryFragment)
            R.id.specialtyFragment ->navController.navigate(R.id.specialtyFragment)
            R.id.perfilFragment ->navController.navigate(R.id.perfilFragment)
        }
        return true
    }

    override fun onSupportNavigateUp(): Boolean {
        return navController.navigateUp(appBarConfiguration) ||  return super.onSupportNavigateUp()
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.bottom_nav_menu,menu)
        return true

    //        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
    return item.onNavDestinationSelected(navController) || super.onOptionsItemSelected(item)
    }

}