package com.example.producto_aplicacionesmoviles.presentation.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import com.example.producto_aplicacionesmoviles.R
import com.example.producto_aplicacionesmoviles.core.TimeUtils
import com.example.producto_aplicacionesmoviles.core.Utils
import com.example.producto_aplicacionesmoviles.data.model.WorkDay
import com.example.producto_aplicacionesmoviles.databinding.ItemHorarioSpinnerBinding
import com.example.producto_aplicacionesmoviles.presentation.utils.ItemHorario
import java.util.*

class WorkDaySpinnerAdapter(ctx: Context, list:List<ItemHorario>): ArrayAdapter<ItemHorario>(ctx,0,list)  {
    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        return initView(position,convertView,parent)
    }

    override fun getDropDownView(position: Int, convertView: View?, parent: ViewGroup): View {
        return initView(position,convertView,parent)
    }

    private fun initView(position: Int, convertView: View?, parent: ViewGroup): View {
        val itemHorario = getItem(position)!!
        val view = LayoutInflater.from(context).inflate(R.layout.item_horario_spinner,parent,false)
        val binding = ItemHorarioSpinnerBinding.bind(view)

        val day = Utils.getDayOfWeek(itemHorario.day!!.toInt())
        val start = transformDayAmPmToString(itemHorario.start!!)
        val end = transformDayAmPmToString(itemHorario.end!!)


        binding.dia.text = day
        binding.tvHoraManana.text = start
        binding.tvHoraManana.setCompoundDrawablesWithIntrinsicBounds(R.drawable.ic_icon_dia,0,0,0)
        binding.tvHoraTarde.text = end
        binding.tvHoraTarde.setCompoundDrawablesWithIntrinsicBounds(R.drawable.ic_icon_noche,0,0,0)
        return binding.root
    }

    private fun transformDayAmPmToString(morning_start: String): String {
        val hmsDate = TimeUtils.parseToDateFromHMSFormatString(morning_start)
        return TimeUtils.formatDateToAmPmFormatString(hmsDate)
    }

}