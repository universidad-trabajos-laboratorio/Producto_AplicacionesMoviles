package com.example.producto_aplicacionesmoviles.test_ui

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
    val specialtyModel = MutableLiveData<Specialty>()
    val specialtiesResponse = MutableLiveData<List<Specialty>>()
    val isLoading = MutableLiveData<Boolean>()

    init {
        getSpecialties()
    }

    fun getSpecialties() = viewModelScope.launch {
        var result: List<Specialty>? = emptyList()
        useCases.getSpecialty().collect { response ->
            when(response) {
                is Response.Loading -> Utils.printMessage("CARGANDO")
                is Response.Success -> {
                    result = response.data
                }
                is Response.Error -> Utils.printMessage(response.message)
            }

            if (!result.isNullOrEmpty()){
                specialtiesResponse.postValue(result!!)
                specialtyModel.postValue(result!![1])
                isLoading.postValue(false)
            }
        }
    }

    fun randomSpecialty(){
        //val currentSpecialty = SpecialtyProvider.random()
        //specialtyModel.postValue(currentSpecialty)
    }

}