package com.example.producto_aplicacionesmoviles.domain.use_case.users

import com.example.producto_aplicacionesmoviles.domain.repository.UsersRepository

class GetUsers (
    private val repo: UsersRepository
) {
    operator fun invoke() = repo.getUsersFromFirestore()
}