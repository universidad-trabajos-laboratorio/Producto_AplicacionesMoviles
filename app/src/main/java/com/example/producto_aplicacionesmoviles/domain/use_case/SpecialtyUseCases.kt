package com.example.producto_aplicacionesmoviles.domain.use_case

import com.example.producto_aplicacionesmoviles.domain.use_case.specialty.AddSpecialty
import com.example.producto_aplicacionesmoviles.domain.use_case.specialty.DeleteSpecialty
import com.example.producto_aplicacionesmoviles.domain.use_case.specialty.GetSpecialty

data class SpecialtyUseCases (
    val getSpecialty: GetSpecialty,
    val addSpecialty: AddSpecialty,
    val deleteSpecialty: DeleteSpecialty
)