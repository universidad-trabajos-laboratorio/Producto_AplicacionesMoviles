package com.example.producto_aplicacionesmoviles.core

import android.util.Log
import com.example.producto_aplicacionesmoviles.core.Constants.TAG
import java.text.SimpleDateFormat
import java.util.*

class Utils {
    companion object {
        fun printMessage(message: String) {
            Log.d(TAG, message)
        }

        fun parseToDate(date: String) : Date{
            val formatter = SimpleDateFormat("yyyy-MM-dd", Locale.getDefault())
            return formatter.parse(date)
        }

        fun getDayOfWeek(i : Int):String{
            var dayName : String = "N/A"
            when(i){
                7 -> dayName = "Domingo"
                1 -> dayName = "Lunes"
                2 -> dayName = "Martes"
                3 -> dayName = "Miercoles"
                4 -> dayName = "Jueves"
                5 -> dayName = "Viernes"
                6 -> dayName = "Sabado"
            }
            return dayName
        }

    }
}