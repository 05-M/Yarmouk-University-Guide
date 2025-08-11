package com.mido.yarmoukguide.userinterface.viewmodel.screens

// --- Imports (ركز في التعديلات هنا) ---
import android.content.res.Configuration
import androidx.compose.animation.animateColorAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
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
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Tab
import androidx.compose.material3.TabRow
import androidx.compose.material3.TabRowDefaults
import androidx.compose.material3.TabRowDefaults.tabIndicatorOffset
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.rememberCoroutineScope
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
import com.mido.yarmoukguide.data.Faculty
import com.mido.yarmoukguide.data.FacultyType
import com.mido.yarmoukguide.ui.theme.YarmoukGuideTheme
import com.mido.yarmoukguide.userinterface.viewmodel.FacultiesViewModel
import kotlinx.coroutines.launch

@OptIn(ExperimentalMaterial3Api::class, ExperimentalFoundationApi::class)
@Composable
fun CollegesScreen(
    navController: NavController,
    modifier: Modifier = Modifier
) {
    val viewModel: FacultiesViewModel = viewModel()
    val facultiesByType by viewModel.facultiesByType.collectAsState()

    val tabTitles = listOf(
        "Medical" to FacultyType.MEDICAL,
        "Scientific" to FacultyType.SCIENTIFIC,
        "Humanities" to FacultyType.HUMANITARIAN,
        )

    // --- هنا التعديل المهم ---
    // pagerState مبقاش محتاج يعرف الـ pageCount في الإصدارات الجديدة هنا
    val pagerState = rememberPagerState(pageCount = {tabTitles.size})
    val coroutineScope = rememberCoroutineScope()

    val currentTabColor = when(pagerState.currentPage){
        0 -> MaterialTheme.colorScheme.secondary
        1 -> MaterialTheme.colorScheme.primary
        2 -> Color(0xFF388E3C)
        else -> MaterialTheme.colorScheme.primary
    }

    val animatedColor by animateColorAsState(
        targetValue = currentTabColor,
        animationSpec = tween(durationMillis = 500), label = "tab color animation"
    )

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
        Column(modifier = modifier.padding(innerPadding)) {
            TabRow(
                selectedTabIndex = pagerState.currentPage,
                containerColor = MaterialTheme.colorScheme.surface,
                contentColor = MaterialTheme.colorScheme.onSurface,
                indicator = { tabPositions ->
                    TabRowDefaults.Indicator(
                        Modifier.tabIndicatorOffset(tabPositions[pagerState.currentPage]),
                        height = 4.dp,
                        color = animatedColor
                    )

                }
            ) {
                tabTitles.forEachIndexed { index, (title, _) ->
                    Tab(
                        selected = pagerState.currentPage == index,
                        onClick = {
                            coroutineScope.launch {
                                // الـ launch دلوقتي متعرفة صح بسبب الـ import الصح
                                pagerState.animateScrollToPage(index)
                            }
                        },
                        text = { Text(title) },
                        selectedContentColor = animatedColor,
                        unselectedContentColor = Color.Gray
                    )
                }
            }

            HorizontalPager(
                // <<< بنحدد الـ pageCount هنا
                state = pagerState,
                modifier = Modifier
                    .fillMaxSize()
                    .weight(1f) // weight(1f) عشان ياخد باقي المساحة
            ) { pageIndex ->
                val facultyType = tabTitles[pageIndex].second
                val facultyList = facultiesByType[facultyType] ?: emptyList()

                // ... (الـ LazyColumn بتاعك زي ما هو) ...
                if (facultyList.isNotEmpty()) {
                    LazyColumn(
                        modifier = Modifier.fillMaxSize(),
                        contentPadding = PaddingValues(16.dp),
                        verticalArrangement = Arrangement.spacedBy(16.dp)
                    ) {
                        items(facultyList) { faculty ->
                            FacultyCard(
                                faculty = faculty,
                                cardColor = animatedColor,
                                onClick = {
                                    val route = AppRoutes.FACULTY_DETAILS_SCREEN.replace(
                                        "{facultyId}",
                                        faculty.id.toString()
                                    )
                                    navController.navigate(route)
                                }
                            )
                        }
                    }
                } else {
                    Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
                        Text(text = "No faculties found in this category.")
                    }
                }
            }
        }
    }
}
@Composable
fun FacultyCard(
        faculty: Faculty,
        onClick: () -> Unit,
        cardColor: Color,
        modifier: Modifier = Modifier
   ) {
        Card(
            modifier = modifier.fillMaxWidth()
                .background(MaterialTheme.colorScheme.surface),
            elevation = CardDefaults.cardElevation(defaultElevation = 4.dp),
            colors = CardDefaults.cardColors(
                containerColor = MaterialTheme.colorScheme.surface
            ),
            border = BorderStroke(2.dp,cardColor),
            onClick = onClick
        ) {
            Column(modifier = Modifier.padding(16.dp)) {
                Text(
                    text = faculty.name,
                    style = MaterialTheme.typography.titleLarge,
                    fontWeight = FontWeight.Bold,
                    color = cardColor
                )
                Spacer(modifier = Modifier.height(4.dp))
                Text(
                    text = faculty.description,
                    style = MaterialTheme.typography.bodyMedium,
                    color = MaterialTheme.colorScheme.onSurface
                )
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
fun CollegesScreenPreview() {
    YarmoukGuideTheme {
        CollegesScreen(navController = rememberNavController())
    }
}