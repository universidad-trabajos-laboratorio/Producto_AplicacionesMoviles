package com.example.producto_aplicacionesmoviles.presentation.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import com.example.producto_aplicacionesmoviles.R
import com.example.producto_aplicacionesmoviles.core.IconUtils
import com.example.producto_aplicacionesmoviles.data.model.Specialty
import com.example.producto_aplicacionesmoviles.databinding.ItemSpecialtySpinnerBinding

class SpecialtySpinnerAdapter(ctx:Context,list:List<Specialty>): ArrayAdapter<Specialty>(ctx,0,list) {
    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        return initView(position,convertView,parent)
    }

    override fun getDropDownView(position: Int, convertView: View?, parent: ViewGroup): View {
        return initView(position,convertView,parent)
    }

    private fun initView(position: Int, convertView: View?, parent: ViewGroup):View{
        val specialty = getItem(position)!!
        val view = LayoutInflater.from(context).inflate(R.layout.item_specialty_spinner,parent,false)
        val binding = ItemSpecialtySpinnerBinding.bind(view)
        binding.tvName.text = specialty.name
        binding.ivIcon.setImageResource(IconUtils.getIdIcon(specialty.icon?:" "))
        return binding.root
    }


}