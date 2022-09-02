package com.example.producto_aplicacionesmoviles.data.model

import java.util.*


data class SpecialtyDoctor(
    var id : String? = null,
    var user_id: String? = null,
    var specialty_id: String? = null,
    var name: String ?= "Unknown",
    var title: String ?= "S/N",
    var biography:String? = "S/N",
    var enter_date : Long? = Date().time,
    var active: Boolean? = true
)