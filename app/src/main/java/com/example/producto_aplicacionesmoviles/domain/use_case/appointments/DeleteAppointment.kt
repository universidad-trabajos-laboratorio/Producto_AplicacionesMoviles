package com.example.producto_aplicacionesmoviles.domain.use_case.appointments

import com.example.producto_aplicacionesmoviles.domain.repository.AppointmentsRepository

class DeleteAppointment(
    private val repo: AppointmentsRepository
) {
    operator fun invoke(appointmentId: String) = repo.deleteAppointmentFromFirestore(appointmentId)
}