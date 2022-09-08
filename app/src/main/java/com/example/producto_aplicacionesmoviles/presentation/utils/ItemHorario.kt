package com.example.producto_aplicacionesmoviles.presentation.utils

import com.example.producto_aplicacionesmoviles.core.TimeUtils

data class ItemHorario (
    var day: Int? = 0,// 1 - 7, domingo - sabado
    var start : String? = "07:00:00",
    var end : String? = "07:00:00",
){
    override fun toString(): String {
        return "${start?.let { transformDayAmPmToString(it) }} - ${end?.let { transformDayAmPmToString(it) }}"
    }
    private fun transformDayAmPmToString(morning_start: String): String {
        val hmsDate = TimeUtils.parseToDateFromHMSFormatString(morning_start)
        return TimeUtils.formatDateToAmPmFormatString(hmsDate)
    }
}