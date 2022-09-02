package com.example.producto_aplicacionesmoviles.domain.use_case.specialtydoctors

import com.example.producto_aplicacionesmoviles.domain.repository.SpecialtyDoctorsRepository

class GetSpecialtyDoctorsBySpecialtyId (
    private val repo: SpecialtyDoctorsRepository
) {
    operator fun invoke(specialtyId: String) = repo.getSpecialtyDoctorsBySpecialtyIdFromFirestore(specialtyId)
}