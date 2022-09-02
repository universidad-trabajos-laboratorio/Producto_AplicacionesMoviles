package com.example.producto_aplicacionesmoviles.data.model

import java.util.*


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
    var created_at: Long? = Date().time,
    var last_login_date: Long? = Date().time,
    var active: Boolean? = true
)

