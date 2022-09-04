package com.example.producto_aplicacionesmoviles.presentation.viewholders

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.example.producto_aplicacionesmoviles.R
import com.example.producto_aplicacionesmoviles.data.model.SpecialtyDoctor
import com.example.producto_aplicacionesmoviles.databinding.ItemSpecialtyDoctorBinding

class SpecialtyDoctorViewHolder(view:View):RecyclerView.ViewHolder(view) {
    private val binding = ItemSpecialtyDoctorBinding.bind(view)
    fun bin(specialtyDoctor: SpecialtyDoctor,onClickListener:(doctor:SpecialtyDoctor)->Unit){
        binding.tvName.text = specialtyDoctor.name
        val active:Boolean = specialtyDoctor.active?:false

        if(active){
            binding.tvState.setCompoundDrawablesWithIntrinsicBounds(R.drawable.circle_success,0,0,0)
            binding.tvState.text = "Disponible"
        }else{
        binding.tvState.setCompoundDrawablesWithIntrinsicBounds(R.drawable.circle_danger,0,0,0)
            binding.tvState.text = "No Disponible"
        }
        binding.ivPhoto.setOnClickListener{
            onClickListener(specialtyDoctor)
        }
        binding.btnSpecialtyDoctor.setOnClickListener{
            onClickListener(specialtyDoctor)
        }
    }
}