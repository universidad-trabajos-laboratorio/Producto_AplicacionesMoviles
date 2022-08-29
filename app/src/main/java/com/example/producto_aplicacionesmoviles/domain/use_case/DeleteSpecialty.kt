package com.example.producto_aplicacionesmoviles.domain.use_case

import com.example.producto_aplicacionesmoviles.domain.repository.SpecialtiesRepository

class DeleteSpecialty(
    private val repo: SpecialtiesRepository
) {
    operator fun invoke(specialtyId: String) = repo.deleteSpecialtyFromFirestore(specialtyId)
}