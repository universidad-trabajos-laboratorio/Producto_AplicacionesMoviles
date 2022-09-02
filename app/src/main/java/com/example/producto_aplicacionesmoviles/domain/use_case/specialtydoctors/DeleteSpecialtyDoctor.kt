package com.example.producto_aplicacionesmoviles.domain.use_case.specialtydoctors

import com.example.producto_aplicacionesmoviles.domain.repository.SpecialtyDoctorsRepository

class DeleteSpecialtyDoctor(
    private val repo: SpecialtyDoctorsRepository
) {
    operator fun invoke(specialtyDoctorId: String) = repo.deleteSpecialtyDoctorFromFirestore(specialtyDoctorId)
}