package com.example.producto_aplicacionesmoviles.data.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Specialty(
    var id : String? = null,
    var name : String? = null,
    var icon : String? = "path/to/default",
    var active:Boolean? = true,
): Parcelable{
    override fun toString(): String {
        return name.toString()
    }
}