package com.example.producto_aplicacionesmoviles.domain.use_case.specialtydoctors

import com.example.producto_aplicacionesmoviles.domain.repository.SpecialtyDoctorsRepository

class GetSpecialtyDoctors (
    private val repo: SpecialtyDoctorsRepository
) {
    operator fun invoke() = repo.getSpecialtyDoctorsFromFirestore()
}