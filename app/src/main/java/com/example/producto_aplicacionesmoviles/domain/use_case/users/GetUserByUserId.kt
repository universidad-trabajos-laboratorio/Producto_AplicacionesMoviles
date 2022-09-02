package com.example.producto_aplicacionesmoviles.domain.use_case.users

import com.example.producto_aplicacionesmoviles.domain.repository.UsersRepository

class GetUserByUserId (
    private val repo: UsersRepository
) {
    operator fun invoke(user_id: String) = repo.getUserByUserIdFromFirestore(user_id)
}
