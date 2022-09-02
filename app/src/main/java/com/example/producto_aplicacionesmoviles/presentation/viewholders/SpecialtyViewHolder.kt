package com.example.producto_aplicacionesmoviles.presentation.viewholders

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.example.producto_aplicacionesmoviles.data.model.Specialty
import com.example.producto_aplicacionesmoviles.databinding.ItemEspecialtyBinding

class SpecialtyViewHolder(view: View,) : RecyclerView.ViewHolder(view) {
    private val binding = ItemEspecialtyBinding.bind(view)
    fun bin(specialty: Specialty, onClickListener:(specialtyId:String)->Unit){
        binding.tvName.text = specialty.name.toString()
        itemView.setOnClickListener{
            onClickListener(specialty.id?:"")
        }
    }
}