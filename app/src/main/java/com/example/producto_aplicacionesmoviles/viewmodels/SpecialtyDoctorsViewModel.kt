package com.example.producto_aplicacionesmoviles.viewmodels

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.producto_aplicacionesmoviles.core.Utils
import com.example.producto_aplicacionesmoviles.data.model.Response
import com.example.producto_aplicacionesmoviles.data.model.SpecialtyDoctor
import com.example.producto_aplicacionesmoviles.domain.use_case.SpecialtyDoctorUseCases
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import java.util.*
import javax.inject.Inject

@HiltViewModel
class SpecialtyDoctorsViewModel @Inject constructor(
    private val useCases: SpecialtyDoctorUseCases
) : ViewModel(){
    val doctorsResponse = MutableLiveData<List<SpecialtyDoctor>>()
    val doctorsBySpecialtyResponse = MutableLiveData<List<SpecialtyDoctor>>()
    val isLoading = MutableLiveData<Boolean>()

    init {
        getDoctors()
    }

    private fun getDoctors() = viewModelScope.launch {
        var result: List<SpecialtyDoctor>? = emptyList()
        useCases.getSpecialtyDoctors().collect { response ->
            when(response) {
                is Response.Loading -> isLoading.postValue(true)
                is Response.Success -> {
                    result = response.data
                }
                is Response.Error -> Utils.printMessage(response.message)
            }

            if (!result.isNullOrEmpty()){
                doctorsResponse.postValue(result!!)
                isLoading.postValue(false)
            }
        }
    }

    fun getDoctorsBySpecialtyId(specialtyId : String) = viewModelScope.launch {
        var result: List<SpecialtyDoctor>? = emptyList()
        useCases.getSpecialtyDoctorsBySpecialtyId(specialtyId).collect { response ->
            when(response) {
                is Response.Loading -> isLoading.postValue(true)
                is Response.Success -> {
                    result = response.data
                }
                is Response.Error -> Utils.printMessage(response.message)
            }

            if (!result.isNullOrEmpty()){
                doctorsBySpecialtyResponse.postValue(result!!)
                isLoading.postValue(false)
            }
        }
    }

    fun addDoctor( user_id: String?, specialty_id: String? , title: String?,
                   biography :String? , enter_date : Long?, active: Boolean?
    ) = viewModelScope.launch {
        val newSpecialtyDoctor = SpecialtyDoctor(
            user_id = user_id,
            specialty_id = specialty_id,
            title= title ?: "S/N",
            biography= biography ?: "S/N",
            enter_date = enter_date?: Date().time,
            active = active?: true
        )
        useCases.addSpecialtyDoctor(newSpecialtyDoctor).collect { }
    }

}