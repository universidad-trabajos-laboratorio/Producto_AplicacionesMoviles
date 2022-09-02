package com.example.producto_aplicacionesmoviles.presentation.viewholders

import android.content.res.ColorStateList
import android.graphics.Color
import android.graphics.drawable.Drawable
import android.view.View
import androidx.core.graphics.drawable.DrawableCompat
import androidx.core.widget.TextViewCompat
import androidx.recyclerview.widget.RecyclerView
import com.example.producto_aplicacionesmoviles.R
import com.example.producto_aplicacionesmoviles.data.model.SpecialtyDoctor
import com.example.producto_aplicacionesmoviles.databinding.ItemSpecialtyDoctorBinding

class SpecialtyDoctorViewHolder(view:View):RecyclerView.ViewHolder(view) {
    private val binding = ItemSpecialtyDoctorBinding.bind(view)
    fun bin(specialtyDoctor: SpecialtyDoctor){
        binding.tvName.text = specialtyDoctor.name
        /*val active:Boolean = specialtyDoctor.active?:false

        if(active){
            DrawableCompat.setTint(binding.tvState.compoundDrawables[0], Color.parseColor("#000"))
            binding.tvState.text = "Disponible"
        }else{+
            DrawableCompat.setTint(binding.tvState.compoundDrawables[0], Color.parseColor(R.color.app_titulo.toString()))
            binding.tvState.text = "No Disponible"
        }*/
    }
}