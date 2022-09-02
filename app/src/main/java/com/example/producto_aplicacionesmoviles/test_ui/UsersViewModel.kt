package com.example.producto_aplicacionesmoviles.test_ui

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.producto_aplicacionesmoviles.core.Utils
import com.example.producto_aplicacionesmoviles.data.model.Response
import com.example.producto_aplicacionesmoviles.data.model.User
import com.example.producto_aplicacionesmoviles.domain.use_case.UserUseCases
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import java.util.*
import javax.inject.Inject

@HiltViewModel
class UsersViewModel @Inject constructor(
    private val useCases: UserUseCases
) : ViewModel(){
    val usersResponse = MutableLiveData<List<User>>()
    val isLoading = MutableLiveData<Boolean>()

    init {
        getUsers()
    }

    private fun getUsers() = viewModelScope.launch {
        var result: List<User>? = emptyList()
        useCases.getUsers().collect { response ->
            when(response) {
                is Response.Loading -> isLoading.postValue(true)
                is Response.Success -> {
                    result = response.data
                }
                is Response.Error -> Utils.printMessage(response.message)
            }

            if (!result.isNullOrEmpty()){
                usersResponse.postValue(result!!)
                isLoading.postValue(false)
            }
        }
    }

    fun addUser(authentication_id: String, email: String, name: String,
                      gender: String?, document_type : String, document_number : String,
                      rol : String?, profile_img: String?, created_at : Long?,
                      last_login_date : Long?, active: Boolean?) = viewModelScope.launch {
        val newUser = User(
            authentication_id =  authentication_id,
            email = email,
            name = name,
            gender = gender?:"None",
            document_type = document_type,
            document_number = document_number,
            rol = rol?:"patient",
            profile_img = profile_img?:"path/to/default.jpg",
            created_at = created_at?: Date().time,
            last_login_date = last_login_date?: Date().time,
            active = active?: true
        )
        useCases.addUser(newUser).collect { }
    }

}