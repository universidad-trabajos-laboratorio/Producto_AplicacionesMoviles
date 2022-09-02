package com.example.producto_aplicacionesmoviles.domain.repository

import com.example.producto_aplicacionesmoviles.data.model.Response
import com.example.producto_aplicacionesmoviles.data.model.SpecialtyDoctor
import kotlinx.coroutines.flow.Flow

interface SpecialtyDoctorsRepository {
    fun getSpecialtyDoctorsFromFirestore(): Flow<Response<List<SpecialtyDoctor>>>

    fun getSpecialtyDoctorsBySpecialtyIdFromFirestore(specialtyId : String): Flow<Response<List<SpecialtyDoctor>>>

    fun addSpecialtyDoctorToFirestore(specialtyDoctor: SpecialtyDoctor): Flow<Response<Void?>>

    fun deleteSpecialtyDoctorFromFirestore(specialtyDoctorId: String): Flow<Response<Void?>>
}