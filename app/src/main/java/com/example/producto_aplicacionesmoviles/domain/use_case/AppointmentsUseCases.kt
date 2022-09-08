package com.example.producto_aplicacionesmoviles.domain.use_case;

import com.example.producto_aplicacionesmoviles.domain.use_case.appointments.*

data class AppointmentsUseCases (
    val getAppointments :GetAppointments,
    val getAppointmentsByPatientId: GetAppointmentsByPatientId,
    val getAppointmentsByDateAndPatientId: GetAppointmentsByDateAndPatientId,
    val addAppointment: AddAppointment,
    val deleteAppointment: DeleteAppointment
)
