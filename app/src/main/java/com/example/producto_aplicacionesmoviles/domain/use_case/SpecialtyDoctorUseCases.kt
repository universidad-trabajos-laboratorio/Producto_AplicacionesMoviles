package com.example.producto_aplicacionesmoviles.domain.use_case

import com.example.producto_aplicacionesmoviles.domain.use_case.specialtydoctors.AddSpecialtyDoctor
import com.example.producto_aplicacionesmoviles.domain.use_case.specialtydoctors.DeleteSpecialtyDoctor
import com.example.producto_aplicacionesmoviles.domain.use_case.specialtydoctors.GetSpecialtyDoctors
import com.example.producto_aplicacionesmoviles.domain.use_case.specialtydoctors.GetSpecialtyDoctorsBySpecialtyId

data class SpecialtyDoctorUseCases (
    val getSpecialtyDoctors: GetSpecialtyDoctors,
    val getSpecialtyDoctorsBySpecialtyId: GetSpecialtyDoctorsBySpecialtyId,
    val addSpecialtyDoctor: AddSpecialtyDoctor,
    val deleteSpecialtyDoctor: DeleteSpecialtyDoctor
)
