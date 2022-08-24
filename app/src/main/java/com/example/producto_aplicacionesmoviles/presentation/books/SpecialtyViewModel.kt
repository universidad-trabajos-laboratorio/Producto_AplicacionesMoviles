package com.example.producto_aplicacionesmoviles.presentation.books

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.producto_aplicacionesmoviles.domain.models.Response
import com.example.producto_aplicacionesmoviles.domain.models.Specialty
import com.example.producto_aplicacionesmoviles.domain.use_case.SpecialtyUseCases
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class SpecialtyViewModel @Inject constructor(
    private val useCases: SpecialtyUseCases
): ViewModel() {
    var specialtiesResponse by mutableStateOf<Response<List<Specialty>>>(Response.Loading)
        private set
    var addSpecialtyResponse by mutableStateOf<Response<Void?>>(Response.Success(null))
        private set
    var deleteSpecialtyResponse by mutableStateOf<Response<Void?>>(Response.Success(null))
        private set
    var openDialog by mutableStateOf(false)
        private set

    init {
        getBooks()
    }

    private fun getBooks() = viewModelScope.launch {
        useCases.getSpecialty().collect { response ->
            specialtiesResponse = response
        }
    }

    fun addBook(name: String, icon: String) = viewModelScope.launch {
        useCases.addSpecialty(name, icon).collect { response ->
            addSpecialtyResponse = response
        }
    }

    fun deleteBook(specialtyId: String) = viewModelScope.launch {
        useCases.deleteSpecialty(specialtyId).collect { response ->
            deleteSpecialtyResponse = response
        }
    }

    fun openDialog() {
        openDialog = true
    }

    fun closeDialog() {
        openDialog = false
    }
}