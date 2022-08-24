package com.example.producto_aplicacionesmoviles.presentation.books.components

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.example.producto_aplicacionesmoviles.domain.models.Specialty

@Composable
fun BooksContent(
    padding: PaddingValues,
    specialties: List<Specialty>,
    deleteSpecialty: (specialtyId: String) -> Unit
) {
    LazyColumn(
        modifier = Modifier.fillMaxSize().padding(padding)
    ) {
        items(
            items = specialties
        ) { specialty ->
            BookCard(
                specialty = specialty,
                deleteSpeciality = {
                    specialty.id?.let { specialtyId ->
                        deleteSpecialty(specialtyId)
                    }
                }
            )
        }
    }
}