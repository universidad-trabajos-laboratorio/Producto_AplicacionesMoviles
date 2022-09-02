package com.example.producto_aplicacionesmoviles.domain.use_case

import com.example.producto_aplicacionesmoviles.domain.use_case.users.AddUser
import com.example.producto_aplicacionesmoviles.domain.use_case.users.DeleteUser
import com.example.producto_aplicacionesmoviles.domain.use_case.users.GetUsers

data class UserUseCases (
    val getUsers: GetUsers,
    val addUser: AddUser,
    val deleteUser: DeleteUser
)
