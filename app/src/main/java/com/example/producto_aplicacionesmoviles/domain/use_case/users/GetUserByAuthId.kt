package com.example.producto_aplicacionesmoviles.domain.use_case.users

import com.example.producto_aplicacionesmoviles.domain.repository.UsersRepository

class GetUserByAuthId (
    private val repo: UsersRepository
) {
    operator fun invoke(user_id: String) = repo.getUserByAuthIdFromFirestore(user_id)
}