package com.example.producto_aplicacionesmoviles.core

import java.text.SimpleDateFormat
import java.util.*
import java.util.concurrent.TimeUnit

class TimeUtils {
    companion object {

        fun getHourMinuteSecondFormattedStringFromDate(date : Date) : String{
            var formatter = SimpleDateFormat("HH:mm:ss")
            return formatter.format(date)
        }

        fun getHMSFormattedDateFromString(date : String) : Date{
            var formatter = SimpleDateFormat("HH:mm:ss")
            return formatter.parse(date)
        }

        fun getElapsedTimeInHumanReadableFormatFromTimestamp(timestamp : Long, scale : Int= 2) : String{
            return getHumanReadableFormat(getTimeElapsed(timestamp).toInt(), scale = scale)
        }

        private fun getTimeElapsed(timestamp : Long) : Long{
            var actualDate : Date = getActualDateInLima()
            var startDate : Date = getDateFromTimestamp(timestamp)

            var diffInMs : Long = actualDate.getTime() - startDate.getTime()
            var diffInSec : Long = TimeUnit.MILLISECONDS.toSeconds(diffInMs)
            return diffInSec
        }

        private fun getActualDateInLima() : Date {
            var limaTimeZone : TimeZone = TimeZone.getTimeZone("America/Lima")
            var formatter : SimpleDateFormat = SimpleDateFormat("yyyy-MM-dd HH:mm:ss")
            formatter.setTimeZone(limaTimeZone)
            var actualDateInLima : String = formatter.format(Date())

            formatter = SimpleDateFormat("yyyy-MM-dd HH:mm:ss")
            return formatter.parse(actualDateInLima)
        }

        private fun getDateFromTimestamp(timestamp : Long) : Date{
            var limaTimeZone : TimeZone = TimeZone.getTimeZone("America/Lima")
            var formatter : SimpleDateFormat = SimpleDateFormat("yyyy-MM-dd HH:mm:ss")
            formatter.setTimeZone(limaTimeZone)
            var dateInLima : String = formatter.format(Date(timestamp))

            formatter = SimpleDateFormat("yyyy-MM-dd HH:mm:ss")
            return formatter.parse(dateInLima)
        }

        //Scale ->
        // 4: hasta segundos,
        // 3: hasta minutos,
        // 2: hasta horas,
        // 1: hasta dias,
        // 0: hasta años
        private fun getHumanReadableFormat(secondsElapsed : Int, scale : Int) : String {

            if(scale < 0 || scale > 4) {return "invalid scale"}
            var res : String = ""
            var seconds : Int = secondsElapsed
            val units = listOf(31536000, 86400, 3600, 60, 1)
            val labels = listOf("year", "day", "hour", "minute", "second")

            if (seconds == 0) return "now"

            for (i in 0..scale) {
                if ( seconds >= units[i] ) {
                    val q : Int = seconds / units[i]
                    seconds = seconds % units[i]
                    var units_word_separator : String =  ", "
                    var plural : String = ""
                    if(seconds == 0){units_word_separator = " and " }
                    if(q > 1){plural = "s"}
                    if(res != ""){
                        res += units_word_separator
                    }
                    res += q.toString() + " " + labels[i] + plural
                }
            }
            return res
        }

    }

}