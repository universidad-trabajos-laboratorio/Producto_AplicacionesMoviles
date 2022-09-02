package com.example.producto_aplicacionesmoviles.data.repository

import com.example.producto_aplicacionesmoviles.core.Constants
import com.example.producto_aplicacionesmoviles.data.model.Response
import com.example.producto_aplicacionesmoviles.data.model.SpecialtyDoctor
import com.example.producto_aplicacionesmoviles.domain.repository.SpecialtyDoctorsRepository
import com.google.firebase.firestore.CollectionReference
import kotlinx.coroutines.channels.awaitClose
import kotlinx.coroutines.flow.callbackFlow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.tasks.await
import javax.inject.Inject
import javax.inject.Singleton


@Singleton
class SpecialtyDoctorsRepositoryImpl @Inject constructor(
    private val specialtyDoctorsRef: CollectionReference
): SpecialtyDoctorsRepository {

    override fun getSpecialtyDoctorsFromFirestore() = callbackFlow {
        val snapshotListener = specialtyDoctorsRef.orderBy(Constants.SPECIALTY_DOCTOR_ACTIVE_FIELD)
            .orderBy(Constants.SPECIALTY_DOCTOR_SPECIALTY_ID_FIELD)
            .whereNotEqualTo(Constants.SPECIALTY_DOCTOR_ACTIVE_FIELD, false)
            .addSnapshotListener { snapshot, e ->
                val response = if (snapshot != null) {
                    val specialityDoctors = snapshot.toObjects(SpecialtyDoctor::class.java)
                    Response.Success(specialityDoctors)
                } else {
                    Response.Error(e?.message ?: e.toString())
                }
                trySend(response).isSuccess
            }
            awaitClose {
                snapshotListener.remove()
            }
    }

    override fun getSpecialtyDoctorsBySpecialtyIdFromFirestore( specialtyId : String) = callbackFlow {
        val snapshotListener = specialtyDoctorsRef.orderBy(Constants.SPECIALTY_DOCTOR_ACTIVE_FIELD)
            .orderBy(Constants.SPECIALTY_DOCTOR_SPECIALTY_ID_FIELD)
            .whereNotEqualTo(Constants.SPECIALTY_DOCTOR_ACTIVE_FIELD, false)
            .whereEqualTo(Constants.SPECIALTY_DOCTOR_SPECIALTY_ID_FIELD, specialtyId)
            .addSnapshotListener { snapshot, e ->
                val response = if (snapshot != null) {
                    val specialityDoctors = snapshot.toObjects(SpecialtyDoctor::class.java)
                    Response.Success(specialityDoctors)
                } else {
                    Response.Error(e?.message ?: e.toString())
                }
                trySend(response).isSuccess
            }
        awaitClose {
            snapshotListener.remove()
        }
    }

    override fun addSpecialtyDoctorToFirestore( specialtyDoctor: SpecialtyDoctor)= flow {
        try {
            emit( Response.Loading )
            val id = specialtyDoctorsRef.document().id
            val newSpecialtyDoctor = SpecialtyDoctor(
                id = id,
                user_id= specialtyDoctor.user_id,
                specialty_id = specialtyDoctor.specialty_id,
                title = specialtyDoctor.title,
                biography = specialtyDoctor.biography,
                enter_date = specialtyDoctor.enter_date,
                active = specialtyDoctor.active
            )
            val addition = specialtyDoctorsRef.document(id).set(newSpecialtyDoctor).await()
            emit( Response.Success(addition) )
        } catch (e: Exception) {
            emit( Response.Error(e.message ?: e.toString()) )
        }
    }

    override fun deleteSpecialtyDoctorFromFirestore(specialtyDoctorId: String)= flow {
        try {
            emit( Response.Loading )
            val deletion = specialtyDoctorsRef.document(specialtyDoctorId)
                .update(Constants.SPECIALTY_DOCTOR_ACTIVE_FIELD, false).await()
            emit( Response.Success(deletion) )
        } catch (e: Exception) {
            emit( Response.Error(e.message ?: e.toString()) )
        }
    }

}