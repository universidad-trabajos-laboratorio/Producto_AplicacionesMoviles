package com.example.producto_aplicacionesmoviles

import android.app.Application
import com.example.producto_aplicacionesmoviles.ui.specialty.SpecialtiesActivity
import dagger.Component
import dagger.hilt.android.HiltAndroidApp

@Component
interface ApplicationComponent {
    // This tells Dagger that LoginActivity requests injection so the graph needs to
    // satisfy all the dependencies of the fields that LoginActivity is requesting.
    fun inject(activity: SpecialtiesActivity)
}

@HiltAndroidApp
class FirestoreCleanArchitectureApp : Application(){
    // Reference to the application graph that is used across the whole app
    //val appComponent = DaggerApplicationComponent.create()
}
