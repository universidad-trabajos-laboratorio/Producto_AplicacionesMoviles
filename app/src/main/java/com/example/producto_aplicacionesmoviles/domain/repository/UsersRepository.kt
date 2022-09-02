package com.example.producto_aplicacionesmoviles.domain.repository

import com.example.producto_aplicacionesmoviles.data.model.Response
import com.example.producto_aplicacionesmoviles.data.model.User
import kotlinx.coroutines.flow.Flow

interface UsersRepository {
    fun getUsersFromFirestore(): Flow<Response<List<User>>>
    fun getUserByUserIdFromFirestore(user_id: String): Flow<Response<User?>>
    fun addUserToFirestore(user: User): Flow<Response<Void?>>
    fun deleteUserFromFirestore(user_id: String): Flow<Response<Void?>>
}