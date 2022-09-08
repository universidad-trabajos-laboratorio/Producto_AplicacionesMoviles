package com.example.producto_aplicacionesmoviles.presentation.viewholders

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.example.producto_aplicacionesmoviles.core.IconUtils
import com.example.producto_aplicacionesmoviles.data.model.Appointment
import com.example.producto_aplicacionesmoviles.data.model.Specialty
import com.example.producto_aplicacionesmoviles.databinding.ItemConsultasPendientesBinding


class ConsultasViewHolder(view:View):RecyclerView.ViewHolder(view) {
    private val binding = ItemConsultasPendientesBinding.bind(view)
    fun bin(consulta: Appointment){
        binding.tvState.text = consulta.status
        binding.tvSpecialty.text = consulta.specialty_id
        binding.tvDate.text = consulta.scheduled_time
    }
}