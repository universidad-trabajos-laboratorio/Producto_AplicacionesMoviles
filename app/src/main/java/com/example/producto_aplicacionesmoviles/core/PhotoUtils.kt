package com.example.producto_aplicacionesmoviles.core

import com.example.producto_aplicacionesmoviles.R
class PhotoUtils {
    companion object{
        fun getNamePhoto(idPhoto:String):Int{
            var photo:Int =  when (idPhoto){
                "Melio Diaz Diaz"->R.drawable.doctor1
                "Abel Llontop Meza"->R.drawable.doctor2
                else->R.drawable.doctor3
            }

            return photo
        }
    }
}