package com.example.producto_aplicacionesmoviles.domain.use_case.workday

import com.example.producto_aplicacionesmoviles.data.model.WorkDay
import com.example.producto_aplicacionesmoviles.domain.repository.WorkDaysRepository

class AddWorkDay(
    private val repo: WorkDaysRepository
) {
    operator fun invoke(
        workDay: WorkDay
    ) = repo.addWorkDayToFirestore(workDay)
}
