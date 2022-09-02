package com.example.producto_aplicacionesmoviles.data.repository

import com.example.producto_aplicacionesmoviles.core.Constants
import com.example.producto_aplicacionesmoviles.data.model.Response
import com.example.producto_aplicacionesmoviles.data.model.Specialty
import com.example.producto_aplicacionesmoviles.domain.repository.SpecialtiesRepository
import com.google.firebase.firestore.CollectionReference
import kotlinx.coroutines.channels.awaitClose
import kotlinx.coroutines.flow.callbackFlow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.tasks.await
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class SpecialtiesRepositoryImpl @Inject constructor(
    private val specialtiesRef: CollectionReference
): SpecialtiesRepository {
    override fun getSpecialtiesFromFirestore() = callbackFlow {
        val snapshotListener = specialtiesRef
            .whereNotEqualTo(Constants.SPECIALTY_ACTIVE_FIELD, false)
            .addSnapshotListener { snapshot, e ->
            val response = if (snapshot != null) {
                val specialities = snapshot.toObjects(Specialty::class.java)
                Response.Success(specialities)
            } else {
                Response.Error(e?.message ?: e.toString())
            }
            trySend(response).isSuccess
        }
        awaitClose {
            snapshotListener.remove()
        }
    }

    override fun addSpecialtyToFirestore(name: String, icon: String, active: Boolean) = flow {
        try {
            emit( Response.Loading )
            val id = specialtiesRef.document().id
            val specialty = Specialty(
                id = id,
                name = name,
                icon = icon,
                active = active
            )
            val addition = specialtiesRef.document(id).set(specialty).await()
            emit( Response.Success(addition) )
        } catch (e: Exception) {
            emit( Response.Error(e.message ?: e.toString()) )
        }
    }

    override fun deleteSpecialtyFromFirestore(specialtyId: String) = flow {
        try {
            emit( Response.Loading )
            val deletion = specialtiesRef.document(specialtyId).update("active", false).await()
            emit( Response.Success(deletion) )
        } catch (e: Exception) {
            emit( Response.Error(e.message ?: e.toString()) )
        }
    }
}