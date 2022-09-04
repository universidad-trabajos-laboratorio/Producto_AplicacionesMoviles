package com.example.producto_aplicacionesmoviles.domain.repository

import com.example.producto_aplicacionesmoviles.data.model.Response
import com.example.producto_aplicacionesmoviles.data.model.SpecialtyDoctor
import com.example.producto_aplicacionesmoviles.data.model.User
import com.example.producto_aplicacionesmoviles.data.model.WorkDay
import kotlinx.coroutines.flow.Flow

interface WorkDaysRepository {
    fun getWorkDaysFromFirestore(): Flow<Response<List<WorkDay>>>
    fun getWorkDaysByUserIdFromFirestore(user_id : String): Flow<Response<List<WorkDay>>>
    fun addWorkDayToFirestore(workDay: WorkDay): Flow<Response<Void?>>
    fun deleteWorkDayFromFirestore(workday_id: String): Flow<Response<Void?>>
}