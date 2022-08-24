package com.example.producto_aplicacionesmoviles.domain.repository

import com.example.producto_aplicacionesmoviles.domain.models.Response
import com.example.producto_aplicacionesmoviles.domain.models.Specialty
import kotlinx.coroutines.flow.Flow

interface SpecialtiesRepository {
    fun getSpecialtiesFromFirestore(): Flow<Response<List<Specialty>>>

    fun addSpecialtyToFirestore(name: String, icon: String): Flow<Response<Void?>>

    fun deleteSpecialtyFromFirestore(specialtyId: String): Flow<Response<Void?>>
}