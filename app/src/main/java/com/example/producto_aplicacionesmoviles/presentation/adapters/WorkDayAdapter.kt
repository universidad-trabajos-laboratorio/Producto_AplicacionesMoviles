package com.example.producto_aplicacionesmoviles.presentation.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.producto_aplicacionesmoviles.R
import com.example.producto_aplicacionesmoviles.data.model.WorkDay
import com.example.producto_aplicacionesmoviles.presentation.viewholders.WorkDayViewHolder

class WorkDayAdapter(private val listWorkDay:List<WorkDay>):RecyclerView.Adapter<WorkDayViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): WorkDayViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        return WorkDayViewHolder(layoutInflater.inflate(R.layout.item_workday,parent,false))
    }

    override fun onBindViewHolder(holder: WorkDayViewHolder, position: Int) {
        holder.bind(listWorkDay[position])
    }

    override fun getItemCount(): Int {
        return listWorkDay.size
    }
}