package com.example.producto_aplicacionesmoviles.viewmodels

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.producto_aplicacionesmoviles.core.Utils
import com.example.producto_aplicacionesmoviles.data.model.Response
import com.example.producto_aplicacionesmoviles.data.model.WorkDay
import com.example.producto_aplicacionesmoviles.domain.use_case.WorkDaysUseCases
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class WorkDaysViewModel @Inject constructor(
    private val useCases: WorkDaysUseCases
) : ViewModel(){
    val workDaysResponse = MutableLiveData<List<WorkDay>>()
    val workDaysByUserIdResponse = MutableLiveData<List<WorkDay>>()
    val isLoading = MutableLiveData<Boolean>()

    fun getWorkDays() = viewModelScope.launch {
        var result: List<WorkDay>? = emptyList()
        useCases.getWorkDays().collect { response ->
            when(response) {
                is Response.Loading -> isLoading.postValue(true)
                is Response.Success -> {
                    result = response.data
                }
                is Response.Error -> Utils.printMessage(response.message)
            }

            if (!result.isNullOrEmpty()){
                workDaysResponse.postValue(result!!)
                isLoading.postValue(false)
            }
        }
    }

    fun getDoctorsBySpecialtyId(userId : String) = viewModelScope.launch {
        var specialtyDoctorsResultList: List<WorkDay>? = emptyList()

        useCases.getWorkDaysByUserId(userId).collect { response ->
            when(response) {
                is Response.Loading -> isLoading.postValue(true)
                is Response.Success -> {
                    specialtyDoctorsResultList = response.data
                }
                is Response.Error -> Utils.printMessage(response.message)
            }

            if (!specialtyDoctorsResultList.isNullOrEmpty()){
                workDaysByUserIdResponse.postValue(specialtyDoctorsResultList!!)
                isLoading.postValue(false)
            }
        }
    }

    fun addWorkDay( doctor_id: String?, day: Int? , morning_start: String?, morning_end: String?,
                    afternoon_start :String? , afternoon_end : String?, active: Boolean?
    ) = viewModelScope.launch {
        val newWorkDay =  WorkDay(
            doctor_id = doctor_id,
            day = day?:0,
            morning_start = morning_start?: "07:00:00",
            morning_end = morning_end?: "07:00:00",
            afternoon_start = afternoon_start?: "15:00:00",
            afternoon_end = afternoon_end?: "15:00:00",
            active = active?: true
        )
        useCases.addWorkDay(newWorkDay).collect { }
    }

}

