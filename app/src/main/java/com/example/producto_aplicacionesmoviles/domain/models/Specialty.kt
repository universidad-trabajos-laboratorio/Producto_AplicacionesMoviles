package com.example.producto_aplicacionesmoviles.domain.models

import org.json.JSONArray
import org.json.JSONObject

data class Specialty(
    var id : String? = null,
    var name : String? = null,
    var icon : String? = null
){
    companion object {
        fun fromJson(json: String): Specialty {
            val jsonObj = JSONObject(json)
            val specialty = Specialty()
            specialty.name = jsonObj.getString("name")
            specialty.icon = jsonObj.getString("icon")

            return specialty
        }

        fun fromJsonArr(jsons: String): List<Specialty> {
            val jsonArr = JSONArray(jsons)
            val specialties = ArrayList<Specialty>()

            for(i in 0 until jsonArr.length()){
                val obj = jsonArr.get(i) as JSONObject
                val specialty = Specialty()
                specialty.name = obj.getString("name")
                specialty.icon = obj.getString("icon")
                specialties.add(specialty)
            }
            return specialties
        }
    }
}