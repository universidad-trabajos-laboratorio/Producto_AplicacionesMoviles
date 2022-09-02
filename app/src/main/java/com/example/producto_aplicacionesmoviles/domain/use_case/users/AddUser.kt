package com.example.producto_aplicacionesmoviles.domain.use_case.users

import com.example.producto_aplicacionesmoviles.data.model.User
import com.example.producto_aplicacionesmoviles.domain.repository.UsersRepository
import java.util.*

class AddUser(
    private val repo: UsersRepository
) {
    operator fun invoke(
        user : User
    ) = repo.addUserToFirestore(user)
}
