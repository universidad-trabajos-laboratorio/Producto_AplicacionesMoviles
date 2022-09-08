package com.example.producto_aplicacionesmoviles.domain.use_case

import com.example.producto_aplicacionesmoviles.domain.use_case.workday.AddWorkDay
import com.example.producto_aplicacionesmoviles.domain.use_case.workday.DeleteWorkDay
import com.example.producto_aplicacionesmoviles.domain.use_case.workday.GetWorkDays
import com.example.producto_aplicacionesmoviles.domain.use_case.workday.GetWorkDaysByUserId

data class WorkDaysUseCases (
    val getWorkDays: GetWorkDays,
    val getWorkDaysByUserId: GetWorkDaysByUserId,
    val addWorkDay: AddWorkDay,
    val deleteWorkDay: DeleteWorkDay
)
