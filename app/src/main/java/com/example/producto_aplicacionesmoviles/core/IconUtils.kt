package com.example.producto_aplicacionesmoviles.core

import com.example.producto_aplicacionesmoviles.R

class IconUtils {
    companion object{
        fun getIdIcon(idIcon:String):Int{
            var id:Int =  when(idIcon){
                "ic_corazon"-> R.drawable.ic_icon_corazon
                "ic_pastilla"-> R.drawable.ic_icon_pastilla
                "ic_estetoscopio"->R.drawable.ic_icon_estetoscopio
                "ic_pulmones"->R.drawable.ic_icon_pulmones
                "ic_nino"->R.drawable.ic_icon_nino
                "ic_virus"->R.drawable.ic_icon_virus
                "ic_tubo"->R.drawable.ic_icon_tubo
                "ic_vaso"->R.drawable.ic_icon_vaso
                "ic_enfermera"->R.drawable.ic_icon_enfermera
                "ic_botiquin"->R.drawable.ic_icon_botiquin
                else -> R.drawable.ic_icon_pastilla
            }

            return id
        }
    }
}