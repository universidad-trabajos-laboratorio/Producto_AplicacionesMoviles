package com.example.producto_aplicacionesmoviles.data.repository

import com.example.producto_aplicacionesmoviles.core.Constants
import com.example.producto_aplicacionesmoviles.data.model.Response
import com.example.producto_aplicacionesmoviles.data.model.WorkDay
import com.example.producto_aplicacionesmoviles.domain.repository.WorkDaysRepository
import com.google.firebase.firestore.CollectionReference
import kotlinx.coroutines.channels.awaitClose
import kotlinx.coroutines.flow.callbackFlow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.tasks.await
import javax.inject.Inject
import javax.inject.Singleton


@Singleton
class WorkDaysRepositoryImpl @Inject constructor(
    private val workDaysRef: CollectionReference
) : WorkDaysRepository {

    override fun getWorkDaysFromFirestore() = callbackFlow {
        val snapshotListener = workDaysRef
            .whereEqualTo(Constants.WORKDAY_ACTIVE_FIELD, true)
            .addSnapshotListener { snapshot, e ->
                val response = if (snapshot != null) {
                    val workDays = snapshot.toObjects(WorkDay::class.java)
                    Response.Success(workDays)
                } else {
                    Response.Error(e?.message ?: e.toString())
                }
                trySend(response).isSuccess
            }
        awaitClose {
            snapshotListener.remove()
        }
    }

    override fun getWorkDaysByUserIdFromFirestore(user_id: String) = callbackFlow {
        val snapshotListener = workDaysRef
            .whereEqualTo(Constants.WORKDAY_ACTIVE_FIELD, true)
            .whereEqualTo(Constants.WORKDAY_USER_ID_FIELD, user_id)
            .addSnapshotListener { snapshot, e ->
                val response = if (snapshot != null) {
                    val workDaysByUserId = snapshot.toObjects(WorkDay::class.java)
                    Response.Success(workDaysByUserId)
                } else {
                    Response.Error(e?.message ?: e.toString())
                }
                trySend(response).isSuccess
            }
        awaitClose {
            snapshotListener.remove()
        }
    }

    override fun addWorkDayToFirestore(workDay: WorkDay) = flow {
        try {
            emit(Response.Loading)
            val id = workDaysRef.document().id
            workDay.id = id
            val addition = workDaysRef.document(id).set(workDay).await()
            emit(Response.Success(addition))
        } catch (e: Exception) {
            emit(Response.Error(e.message ?: e.toString()))
        }
    }

    override fun deleteWorkDayFromFirestore(workday_id: String) = flow {
        try {
            emit(Response.Loading)
            val deletion = workDaysRef.document(workday_id)
                .update(Constants.WORKDAY_ACTIVE_FIELD, false).await()
            emit(Response.Success(deletion))
        } catch (e: Exception) {
            emit(Response.Error(e.message ?: e.toString()))
        }
    }

}