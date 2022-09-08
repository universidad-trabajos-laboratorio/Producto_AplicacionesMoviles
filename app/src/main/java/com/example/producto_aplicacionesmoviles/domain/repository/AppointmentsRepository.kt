package com.example.producto_aplicacionesmoviles.domain.repository

import com.example.producto_aplicacionesmoviles.data.model.Appointment
import com.example.producto_aplicacionesmoviles.data.model.Response
import com.example.producto_aplicacionesmoviles.data.model.SpecialtyDoctor
import kotlinx.coroutines.flow.Flow

interface AppointmentsRepository {
    fun getAppointmentFromFirestore(): Flow<Response<List<Appointment>>>
    fun getAppointmentsByPatientIdFromFirestore(patientId : String): Flow<Response<List<Appointment>>>
    fun getAppointmentsByDateAndPatientIdFromFirestore(date: Long,patientId : String): Flow<Response<List<Appointment>>>
    fun addAppointmentToFirestore(appointment: Appointment): Flow<Response<Void?>>
    fun deleteAppointmentFromFirestore(appointmentId: String): Flow<Response<Void?>>
}