package com.example.producto_aplicacionesmoviles.ui.specialty

import androidx.recyclerview.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.TextView

import com.example.producto_aplicacionesmoviles.databinding.SpecialtyFragmentItemBinding
import com.example.producto_aplicacionesmoviles.domain.models.Specialty

/**
 * [RecyclerView.Adapter] that can display a [Specialty].
 * TODO: Replace the implementation with code for your data type.
 */
class MyItemRecyclerViewAdapter(
    private val values: List<Specialty>
) : RecyclerView.Adapter<MyItemRecyclerViewAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {

        return ViewHolder(
            SpecialtyFragmentItemBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )

    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = values[position]
        holder.idView.text = item.id
        holder.contentView.text = item.name
    }

    override fun getItemCount(): Int = values.size

    inner class ViewHolder(binding: SpecialtyFragmentItemBinding) :
        RecyclerView.ViewHolder(binding.root) {
        val idView: TextView = binding.itemNumber
        val contentView: TextView = binding.content

        override fun toString(): String {
            return super.toString() + " '" + contentView.text + "'"
        }
    }

}