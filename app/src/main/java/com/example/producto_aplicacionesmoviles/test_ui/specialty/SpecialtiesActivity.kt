package com.example.producto_aplicacionesmoviles.test_ui.specialty

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import com.example.producto_aplicacionesmoviles.R
import com.example.producto_aplicacionesmoviles.data.model.Specialty
import com.example.producto_aplicacionesmoviles.data.model.SpecialtyDoctor
import com.example.producto_aplicacionesmoviles.data.model.User
import com.example.producto_aplicacionesmoviles.viewmodels.SpecialtyDoctorsViewModel
import com.example.producto_aplicacionesmoviles.viewmodels.SpecialtyViewModel
import com.example.producto_aplicacionesmoviles.viewmodels.UsersViewModel
import dagger.hilt.android.AndroidEntryPoint
import java.util.*


@AndroidEntryPoint
class SpecialtiesActivity : AppCompatActivity() {
    private val specialtyViewModel: SpecialtyViewModel by viewModels()
    private val userViewModel: UsersViewModel by viewModels()
    private val specialtyDoctorsViewModel: SpecialtyDoctorsViewModel by viewModels()
    var i = 0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_specialties_test)
        /*if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                .replace(R.id.container, ItemFragment.newInstance(1))
                .commitNow()
        }*/
        //uploadSpecialties(i)
        //uploadUsers(i)
        uploadSpecialtyDoctors(i)
        i += 1
    }

    fun uploadUsers(i: Int){
        /*if(i==0){
            val jsonArr = JSONArray( application.assets.open("users.json").bufferedReader().use{
                it.readText()
            })
        }*/
        val list : List<User> = listOf(
            User(authentication_id = "wFmcecyvRPUUMIfroXEb5FYtQKw1",
                email = "allontopmeza@gmail.com",
                name = "Abel Llontop Meza",
                gender = "Masculine",
                document_type = "DNI",
                document_number = "00000000",
                rol = "doctor",
                active = true),
            User(authentication_id = "EXj8oAU7v6R4rvArcwJo6nctres1",
                email = "melodiaz2111@gmail.com",
                name = "Melio Diaz Diaz",
                gender = "Masculine",
                document_type = "DNI",
                document_number = "00000000",
                rol = "doctor",
                active = true),
            User(authentication_id = "p4FpjbavXEdxq0ZioTjwajNmVu12",
                email = "enfermoncia@gmail.com",
                name = "Enfermoncia Salinas de la Cruz",
                gender = "Feminine",
                document_type = "DNI",
                document_number = "00000000",
                rol = "patient",
                active = true)
        )
        list.forEach { user ->
            userViewModel.addUser(
                authentication_id =  user.authentication_id?:"",
                email = user.email,
                name = user.name,
                gender = user.gender?:"None",
                document_type = user.document_type,
                document_number = user.document_number,
                rol = user.rol?:"patient",
                profile_img = user.profile_img?:"path/to/default.jpg",
                created_at = user.created_at?: Date().time,
                last_login_date = user.last_login_date?: Date().time,
                active = user.active?: true
            )
        }

    }
    fun uploadSpecialties(i: Int){
        val list : List<Specialty> = listOf(
            Specialty(
                name = "Pediatría",
                icon = "path/to/icon",
                active = true
            ),
            Specialty(
                name = "Ginecología",
                icon = "path/to/icon",
                active = true
            ),
            Specialty(
                name = "Medicina General",
                icon = "path/to/icon",
                active = true
            ),
            Specialty(
                name = "Neumología",
                icon = "path/to/icon",
                active = true
            )
        )
        list.forEach { specialty ->
            specialtyViewModel.addSpeciality(specialty.name?:"",
                specialty.icon?:"", specialty.active?:true)
        }
    }

    fun uploadSpecialtyDoctors(i: Int){
        /*var listaS : List<Specialty> = emptyList()
        var listaU : List<User> = emptyList()

        specialtyViewModel.specialtiesResponse.observe(
            { this.lifecycle },
            { specialties ->
                listaS = specialties
            }
        )
        userViewModel.usersResponse.observe(
            { this.lifecycle },
            { users ->
                listaU = users
            }
        )*/

        val list : List<SpecialtyDoctor> = listOf(
            SpecialtyDoctor(
                user_id = "nFuW9zT7zJB0WQsGZ3vF",
                specialty_id = "VbsxlFeOoiWxd09tG0d5",
                name = "Melio Diaz Diaz",
                title = "Doctor especializado en Neumología",
                biography = "Lorem ipsum es el texto que se usa habitualmente en diseño gráfico en demostraciones de tipografías o de borradores de diseño para probar el diseño visual antes de insertar el texto final. Wikipedia\n",
                active = true
            ),
            SpecialtyDoctor(
                user_id = "5Ek2RRiHiPu7SQZsB4Wy",
                specialty_id = "ifuuQlmCXJLBJOCSLJmK",
                name = "Abel Llontop Meza",
                title = "Doctor especializado en Pediatría",
                biography = "Lorem ipsum es el texto que se usa habitualmente en diseño gráfico en demostraciones de tipografías o de borradores de diseño para probar el diseño visual antes de insertar el texto final. Wikipedia\n",
                active = true
            ),
            SpecialtyDoctor(
                user_id = "nFuW9zT7zJB0WQsGZ3vF",
                specialty_id = "cR4HyNp2Xhiyt7KODaYA",
                name = "Melio Diaz Diaz",
                title = "Doctor",
                biography = "Lorem ipsum es el texto que se usa habitualmente en diseño gráfico en demostraciones de tipografías o de borradores de diseño para probar el diseño visual antes de insertar el texto final. Wikipedia\n",
                active = true
            ),
            SpecialtyDoctor(
                user_id = "5Ek2RRiHiPu7SQZsB4Wy",
                specialty_id = "cR4HyNp2Xhiyt7KODaYA",
                name = "Abel Llontop Meza",
                title = "Doctor",
                biography = "Lorem ipsum es el texto que se usa habitualmente en diseño gráfico en demostraciones de tipografías o de borradores de diseño para probar el diseño visual antes de insertar el texto final. Wikipedia\n",
                active = true
            ),
        )
        list.forEach { doctor ->
            specialtyDoctorsViewModel.addDoctor(doctor.user_id, doctor.specialty_id, doctor.name,
                doctor.title, doctor.biography, doctor.enter_date, doctor.active)
        }
    }
}