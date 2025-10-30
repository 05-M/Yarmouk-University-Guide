package com.mido.yarmoukguide.userinterface.viewmodel.screens

// --- Imports (ركز في التعديلات هنا) ---
import android.content.res.Configuration
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material3.CircularProgressIndicator
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
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.mido.yarmoukguide.AppRoutes
import com.mido.yarmoukguide.data.Faculty
import com.mido.yarmoukguide.ui.theme.YarmoukGuideTheme
import com.mido.yarmoukguide.userinterface.viewmodel.FacultiesViewModel


@OptIn(ExperimentalMaterial3Api::class, ExperimentalFoundationApi::class)
@Composable
fun CollegesScreen(
    navController: NavController,
    modifier: Modifier = Modifier
) {
    val viewModel: FacultiesViewModel = viewModel()
    val faculties by viewModel.allFaculties.collectAsState(initial = emptyList())

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Faculties") },
                navigationIcon = {
                    IconButton(onClick = { navController.popBackStack() }) {
                        Icon(Icons.AutoMirrored.Filled.ArrowBack, contentDescription = "Back")
                    }
                }
            )
        }
    ) { innerPadding ->
        if (faculties.isEmpty()) {
            // حالة التحميل أو لو القائمة فاضية
            Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
                CircularProgressIndicator()
            }
        } else {
            // التصميم الجديد
            LazyVerticalGrid(
                columns = GridCells.Fixed(2),
                modifier = modifier
                    .padding(innerPadding)
                    .fillMaxSize(),
                contentPadding = PaddingValues(1.dp),
                verticalArrangement = Arrangement.spacedBy(24.dp), // مسافة رأسية بين الصفوف
                horizontalArrangement = Arrangement.spacedBy(8.dp) // مسافة أفقية بين الأعمدة
            ) {
                items(faculties) { faculty ->
                            FacultyCard(
                                faculty = faculty,
                                onClick = {
                                    val route = AppRoutes.FACULTY_DETAILS_SCREEN.replace(
                                        "{facultyId}", faculty.id.toString()
                                    )
                                    navController.navigate(route)
                                }
                            )
                }
            }
            Spacer(modifier = Modifier.height(24.dp))
        }
    }
}

@Composable
fun FacultyCard(
    faculty: Faculty,
    onClick:()-> Unit,
    modifier: Modifier = Modifier
) {
        // Column عشان نرص الصورة فوق النص
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .clickable(onClick = onClick)
                .padding(vertical = 12.dp, horizontal = 8.dp), // مسافات داخلية
            horizontalAlignment = Alignment.CenterHorizontally, // توسطن كل حاجة جواها أفقياً
            verticalArrangement = Arrangement.Center,
        ) {
            Image(
                painter = painterResource(id = faculty.imageResId),
                contentDescription = faculty.name,
                modifier = Modifier
                    .size(180.dp) // حجم مناسب للوجو
                    .padding(bottom = 8.dp)
                    .clip(CircleShape)// مسافة بين اللوجو والنص
            )
            Text(
                text = faculty.name,
                style = MaterialTheme.typography.titleSmall, // ستايل خط مناسب
                fontWeight = FontWeight.Bold,
                textAlign = TextAlign.Center, // <<< أهم حاجة عشان النص الطويل يتوسطن لما ينزل سطر
                maxLines = 3, // <<< حد أقصى 3 سطور
                overflow = TextOverflow.Ellipsis // <<< لو أطول من 3 سطور، يحط "..."
            )
        }
    }
//}

//}

@Preview(showBackground = true, name = "Light Mode")
@Preview(
    showBackground = true,
    name = "Dark Mode",
    uiMode = Configuration.UI_MODE_NIGHT_YES
)
@Composable
fun CollegesScreenPreview() {
    YarmoukGuideTheme {
        CollegesScreen(navController = rememberNavController())
    }
}

