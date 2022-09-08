package com.example.producto_aplicacionesmoviles.domain.use_case.appointments

import com.example.producto_aplicacionesmoviles.data.model.Appointment
import com.example.producto_aplicacionesmoviles.domain.repository.AppointmentsRepository

class AddAppointment(
    private val repo: AppointmentsRepository
) {
    operator fun invoke(
        appointment: Appointment
    ) = repo.addAppointmentToFirestore(appointment)
}
