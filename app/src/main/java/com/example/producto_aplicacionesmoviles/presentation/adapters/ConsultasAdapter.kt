package com.example.producto_aplicacionesmoviles.presentation.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.producto_aplicacionesmoviles.R
import com.example.producto_aplicacionesmoviles.data.model.Appointment
import com.example.producto_aplicacionesmoviles.presentation.viewholders.ConsultasViewHolder

class ConsultasAdapter(private val consultas: List<Appointment>): RecyclerView.Adapter<ConsultasViewHolder>(){
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ConsultasViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        return ConsultasViewHolder(layoutInflater.inflate(R.layout.item_consultas_pendientes,parent,false))
    }

    override fun onBindViewHolder(holder: ConsultasViewHolder, position: Int) {
        holder.bin(consultas[position])
    }

    override fun getItemCount(): Int {
        return consultas.size
    }
}