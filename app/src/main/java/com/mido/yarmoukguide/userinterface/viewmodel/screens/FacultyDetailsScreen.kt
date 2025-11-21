package com.mido.yarmoukguide.userinterface.viewmodel.screens

import android.content.res.Configuration
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.mido.yarmoukguide.AppRoutes
import com.mido.yarmoukguide.data.Department
import com.mido.yarmoukguide.ui.theme.YarmoukGuideTheme
import com.mido.yarmoukguide.userinterface.viewmodel.FacultiesViewModel


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun FacultyDetailsScreen(
    facultyId: String?,
    navController: NavController,
    modifier: Modifier = Modifier
) {
    // 1. نجيب الكلية نفسها كـ State (زي ما كنا عاملين)
    val viewModel: FacultiesViewModel = viewModel()
    val id = facultyId?.toIntOrNull()
    val facultyState = if(id != null){
        viewModel.getFacultyById(id).collectAsState(initial = null)
    } else {
        remember { mutableStateOf(null) }
    }
    val faculty = facultyState.value

    // 2. نجيب قايمة الأقسام بتاعة الكلية دي كـ State
    val departmentsState = if(id != null){
        viewModel.getDepartmentsForFaculty(id).collectAsState(initial = emptyList())
    } else {
        remember { mutableStateOf(emptyList()) }
    }
    val departments = departmentsState.value

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
            LazyColumn(
                modifier = modifier
                    .padding(innerPadding)
                    .fillMaxSize()
                    .background(MaterialTheme.colorScheme.background),
                contentPadding = PaddingValues(16.dp),
            ) {
                item { // بنستخدم item { ... } عشان نحط Composable عادي جوه LazyColumn
                    Column {
                        // ممكن نحط صورة هنا بعدين
                        Text(
                            text = faculty.name,
                            style = MaterialTheme.typography.headlineLarge,
                            fontWeight = FontWeight.Bold
                        )
                        Spacer(modifier = Modifier.height(8.dp))
                        Text(
                            text = faculty.description,
                            style = MaterialTheme.typography.bodyLarge,
                            color = Color.DarkGray
                        )
                        Spacer(modifier = Modifier.height(24.dp))
                        // عنوان لقسم الأقسام
                        Text(
                            text = "Departments",
                            style = MaterialTheme.typography.headlineSmall,
                            fontWeight = FontWeight.Bold
                        )
                        HorizontalDivider(modifier = Modifier.padding(vertical = 8.dp)) // خط فاصل

                        faculty.contactInfo?.let{contact ->
                            Text("Contact:$contact", style = MaterialTheme.typography.bodyLarge)
                            Spacer(modifier = Modifier.height(8.dp))
                        }
                        faculty.locationOnMap?.let { location->
                            Text("Location:$location", style = MaterialTheme.typography.bodyLarge)
                        }
                    }
                }

                if (departments.isNotEmpty()) {
                    items(departments) { department -> // items بتلف على قايمة
                        DepartmentCard(department = department,
                            onClick = {
                                val route = AppRoutes.DEPARTMENT_DETAILS_SCREEN.replace(
                                    oldValue = "{departmentId}",
                                    newValue = department.id.toString()
                                )
                                // val route = "department_details/${department.id}"
                                navController.navigate(route)
                            }
                        ) // كارت بسيط للقسم
                        Spacer(modifier = Modifier.height(8.dp))
                    }
                } else {
                    item {
                        Text("No departments found for this faculty.")
                    }
                }
                // -----------------------------------
            }
        } else {
            Box(modifier = modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
                Text("Sorry, faculty details could not be loaded.")
            }
        }
    }
}

@Composable
fun DepartmentCard(department: Department, modifier: Modifier = Modifier, onClick: ()->Unit) {
    Card(
        modifier = modifier.fillMaxWidth(),
        colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surfaceVariant), // لون مختلف شوية
        onClick = onClick
    ) {
        Column(modifier = Modifier.padding(12.dp)) {
            Text(
                text = department.name,
                style = MaterialTheme.typography.titleMedium,
                fontWeight = FontWeight.SemiBold
            )
            // لو فيه وصف للقسم ممكن نضيفه هنا
            if (department.description != null) {
                Text(
                    text = department.description,
                    style = MaterialTheme.typography.bodySmall,
                    maxLines = 1

                )
            }
        }
    }
}

@Preview(showBackground = true, name = "Light Mode")
@Preview(
    showBackground = true,
    name = "Dark Mode",
    uiMode = Configuration.UI_MODE_NIGHT_YES
)
@Composable
fun FacultyDetailsScreenPreview() {
    YarmoukGuideTheme {
        FacultyDetailsScreen(facultyId = "1",navController = rememberNavController())
    }
}