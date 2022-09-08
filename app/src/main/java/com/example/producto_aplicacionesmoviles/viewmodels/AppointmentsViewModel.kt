package com.example.producto_aplicacionesmoviles.viewmodels

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.producto_aplicacionesmoviles.core.TimeUtils
import com.example.producto_aplicacionesmoviles.core.Utils
import com.example.producto_aplicacionesmoviles.data.model.Appointment
import com.example.producto_aplicacionesmoviles.data.model.Response
import com.example.producto_aplicacionesmoviles.data.model.WorkDay
import com.example.producto_aplicacionesmoviles.domain.use_case.AppointmentsUseCases
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class AppointmentsViewModel @Inject constructor(
    private val useCases: AppointmentsUseCases
) : ViewModel(){
    val appointmentsResponse = MutableLiveData<List<Appointment>>()
    val appointmentsByPatientUserIdResponse = MutableLiveData<List<Appointment>>()
    val appointmentsByDateAndPatientUserId = MutableLiveData<List<Appointment>>()
    val isLoading = MutableLiveData<Boolean>()

    fun getAppointments() = viewModelScope.launch {
        var result: List<Appointment>? = emptyList()
        useCases.getAppointments().collect { response ->
            when(response) {
                is Response.Loading -> isLoading.postValue(true)
                is Response.Success -> {
                    result = response.data
                }
                is Response.Error -> Utils.printMessage(response.message)
            }

            if (!result.isNullOrEmpty()){
                appointmentsResponse.postValue(result!!)
                isLoading.postValue(false)
            }
        }
    }

    fun getAppointmentsByPatientUserId(patientId : String) = viewModelScope.launch {
        var specialtyDoctorsResultList: List<Appointment>? = emptyList()

        useCases.getAppointmentsByPatientId(patientId).collect { response ->
            when(response) {
                is Response.Loading -> isLoading.postValue(true)
                is Response.Success -> {
                    specialtyDoctorsResultList = response.data
                }
                is Response.Error -> Utils.printMessage(response.message)
            }

            if (!specialtyDoctorsResultList.isNullOrEmpty()){
                appointmentsByPatientUserIdResponse.postValue(specialtyDoctorsResultList!!)
                isLoading.postValue(false)
            }
        }
    }

    fun getAppointmentsByDateAndPatientUserId(date:Long, patientId : String) = viewModelScope.launch {
        var specialtyDoctorsResultList: List<Appointment>? = emptyList()

        useCases.getAppointmentsByDateAndPatientId(date, patientId).collect { response ->
            when(response) {
                is Response.Loading -> isLoading.postValue(true)
                is Response.Success -> {
                    specialtyDoctorsResultList = response.data
                }
                is Response.Error -> Utils.printMessage(response.message)
            }

            if (!specialtyDoctorsResultList.isNullOrEmpty()){
                appointmentsByDateAndPatientUserId.postValue(specialtyDoctorsResultList!!)
                isLoading.postValue(false)
            }
        }
    }

    fun addAppointment( specialty_id: String?, doctor_id: String?, patient_id: String?,
                        type: String?, scheduled_date : Long?, scheduled_time : String?,
                        status: String?) = viewModelScope.launch {
        val newAppointment = Appointment(
            specialty_id = specialty_id,
            doctor_id = doctor_id,
            patient_id = patient_id,
            type = type?:"CONSULTA",
            scheduled_date = scheduled_date ?: TimeUtils.getActualDateInLima().time,
            scheduled_time = scheduled_time ?: "01:00:00",
            status = status?: "PENDIENTE"
        );
        useCases.addAppointment(newAppointment).collect { }
    }

}

