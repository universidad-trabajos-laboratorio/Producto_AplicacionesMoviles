package com.example.producto_aplicacionesmoviles.data.model

import java.util.*


data class WorkDay(
    var id : String? = "",
    var doctor_id: String? = "",//userid of doctor
    var day: Int? = 0,// 1 - 7, domingo - sabado
    var morning_start : String? = "07:00:00",
    var morning_end : String? = "07:00:00",
    var afternoon_start : String? = "15:00:00",
    var afternoon_end : String? = "15:00:00",
    var active: Boolean? = true // Active
)
// Horario de atencion para citas de 7 y 12 y de 15 a 20