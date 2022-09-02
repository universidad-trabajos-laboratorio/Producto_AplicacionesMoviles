package com.example.producto_aplicacionesmoviles.domain.use_case.users

import com.example.producto_aplicacionesmoviles.domain.repository.UsersRepository

class DeleteUser(
    private val repo: UsersRepository
) {
    operator fun invoke(userId: String) = repo.deleteUserFromFirestore(userId)
}