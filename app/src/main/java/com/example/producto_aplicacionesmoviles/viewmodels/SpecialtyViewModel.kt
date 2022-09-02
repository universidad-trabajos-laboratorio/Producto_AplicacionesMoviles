package com.example.producto_aplicacionesmoviles.viewmodels

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.producto_aplicacionesmoviles.core.Utils
import com.example.producto_aplicacionesmoviles.data.model.Response
import com.example.producto_aplicacionesmoviles.data.model.Specialty
import com.example.producto_aplicacionesmoviles.domain.use_case.SpecialtyUseCases
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class SpecialtyViewModel @Inject constructor(
    private val useCases: SpecialtyUseCases
) : ViewModel(){
    val specialtiesResponse = MutableLiveData<List<Specialty>>()
    val isLoading = MutableLiveData<Boolean>()

    init {
        getSpecialties()
    }

    private fun getSpecialties() = viewModelScope.launch {
        var result: List<Specialty>? = emptyList()
        isLoading.postValue(true)
        useCases.getSpecialty().collect { response ->
            when (response) {
               // is Response.Loading -> isLoading.postValue(true)
                is Response.Success -> {
                    result = response.data
                }
                is Response.Error -> Utils.printMessage(response.message)
            }

            if (!result.isNullOrEmpty()) {
                specialtiesResponse.postValue(result!!)
                isLoading.postValue(false)
            }
        }
    }

    fun addSpeciality(name: String, icon: String, active: Boolean) = viewModelScope.launch {
        useCases.addSpecialty(name, icon, active).collect { }
    }


    fun randomSpecialty() {
        //val currentSpecialty = SpecialtyProvider.random()
        //specialtyModel.postValue(currentSpecialty)
    }

}