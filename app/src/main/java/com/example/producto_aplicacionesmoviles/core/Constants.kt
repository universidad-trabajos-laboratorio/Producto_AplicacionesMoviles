package com.example.producto_aplicacionesmoviles.core

object Constants {
    //App
    const val TAG = "AppTag"

    //Firestore
    const val SPECIALTY_COLLECTION_NAME = "specialties"
    const val SPECIALTY_NAME_FIELD = "name"
    const val SPECIALTY_ACTIVE_FIELD = "active"

    const val SPECIALTY_DOCTOR_COLLECTION_NAME = "specialty_doctors"
    const val SPECIALTY_DOCTOR_SPECIALTY_ID_FIELD = "specialty_id"
    const val SPECIALTY_DOCTOR_ACTIVE_FIELD = "active"

    const val USER_COLLECTION_NAME = "users"
    const val USER_ID_FIELD = "id"
    const val USER_AUTHENTICATION_ID_FIELD = "authentication_id"
    const val USER_ACTIVE_FIELD = "active"

    const val WORKDAY_COLLECTION_NAME = "work_days"
    const val WORKDAY_USER_ID_FIELD = "doctor_id"
    const val WORKDAY_ACTIVE_FIELD = "active"

}