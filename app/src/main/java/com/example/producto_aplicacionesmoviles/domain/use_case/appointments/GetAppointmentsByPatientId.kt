package com.example.producto_aplicacionesmoviles.domain.use_case.appointments

import com.example.producto_aplicacionesmoviles.domain.repository.AppointmentsRepository

class GetAppointmentsByPatientId (
    private val repo: AppointmentsRepository
) {
    operator fun invoke(patientId: String) = repo.getAppointmentsByPatientIdFromFirestore(patientId)
}