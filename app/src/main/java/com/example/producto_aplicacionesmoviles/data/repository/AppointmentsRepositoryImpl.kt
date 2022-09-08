package com.example.producto_aplicacionesmoviles.data.repository

import com.example.producto_aplicacionesmoviles.core.Constants
import com.example.producto_aplicacionesmoviles.data.model.Appointment
import com.example.producto_aplicacionesmoviles.data.model.Response
import com.example.producto_aplicacionesmoviles.domain.repository.AppointmentsRepository
import com.google.firebase.firestore.CollectionReference
import kotlinx.coroutines.channels.awaitClose
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.callbackFlow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.tasks.await
import javax.inject.Inject
import javax.inject.Singleton


@Singleton
class AppointmentsRepositoryImpl @Inject constructor(
    private val appointmentsRef: CollectionReference
) : AppointmentsRepository {

    private val cancelStatus : String = "CANCELADA";

    override fun getAppointmentFromFirestore(): Flow<Response<List<Appointment>>> = callbackFlow {
        val snapshotListener = appointmentsRef
            .whereNotEqualTo(Constants.APPOINTMENT_STATUS_FIELD.uppercase(), cancelStatus)
            .addSnapshotListener { snapshot, e ->
                val response = if (snapshot != null) {
                    val appointments = snapshot.toObjects(Appointment::class.java)
                    Response.Success(appointments)
                } else {
                    Response.Error(e?.message ?: e.toString())
                }
                trySend(response).isSuccess
            }
        awaitClose {
            snapshotListener.remove()
        }
    }

    override fun getAppointmentsByPatientIdFromFirestore(patientId: String): Flow<Response<List<Appointment>>>  = callbackFlow {
        val snapshotListener = appointmentsRef
            .whereNotEqualTo(Constants.APPOINTMENT_STATUS_FIELD.uppercase(), cancelStatus)
            .whereEqualTo(Constants.APPOINTMENT_PATIENT_ID_FIELD, patientId)
            .addSnapshotListener { snapshot, e ->
                val response = if (snapshot != null) {
                    val appointmentsByPatientId = snapshot.toObjects(Appointment::class.java)
                    Response.Success(appointmentsByPatientId)
                } else {
                    Response.Error(e?.message ?: e.toString())
                }
                trySend(response).isSuccess
            }
        awaitClose {
            snapshotListener.remove()
        }
    }

    override fun getAppointmentsByDateAndPatientIdFromFirestore( date: Long, patientId: String ) = callbackFlow {
        val snapshotListener = appointmentsRef
            .whereNotEqualTo(Constants.APPOINTMENT_STATUS_FIELD.uppercase(), cancelStatus)
            .whereEqualTo(Constants.APPOINTMENT_PATIENT_ID_FIELD, patientId)
            .whereEqualTo(Constants.APPOINTMENT_SCHEDULED_DATE_FIELD, date)
            .orderBy(Constants.APPOINTMENT_SCHEDULED_DATE_FIELD) //todo: review most recent to oldest appointment order
            .addSnapshotListener { snapshot, e ->
                val response = if (snapshot != null) {
                    val appointmentsByPatientId = snapshot.toObjects(Appointment::class.java)
                    Response.Success(appointmentsByPatientId)
                } else {
                    Response.Error(e?.message ?: e.toString())
                }
                trySend(response).isSuccess
            }
        awaitClose {
            snapshotListener.remove()
        }
    }

    override fun addAppointmentToFirestore(appointment: Appointment): Flow<Response<Void?>> = flow {
        try {
            emit(Response.Loading)
            val id = appointmentsRef.document().id
            appointment.id = id
            val addition = appointmentsRef.document(id).set(appointment).await()
            emit(Response.Success(addition))
        } catch (e: Exception) {
            emit(Response.Error(e.message ?: e.toString()))
        }
    }

    override fun deleteAppointmentFromFirestore(appointmentId: String): Flow<Response<Void?>> = flow {
        try {
            emit(Response.Loading)
            val deletion = appointmentsRef.document(appointmentId)
                .update(Constants.APPOINTMENT_STATUS_FIELD, cancelStatus).await()
            emit(Response.Success(deletion))
        } catch (e: Exception) {
            emit(Response.Error(e.message ?: e.toString()))
        }
    }


}