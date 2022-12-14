package com.example.producto_aplicacionesmoviles.test_ui.specialty

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import com.example.producto_aplicacionesmoviles.R
import com.example.producto_aplicacionesmoviles.core.TimeUtils
import com.example.producto_aplicacionesmoviles.data.model.*
import com.example.producto_aplicacionesmoviles.viewmodels.*
import dagger.hilt.android.AndroidEntryPoint
import java.util.*


@AndroidEntryPoint
class SpecialtiesActivity : AppCompatActivity() {
    private val specialtyViewModel: SpecialtyViewModel by viewModels()
    private val userViewModel: UsersViewModel by viewModels()
    private val specialtyDoctorsViewModel: SpecialtyDoctorsViewModel by viewModels()
    private val workDayViewModel: WorkDaysViewModel by viewModels()
    private val appointmentsViewModel: AppointmentsViewModel by viewModels()
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
        //uploadSpecialtyDoctors(i)
        //uploadWorkDays(i)
        //uploadAppointments(i)
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
                created_at = user.created_at?: TimeUtils.getActualDateInLima().time,
                last_login_date = user.last_login_date?: TimeUtils.getActualDateInLima().time,
                active = user.active?: true
            )
        }

    }
    fun uploadSpecialties(i: Int){
        val list : List<Specialty> = listOf(
            Specialty(
                name = "Pediatr??a",
                icon = "path/to/icon",
                active = true
            ),
            Specialty(
                name = "Ginecolog??a",
                icon = "path/to/icon",
                active = true
            ),
            Specialty(
                name = "Medicina General",
                icon = "path/to/icon",
                active = true
            ),
            Specialty(
                name = "Neumolog??a",
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

        val list : List<SpecialtyDoctor> = listOf(
            SpecialtyDoctor(
                user_id = "nFuW9zT7zJB0WQsGZ3vF",
                specialty_id = "VbsxlFeOoiWxd09tG0d5",
                name = "Melio Diaz Diaz",
                title = "Doctor especializado en Neumolog??a",
                biography = "Lorem ipsum es el texto que se usa habitualmente en dise??o gr??fico en demostraciones de tipograf??as o de borradores de dise??o para probar el dise??o visual antes de insertar el texto final. Wikipedia\n",
                active = true
            ),
            SpecialtyDoctor(
                user_id = "5Ek2RRiHiPu7SQZsB4Wy",
                specialty_id = "ifuuQlmCXJLBJOCSLJmK",
                name = "Abel Llontop Meza",
                title = "Doctor especializado en Pediatr??a",
                biography = "Lorem ipsum es el texto que se usa habitualmente en dise??o gr??fico en demostraciones de tipograf??as o de borradores de dise??o para probar el dise??o visual antes de insertar el texto final. Wikipedia\n",
                active = true
            ),
            SpecialtyDoctor(
                user_id = "nFuW9zT7zJB0WQsGZ3vF",
                specialty_id = "cR4HyNp2Xhiyt7KODaYA",
                name = "Melio Diaz Diaz",
                title = "Doctor",
                biography = "Lorem ipsum es el texto que se usa habitualmente en dise??o gr??fico en demostraciones de tipograf??as o de borradores de dise??o para probar el dise??o visual antes de insertar el texto final. Wikipedia\n",
                active = true
            ),
            SpecialtyDoctor(
                user_id = "5Ek2RRiHiPu7SQZsB4Wy",
                specialty_id = "cR4HyNp2Xhiyt7KODaYA",
                name = "Abel Llontop Meza",
                title = "Doctor",
                biography = "Lorem ipsum es el texto que se usa habitualmente en dise??o gr??fico en demostraciones de tipograf??as o de borradores de dise??o para probar el dise??o visual antes de insertar el texto final. Wikipedia\n",
                active = true
            ),
        )
        list.forEach { doctor ->
            specialtyDoctorsViewModel.addDoctor(doctor.user_id, doctor.specialty_id, doctor.name,
                doctor.title, doctor.biography, doctor.enter_date, doctor.active)
        }
    }

    fun uploadWorkDays(i: Int){
        /* Lunes y Martes hay guardia
            ABEL
                Lunes       -> 07:00 - 12:00 and 15:00 - 20:00
                Martes      -> 07:00 - 12:00 and 20:00 - 23:59
                Miercoles   -> 00:00 - 07:00
                Jueves      -> 07:00 - 12:00 and 15:00 - 20:00
                Viernes     -> Rest
            MELIO
                Lunes       -> 20:00 - 23:59
                Martes      -> 00:00 - 07:00 and 15:00 - 20:00
                Miercoles   -> 07:00 - 12:00 and 15:00 -20:00
                Jueves      -> REST
                Viernes     -> 07:00 - 12:00 and 15:00 - 20:00

         */

        // Horario de atencion para citas de 7 y 12 y de 15 a 20
        val list : List<WorkDay> = listOf(
            WorkDay(
                doctor_id = "5Ek2RRiHiPu7SQZsB4Wy",//Abel
                day = 1,// lunes
                morning_start = "07:00:00",
                morning_end = "12:00:00",
                afternoon_start = "15:00:00",
                afternoon_end = "20:00:00"
            ),
            WorkDay(
                doctor_id = "5Ek2RRiHiPu7SQZsB4Wy",//Abel
                day = 2,// martes
                morning_start = "07:00:00",
                morning_end = "12:00:00"
            ),
            WorkDay(
                doctor_id = "5Ek2RRiHiPu7SQZsB4Wy",//Abel
                day = 3// miercoles
            ),
            WorkDay(
                doctor_id = "5Ek2RRiHiPu7SQZsB4Wy",//Abel
                day = 4,// jueves
                morning_start = "07:00:00",
                morning_end = "12:00:00",
                afternoon_start = "15:00:00",
                afternoon_end = "20:00:00"
            ),
            WorkDay(
                doctor_id = "5Ek2RRiHiPu7SQZsB4Wy",//Abel
                day = 5,// viernes
            ),
            WorkDay(
                doctor_id = "nFuW9zT7zJB0WQsGZ3vF",//Melio
                day = 1// lunes
            ),
            WorkDay(
                doctor_id = "nFuW9zT7zJB0WQsGZ3vF",//Melio
                day = 2,// martes
                afternoon_start = "15:00:00",
                afternoon_end = "20:00:00"
            ),
            WorkDay(
                doctor_id = "nFuW9zT7zJB0WQsGZ3vF",//Melio
                day = 3,// miercoles
                morning_start = "07:00:00",
                morning_end = "12:00:00",
                afternoon_start = "15:00:00",
                afternoon_end = "20:00:00"
            ),
            WorkDay(
                doctor_id = "nFuW9zT7zJB0WQsGZ3vF",//Melio
                day = 4,// jueves
            ),
            WorkDay(
                doctor_id = "nFuW9zT7zJB0WQsGZ3vF",//Melio
                day = 5,// viernes
                morning_start = "07:00:00",
                morning_end = "12:00:00",
                afternoon_start = "15:00:00",
                afternoon_end = "20:00:00"
            )
        )

        list.forEach{
            workDayViewModel.addWorkDay(it.doctor_id, it.day, it.morning_start, it.morning_end,
                it.afternoon_start, it.afternoon_end, it.active)
        }

    }

    fun uploadAppointments(i: Int){

        // Horario de atencion para citas de 7 y 12 y de 15 a 20
        val list : List<Appointment> = listOf(
            Appointment(
                specialty_id = "cR4HyNp2Xhiyt7KODaYA", //General
                doctor_id = "5Ek2RRiHiPu7SQZsB4Wy", // Abel Diaz
                patient_id = "aQckChryMD7o0CKNwJ1N", //Enfermoncia
                type = "CONSULTA",
                scheduled_date = 1662415200,
                scheduled_time = "01:00:00",
                status = "FINALIZADA"
            ),
            Appointment(
                specialty_id = "cR4HyNp2Xhiyt7KODaYA", //General
                doctor_id = "nFuW9zT7zJB0WQsGZ3vF", // Melio Diaz
                patient_id = "aQckChryMD7o0CKNwJ1N", //Enfermoncia
                type = "CONSULTA",
                scheduled_date = 1662591600,
                scheduled_time = "01:00:00",
                status = "FINALIZADA"
            ),
            Appointment(
                specialty_id = "cR4HyNp2Xhiyt7KODaYA", //General
                doctor_id = "nFuW9zT7zJB0WQsGZ3vF", // Melio Diaz
                patient_id = "aQckChryMD7o0CKNwJ1N", //Enfermoncia
                type = "CONSULTA",
                scheduled_date = 1662764400,
                scheduled_time = "01:00:00",
                status = "PENDIENTE"
            )
        )

        list.forEach{
            appointmentsViewModel.addAppointment(it.specialty_id,it.doctor_id, it.patient_id,
                it.type, it.scheduled_date, it.scheduled_time, it.status)
        }

    }


}