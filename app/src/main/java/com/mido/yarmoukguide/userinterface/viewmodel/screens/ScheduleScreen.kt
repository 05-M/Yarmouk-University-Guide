package com.mido.yarmoukguide.userinterface.viewmodel.screens

import ScheduleViewModel
import android.content.res.Configuration
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ElevatedCard
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
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.mido.yarmoukguide.data.Lecture
import com.mido.yarmoukguide.ui.theme.YarmoukGuideTheme


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ScheduleScreen(
    navController: NavController,
    modifier: Modifier = Modifier
){
    val viewModel: ScheduleViewModel = viewModel()
    val schedule by viewModel.weeklySchedule.collectAsState(initial = emptyList())

    val groupedSchedule = schedule.groupBy { it.dayOfWeek }
    val daysOfWeek = listOf("Sunday", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday")

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("My Weekly Schedule")},
                navigationIcon = {
                    IconButton(onClick = {navController.popBackStack()}){
                        Icon(Icons.AutoMirrored.Filled.ArrowBack, contentDescription = "Back")
                    }
                }
            )
        }
    ){innerPadding ->
        LazyColumn(
            modifier = modifier
                .padding(innerPadding)
                .fillMaxSize()
                .background(MaterialTheme.colorScheme.background),
            contentPadding = PaddingValues(16.dp),
            verticalArrangement = Arrangement.spacedBy(16.dp)
        ){
            daysOfWeek.forEach { day ->
                val lecturesForDay = groupedSchedule[day]
                if(!lecturesForDay.isNullOrEmpty()){
                    item{
                        DaySchedule(day = day, lectures = lecturesForDay)
                    }
                }
            }
        }

    }
}

@Composable
fun DaySchedule(day: String, lectures: List<Lecture>, modifier: Modifier = Modifier){
    Column(modifier = modifier.background(MaterialTheme.colorScheme.background)) {
        Text(
            text = day,
            style = MaterialTheme.typography.headlineSmall,
            fontWeight = FontWeight.Bold,
            modifier = Modifier.padding(bottom = 8.dp),
            color = MaterialTheme.colorScheme.onSurface
        )
        // نلف على محاضرات اليوم ده ونعرض كل واحدة في كارت
        lectures.forEach { lecture ->
            LectureCard(lecture = lecture)
            Spacer(modifier = Modifier.height(8.dp))
        }
    }
}

@Composable
fun LectureCard(lecture: Lecture, modifier: Modifier = Modifier) {
    ElevatedCard(
        modifier = modifier.fillMaxWidth()
            .background(MaterialTheme.colorScheme.surface),
        elevation = CardDefaults.cardElevation(defaultElevation = 2.dp)
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(12.dp),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Column(modifier = Modifier.weight(1f)) {
                Text(
                    text = lecture.subjectName,
                    fontWeight = FontWeight.Bold,
                    style = MaterialTheme.typography.titleMedium,
                    color = MaterialTheme.colorScheme.onSurface
                )
                Text(
                    text = lecture.location,
                    style = MaterialTheme.typography.bodyMedium,
                    color = MaterialTheme.colorScheme.onSurface
                )
            }
            Text(
                text = "${lecture.startTime} - ${lecture.endTime}",
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
fun ScheduleScreenPreview() {
    YarmoukGuideTheme {
        ScheduleScreen(navController = rememberNavController())
    }
}