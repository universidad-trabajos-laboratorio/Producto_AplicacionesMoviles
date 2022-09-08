package com.example.producto_aplicacionesmoviles.domain.use_case.appointments

import com.example.producto_aplicacionesmoviles.domain.repository.AppointmentsRepository

class GetAppointmentsByDateAndPatientId (
    private val repo: AppointmentsRepository
) {
    operator fun invoke(date:Long, patientId: String) = repo.getAppointmentsByDateAndPatientIdFromFirestore(date, patientId)
}