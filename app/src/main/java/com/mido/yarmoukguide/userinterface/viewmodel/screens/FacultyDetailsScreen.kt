package com.mido.yarmoukguide.userinterface.viewmodel.screens

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import com.mido.yarmoukguide.ui.theme.YarmoukGuideTheme
import com.mido.yarmoukguide.ui.viewmodel.FacultiesViewModel


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun FacultyDetailsScreen(
    facultyId: Int?,
    navController: NavController,
    modifier: Modifier = Modifier
) {
    val viewModel: FacultiesViewModel = viewModel()
    val faculty by viewModel.getFacultyById(facultyId ?: -1).collectAsState(initial = null)

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text(faculty?.name ?: "Faculty Not Found") },
                navigationIcon = {
                    IconButton(onClick = { navController.popBackStack() }) {
                        Icon(Icons.AutoMirrored.Filled.ArrowBack, contentDescription = "Back")
                    }
                }
            )
        }
    ) { innerPadding ->
        if (faculty != null) {
            Column(
                modifier = modifier
                    .padding(innerPadding)
                    .padding(16.dp)
                    .fillMaxSize(),
                horizontalAlignment = Alignment.Start
            ) {
                Text(text = faculty!!.description, style = MaterialTheme.typography.bodyLarge)
            }
        } else {
            Box(modifier = modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
                Text("Sorry, faculty details could not be loaded.")
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun FacultyDetailsScreenPreview() {
    YarmoukGuideTheme {
    }
}