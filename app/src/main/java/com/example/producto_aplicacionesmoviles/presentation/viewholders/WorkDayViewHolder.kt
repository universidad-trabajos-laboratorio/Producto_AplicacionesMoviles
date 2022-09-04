package com.example.producto_aplicacionesmoviles.presentation.viewholders

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.example.producto_aplicacionesmoviles.core.TimeUtils
import com.example.producto_aplicacionesmoviles.core.Utils
import com.example.producto_aplicacionesmoviles.data.model.WorkDay
import com.example.producto_aplicacionesmoviles.databinding.ItemWorkdayBinding

class WorkDayViewHolder(view: View) : RecyclerView.ViewHolder(view) {
    private val binding = ItemWorkdayBinding.bind(view)

    fun bind(workDay: WorkDay) {
        val day = Utils.getDayOfWeek(workDay.day!!.toInt())
        var timeMessage = transformMessageTimeWorkDay(workDay)
        val message = "$day :  $timeMessage"
        if(timeMessage.isNotEmpty()){
            binding.dayWorkMessage.text = message
        }
    }

    private fun transformDayAmPmToString(morning_start: String): String {
        val hmsDate = TimeUtils.parseToDateFromHMSFormatString(morning_start)
        return TimeUtils.formatDateToAmPmFormatString(hmsDate)
    }

    private fun transformMessageTimeWorkDay(workDay: WorkDay): String {
        val morning_start = transformDayAmPmToString(workDay.morning_start!!)
        val morning_end = transformDayAmPmToString(workDay.morning_end!!)
        val afternoon_start = transformDayAmPmToString(workDay.afternoon_start!!)
        val afternoon_end = transformDayAmPmToString(workDay.afternoon_end!!)
        var messageMorning = "$morning_start a $morning_end"
        var messageAfternoon = "$afternoon_start a $afternoon_end"
        var timeMessage = ""
        if (morning_start == morning_end) {
            timeMessage = "De $messageAfternoon"
            if (afternoon_start == afternoon_end) {
                timeMessage = ""
            }
        } else {
            timeMessage = "De $messageMorning"
            if (afternoon_start != afternoon_end) {
                timeMessage += " y de $messageAfternoon"
            }
        }

        return timeMessage
    }
}