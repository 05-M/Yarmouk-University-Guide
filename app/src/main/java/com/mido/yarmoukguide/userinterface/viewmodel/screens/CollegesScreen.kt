package com.mido.yarmoukguide.userinterface.viewmodel.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import com.mido.yarmoukguide.AppRoutes
import com.mido.yarmoukguide.data.Faculty
import com.mido.yarmoukguide.ui.theme.YarmoukGuideTheme
import com.mido.yarmoukguide.ui.viewmodel.FacultiesViewModel


@Composable
fun CollegesScreen(
    navController: NavController,
    modifier: Modifier = Modifier
) {
    val viewModel: FacultiesViewModel = viewModel()
    val faculties = viewModel.faculties

    LazyColumn(
        modifier = modifier.fillMaxSize(),
        contentPadding = PaddingValues(16.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        items(faculties) { faculty ->
            FacultyCard(
                faculty = faculty,
                onClick = {
                    println("Navigating with ID: ${faculty.id}")
                    val route = AppRoutes.FACULTY_DETAILS_SCREEN.replace(
                        oldValue = "{facultyId}",
                        newValue = faculty.id.toString()
                    )
                    navController.navigate(route)
                }
            )
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun FacultyCard(
    faculty: Faculty,
    onClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    Card(
        modifier = modifier.fillMaxWidth(),
        elevation = CardDefaults.cardElevation(defaultElevation = 4.dp),
        onClick = onClick
    ) {
        Column(modifier = Modifier.padding(16.dp)) {
            Text(
                text = faculty.name,
                style = MaterialTheme.typography.titleLarge,
                fontWeight = FontWeight.Bold
            )
            Spacer(modifier = Modifier.height(4.dp))
            Text(
                text = faculty.description,
                style = MaterialTheme.typography.bodyMedium,
                color = Color.Gray
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun CollegesScreenPreview() {
    YarmoukGuideTheme {
    }
}