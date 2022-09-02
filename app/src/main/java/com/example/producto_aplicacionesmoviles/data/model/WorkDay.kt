package com.example.producto_aplicacionesmoviles.data.model

import java.util.*


data class WorkDay(
    var id : String? = "",
    var doctor_id: String? = "",//userid of doctor
    var day: Number? = 0,// 1 - 7, lunes - viernes
    var morning_start : Long? = Date().time,
    var morning_end : Long? = Date().time,
    var afternoon_start : Long? = Date().time,
    var afternoon_end : Long? = Date().time,
    var active: Boolean? = true // Active
)