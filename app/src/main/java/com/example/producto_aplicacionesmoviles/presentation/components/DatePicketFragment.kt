package com.example.producto_aplicacionesmoviles.presentation.components

import android.app.DatePickerDialog
import android.app.Dialog
import android.os.Bundle
import android.widget.DatePicker
import androidx.fragment.app.DialogFragment
import java.util.*

class DatePicketFragment(val listener:(day:Int,month:Int,year:Int)->Unit):DialogFragment(),DatePickerDialog.OnDateSetListener {
    override fun onDateSet(view: DatePicker?, year: Int, month: Int, dayOfMonth: Int) {
        listener(dayOfMonth,month,year)
    }

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        val calendar = Calendar.getInstance()
        val day = calendar.get(Calendar.DAY_OF_MONTH)
        val month = calendar.get(Calendar.MONTH)
        val year = calendar.get(Calendar.YEAR)
        val picker = DatePickerDialog(this.requireContext(),this,year,month,day)
        picker.datePicker.minDate = calendar.timeInMillis
        calendar.add(Calendar.DAY_OF_MONTH,+6)
        picker.datePicker.maxDate = calendar.timeInMillis
        return picker
    }


}