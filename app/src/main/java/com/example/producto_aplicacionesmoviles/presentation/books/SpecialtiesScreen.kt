package com.example.producto_aplicacionesmoviles.presentation.books

import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.producto_aplicacionesmoviles.components.ProgressBar
import com.example.producto_aplicacionesmoviles.presentation.books.components.AddBookAlertDialog
import com.example.producto_aplicacionesmoviles.presentation.books.components.AddBookFloatingActionButton
import com.example.producto_aplicacionesmoviles.presentation.books.components.BooksContent
import com.example.producto_aplicacionesmoviles.components.TopBar
import com.example.producto_aplicacionesmoviles.core.Utils.Companion.printMessage
import com.example.producto_aplicacionesmoviles.domain.models.Response

@Composable
fun SpecialtiesScreen(
    viewModel: SpecialtyViewModel = hiltViewModel()
) {
    Scaffold(
        topBar = {
            TopBar()
        },
        content = { padding ->
            when(val specialtiesResponse = viewModel.specialtiesResponse) {
                is Response.Loading -> ProgressBar()
                is Response.Success -> {
                    BooksContent(
                        padding = padding,
                        specialties = specialtiesResponse.data,
                        deleteSpecialty = { specialtyId ->
                            viewModel.deleteBook(specialtyId)
                        }
                    )
                    AddBookAlertDialog(
                        openDialog = viewModel.openDialog,
                        closeDialog = {
                            viewModel.closeDialog()
                        },
                        addBook = { name, icon ->
                            viewModel.addBook(name, icon)
                        }
                    )
                }
                is Response.Error -> printMessage(specialtiesResponse.message)
            }
        },
        floatingActionButton = {
            AddBookFloatingActionButton(
                openDialog = {
                    viewModel.openDialog()
                }
            )
        }
    )

    when(val addBookResponse = viewModel.addSpecialtyResponse) {
        is Response.Loading -> ProgressBar()
        is Response.Success -> Unit
        is Response.Error -> printMessage(addBookResponse.message)
    }

    when(val deleteBookResponse = viewModel.deleteSpecialtyResponse) {
        is Response.Loading -> ProgressBar()
        is Response.Success -> Unit
        is Response.Error -> printMessage(deleteBookResponse.message)
    }
}