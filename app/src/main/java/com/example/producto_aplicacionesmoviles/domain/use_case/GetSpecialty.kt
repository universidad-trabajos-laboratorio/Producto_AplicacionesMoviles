package com.example.producto_aplicacionesmoviles.domain.use_case

import com.example.producto_aplicacionesmoviles.domain.repository.SpecialtiesRepository

class GetSpecialty (
    private val repo: SpecialtiesRepository
) {
    operator fun invoke() = repo.getSpecialtiesFromFirestore()
}