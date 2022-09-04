package com.example.producto_aplicacionesmoviles.domain.use_case.workday

import com.example.producto_aplicacionesmoviles.domain.repository.WorkDaysRepository

class GetWorkDaysByUserId (
    private val repo: WorkDaysRepository
) {
    operator fun invoke(user_id: String) = repo.getWorkDaysByUserIdFromFirestore(user_id)
}