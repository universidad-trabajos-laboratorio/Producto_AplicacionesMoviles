package com.example.producto_aplicacionesmoviles.domain.repository

import com.example.producto_aplicacionesmoviles.data.model.Response
import com.example.producto_aplicacionesmoviles.data.model.Specialty
import kotlinx.coroutines.flow.Flow

interface SpecialtiesRepository {
    fun getSpecialtiesFromFirestore(): Flow<Response<List<Specialty>>>

    fun addSpecialtyToFirestore(name: String, icon: String, active: Boolean): Flow<Response<Void?>>

    fun deleteSpecialtyFromFirestore(specialtyId: String): Flow<Response<Void?>>
}