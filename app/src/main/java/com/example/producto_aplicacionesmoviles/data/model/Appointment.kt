package com.example.producto_aplicacionesmoviles.data.model

import java.util.*


data class Appointment(
    var id : String? = "",
    var specialty_id: String? = "",
    var doctor_id: String? = "",//userid of doctor
    var patient_id: String? = "",
    var type: String? = "",
    var description: String? = "",
    var scheduled_date : Long? = Date().time,
    var scheduled_time : Long? = Date().time,
    var status: String? = "" // Reservada, Confirmada, Atendida, Cancelada
)