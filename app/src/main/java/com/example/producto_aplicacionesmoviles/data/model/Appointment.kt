package com.example.producto_aplicacionesmoviles.data.model

import com.example.producto_aplicacionesmoviles.core.TimeUtils
import java.util.*


data class Appointment(
    var id : String? = "",
    var specialty_id: String? = "",
    var doctor_id: String? = "",//userid of doctor
    var patient_id: String? = "",
    var type: String? = "", //['Consulta', 'Examen', 'Operación']
    var description: String? = "",
    var scheduled_date : Long? = TimeUtils.getActualDateInLima().time,
    var scheduled_time : String? = "01:00:00",
    var status: String? = "" // Reservada, Confirmada, Atendida, Cancelada
)