package com.example.producto_aplicacionesmoviles.presentation.specialty.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Delete
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.producto_aplicacionesmoviles.core.Constants.DELETE_SPECIALTY
import com.example.producto_aplicacionesmoviles.domain.models.Specialty

@Composable
fun BookCard(
    specialty: Specialty,
    deleteSpeciality: () -> Unit,
) {
    Card(
        shape = MaterialTheme.shapes.small,
        modifier = Modifier
            .padding(
                start = 8.dp,
                end = 8.dp,
                top = 4.dp,
                bottom = 4.dp
            )
            .fillMaxWidth(),
        elevation = 3.dp,
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(all = 12.dp),
            verticalAlignment = Alignment.CenterVertically,
        ) {
            Column(
                modifier = Modifier
                    .fillMaxWidth(0.90f)
            ){
                specialty.name?.let { name ->
                    Text(
                        text = name,
                        color = Color.DarkGray,
                        fontSize = 25.sp
                    )
                }
                specialty.icon?.let { icon_path ->
                    Text(
                        text = "by $icon_path",
                        color = Color.DarkGray,
                        fontSize = 12.sp,
                        textDecoration = TextDecoration.Underline
                    )
                }
            }
            IconButton(
                onClick = deleteSpeciality
            ) {
                Icon(
                    imageVector = Icons.Default.Delete,
                    contentDescription = DELETE_SPECIALTY,
                    tint = MaterialTheme.colors.onSurface
                )
            }
        }
    }
}