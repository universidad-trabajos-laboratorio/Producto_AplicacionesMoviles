package com.example.producto_aplicacionesmoviles.domain.use_case

import com.example.producto_aplicacionesmoviles.domain.repository.SpecialtiesRepository

class AddSpecialty(
    private val repo: SpecialtiesRepository
) {
    operator fun invoke(
        name: String,
        icon: String,
        active : Boolean
    ) = repo.addSpecialtyToFirestore(name, icon, active)
}