package com.example.producto_aplicacionesmoviles.presentation.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.producto_aplicacionesmoviles.R
import com.example.producto_aplicacionesmoviles.data.model.Specialty
import com.example.producto_aplicacionesmoviles.presentation.viewholders.SpecialtyViewHolder

class SpecialtyAdapter(private val specialtyList: List<Specialty>,private val onClickListener:(specialtyId:String)->Unit) :
    RecyclerView.Adapter<SpecialtyViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SpecialtyViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        return SpecialtyViewHolder(layoutInflater.inflate(R.layout.item_especialty,parent,false))
    }

    override fun onBindViewHolder(holder: SpecialtyViewHolder, position: Int) {
        holder.bin(specialtyList[position],onClickListener)

    }

    override fun getItemCount(): Int {
        return specialtyList.size
    }
}