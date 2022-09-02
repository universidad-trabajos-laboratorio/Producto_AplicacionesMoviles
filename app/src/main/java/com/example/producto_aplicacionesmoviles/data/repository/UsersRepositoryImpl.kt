package com.example.producto_aplicacionesmoviles.data.repository

import com.example.producto_aplicacionesmoviles.core.Constants
import com.example.producto_aplicacionesmoviles.data.model.Response
import com.example.producto_aplicacionesmoviles.data.model.User
import com.example.producto_aplicacionesmoviles.domain.repository.UsersRepository
import com.google.firebase.firestore.CollectionReference
import kotlinx.coroutines.channels.awaitClose
import kotlinx.coroutines.flow.callbackFlow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.tasks.await
import javax.inject.Inject
import javax.inject.Singleton


@Singleton
class UsersRepositoryImpl @Inject constructor(
    private val usersRef: CollectionReference
): UsersRepository {

    override fun getUsersFromFirestore() = callbackFlow {
        val snapshotListener = usersRef
            .whereNotEqualTo(Constants.USER_ACTIVE_FIELD, false)
            .addSnapshotListener { snapshot, e ->
                val response = if (snapshot != null) {
                    val users = snapshot.toObjects(User::class.java)
                    Response.Success(users)
                } else {
                    Response.Error(e?.message ?: e.toString())
                }
                trySend(response).isSuccess
            }
        awaitClose {
            snapshotListener.remove()
        }
    }

    override fun getUserByUserIdFromFirestore( user_id: String) = callbackFlow {
        val snapshotListener = usersRef.document(user_id)
            .addSnapshotListener { snapshot, e ->
                val response = if (snapshot != null) {
                    val doctorUser = snapshot.toObject(User::class.java)
                    Response.Success(doctorUser)
                } else {
                    Response.Error(e?.message ?: e.toString())
                }
                trySend(response).isSuccess
            }
        awaitClose {
            snapshotListener.remove()
        }
    }

    override fun addUserToFirestore( user: User) = flow {
        try {
            emit( Response.Loading )
            val id = usersRef.document().id
            val newUser = User(
                id = id,
                authentication_id =  user.authentication_id?:"",
                email = user.email,
                name = user.name,
                gender = user.gender,
                document_type = user.document_type,
                document_number = user.document_number,
                rol = user.rol,
                profile_img = user.profile_img,
                created_at = user.created_at,
                last_login_date = user.last_login_date,
                active = user.active
            )
            val addition = usersRef.document(id).set(newUser).await()
            emit( Response.Success(addition) )
        } catch (e: Exception) {
            emit( Response.Error(e.message ?: e.toString()) )
        }
    }

    override fun deleteUserFromFirestore(user_id: String) = flow {
        try {
            emit( Response.Loading )
            val deletion = usersRef.document(user_id).update("active", false).await()
            emit( Response.Success(deletion) )
        } catch (e: Exception) {
            emit( Response.Error(e.message ?: e.toString()) )
        }
    }
}