package com.example.producto_aplicacionesmoviles.domain.use_case

import com.example.producto_aplicacionesmoviles.domain.use_case.users.*

data class UserUseCases (
    val getUsers: GetUsers,
    val getUserById : GetUserByUserId,
    val getUserByAuthId: GetUserByAuthId,
    val addUser: AddUser,
    val deleteUser: DeleteUser
)
