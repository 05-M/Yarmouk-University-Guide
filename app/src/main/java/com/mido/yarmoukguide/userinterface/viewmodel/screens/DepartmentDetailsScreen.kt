// في ملف ui/screens/DepartmentDetailsScreen.kt

// ... (imports) ...
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material3.Divider
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Tab
import androidx.compose.material3.TabRow
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import com.mido.yarmoukguide.data.Course
import com.mido.yarmoukguide.data.Department
import com.mido.yarmoukguide.data.Professor
import com.mido.yarmoukguide.ui.viewmodel.DepartmentViewModel
import kotlinx.coroutines.launch

@OptIn(ExperimentalMaterial3Api::class, ExperimentalFoundationApi::class)
@Composable
fun DepartmentDetailsScreen(
    navController: NavController,
    // مش محتاجين الـ departmentId هنا لأن الـ ViewModel هيجيبه بنفسه
    modifier: Modifier = Modifier
) {
    val viewModel: DepartmentViewModel = viewModel() // <<< بنستخدم الـ ViewModel الجديد
    val department by viewModel.department.collectAsState()
    val courses by viewModel.courses.collectAsState()
    val professors by viewModel.professors.collectAsState()

    val tabTitles = listOf("About", "Curriculum", "Faculty Staff")
    val pagerState = rememberPagerState(pageCount = { tabTitles.size })
    val coroutineScope = rememberCoroutineScope()

    Scaffold(
        topBar = {
            TopAppBar(
                title = { (department?.name ?: null)?.let { Text(it) } },
                navigationIcon = {
                    IconButton(onClick = { navController.popBackStack() }) {
                        Icon(Icons.AutoMirrored.Filled.ArrowBack, contentDescription = "Back")
                    }
                }
            )
        }
    ) { innerPadding ->
        Column(modifier = modifier.padding(innerPadding)) {
            // شريط الـ Tabs
            TabRow(selectedTabIndex = pagerState.currentPage) {
                tabTitles.forEachIndexed { index, title ->
                    Tab(
                        selected = pagerState.currentPage == index,
                        onClick = { coroutineScope.launch { pagerState.animateScrollToPage(index) } },
                        text = { Text(title) }
                    )
                }
            }

            // الـ Pager اللي بيعرض المحتوى
            HorizontalPager(
                state = pagerState,
                modifier = Modifier.fillMaxSize()
            ) { pageIndex ->
                when (pageIndex) {
                    0 -> AboutDepartmentTab(department = department)
                    1 -> CoursesTab(courses = courses)
                    2 -> ProfessorsTab(professors = professors)
                }
            }
        }
    }
}

// --- هنعمل Composable بسيط لكل Tab ---

@Composable
fun AboutDepartmentTab(department: Department?) {
    LazyColumn(contentPadding = PaddingValues(16.dp)) {
        item {
            Text(department?.description ?: "No description available.", style = MaterialTheme.typography.bodyLarge)
            Spacer(modifier = Modifier.height(8.dp))
            department?.headOfDepartment?.let { Text("Head: $it", fontWeight = FontWeight.Bold) }
            // ... ضيف باقي المعلومات
        }
    }
}

@Composable
fun CoursesTab(courses: List<Course>) {
    LazyColumn(contentPadding = PaddingValues(16.dp), verticalArrangement = Arrangement.spacedBy(8.dp)) {
        items(courses) { course ->
            Text("${course.code} - ${course.name} (${course.creditHours} hours)")
            Divider()
        }
    }
}

@Composable
fun ProfessorsTab(professors: List<Professor>) {
    LazyColumn(contentPadding = PaddingValues(16.dp), verticalArrangement = Arrangement.spacedBy(8.dp)) {
        items(professors) { professor ->
            Text("${professor.title} ${professor.name}")
            Divider()
        }
    }
}