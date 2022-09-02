package com.example.producto_aplicacionesmoviles.presentation.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.producto_aplicacionesmoviles.R
import com.example.producto_aplicacionesmoviles.data.model.SpecialtyDoctor
import com.example.producto_aplicacionesmoviles.presentation.viewholders.SpecialtyDoctorViewHolder

class SpecialtyDoctorAdapter(private val specialtyDoctorList:List<SpecialtyDoctor>):RecyclerView.Adapter<SpecialtyDoctorViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SpecialtyDoctorViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        return SpecialtyDoctorViewHolder(layoutInflater.inflate(R.layout.item_specialty_doctor,parent,false))
    }

    override fun onBindViewHolder(holder: SpecialtyDoctorViewHolder, position: Int) {
        holder.bin(specialtyDoctorList[position])
    }

    override fun getItemCount(): Int {
        return specialtyDoctorList.size
    }
}