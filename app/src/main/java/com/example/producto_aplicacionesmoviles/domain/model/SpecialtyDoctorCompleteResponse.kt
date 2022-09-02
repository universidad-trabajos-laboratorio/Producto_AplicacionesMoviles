package com.example.producto_aplicacionesmoviles.domain.model

import com.example.producto_aplicacionesmoviles.data.model.SpecialtyDoctor
import com.example.producto_aplicacionesmoviles.data.model.User

data class SpecialtyDoctorCompleteResponse(
    var specialty: SpecialtyDoctor,
    var user: User
)