package com.example.producto_aplicacionesmoviles.presentation.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import com.example.producto_aplicacionesmoviles.R
import com.example.producto_aplicacionesmoviles.core.PhotoUtils
import com.example.producto_aplicacionesmoviles.data.model.SpecialtyDoctor
import com.example.producto_aplicacionesmoviles.databinding.ItemSpecialtydoctorSpinnerBinding

class SpecialtyDoctorSpinnerAdapter(ctx: Context, list:List<SpecialtyDoctor>): ArrayAdapter<SpecialtyDoctor>(ctx,0,list) {
    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        return initView(position,convertView,parent)
    }

    override fun getDropDownView(position: Int, convertView: View?, parent: ViewGroup): View {
        return initView(position,convertView,parent)
    }

    private fun initView(position: Int, convertView: View?, parent: ViewGroup): View {
        val specialtyDoctor = getItem(position)!!
        val view = LayoutInflater.from(context).inflate(R.layout.item_specialtydoctor_spinner,parent,false)
        val binding = ItemSpecialtydoctorSpinnerBinding.bind(view)
        binding.tvName.text = "Dr. "+specialtyDoctor.name
        binding.tvSpecialty.text = specialtyDoctor.title
        binding.ivIcon.setImageResource(PhotoUtils.getNamePhoto(specialtyDoctor.name?:" "))
        return binding.root
    }

}