package com.example.producto_aplicacionesmoviles.domain.use_case.specialtydoctors

import com.example.producto_aplicacionesmoviles.data.model.SpecialtyDoctor
import com.example.producto_aplicacionesmoviles.domain.repository.SpecialtyDoctorsRepository

class AddSpecialtyDoctor(
    private val repo: SpecialtyDoctorsRepository
) {
    operator fun invoke(
        specialtyDoctor: SpecialtyDoctor
    ) = repo.addSpecialtyDoctorToFirestore(specialtyDoctor)
}
