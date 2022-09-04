package com.example.producto_aplicacionesmoviles.domain.use_case.workday

import com.example.producto_aplicacionesmoviles.domain.repository.WorkDaysRepository

class DeleteWorkDay(
    private val repo: WorkDaysRepository
) {
    operator fun invoke(workday_id: String) = repo.deleteWorkDayFromFirestore(workday_id)
}