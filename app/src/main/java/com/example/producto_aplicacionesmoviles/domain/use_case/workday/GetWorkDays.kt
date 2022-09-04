package com.example.producto_aplicacionesmoviles.domain.use_case.workday

import com.example.producto_aplicacionesmoviles.domain.repository.WorkDaysRepository

class GetWorkDays (
    private val repo: WorkDaysRepository
) {
    operator fun invoke() = repo.getWorkDaysFromFirestore()
}