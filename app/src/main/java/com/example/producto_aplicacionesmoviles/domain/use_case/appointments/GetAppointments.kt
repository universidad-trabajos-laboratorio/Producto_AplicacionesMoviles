package com.example.producto_aplicacionesmoviles.domain.use_case.appointments

import com.example.producto_aplicacionesmoviles.domain.repository.AppointmentsRepository

class GetAppointments (
    private val repo: AppointmentsRepository
) {
    operator fun invoke() = repo.getAppointmentFromFirestore()
}