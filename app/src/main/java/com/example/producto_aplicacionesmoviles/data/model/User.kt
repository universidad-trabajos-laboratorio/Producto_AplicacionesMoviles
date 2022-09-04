package com.example.producto_aplicacionesmoviles.data.model

import com.example.producto_aplicacionesmoviles.core.TimeUtils


data class User(
    var id : String? = null,
    var authentication_id : String? = null,
    var email : String = "",
    var name : String = "",
    var gender: String? = "None",
    var document_type: String = "",
    var document_number: String = "",
    var rol: String? = "patient", //admin, patient, doctor, ver si usamos rol o rol_id
    var profile_img : String? = "path/to/default.jpg",
    var created_at: Long? = TimeUtils.getActualDateInLima().time,
    var last_login_date: Long? = TimeUtils.getActualDateInLima().time,
    var active: Boolean? = true
)

