package com.mido.yarmoukguide.userinterface.viewmodel

// في HomeViewModel.kt

// ... (imports)
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.Chat
import androidx.compose.material.icons.filled.CalendarToday
import androidx.compose.material.icons.filled.Map
import androidx.compose.material.icons.filled.Newspaper
import androidx.compose.material.icons.filled.Quiz
import androidx.compose.material.icons.filled.School
import androidx.lifecycle.ViewModel
import com.mido.yarmoukguide.AppRoutes
import com.mido.yarmoukguide.data.Feature


class HomeViewModel : ViewModel() {
    val features: List<Feature> = listOf(
        Feature("الكليات", Icons.Filled.School, AppRoutes.COLLEGES_SCREEN),
        Feature("خريطة الجامعة", Icons.Filled.Map, AppRoutes.CAMPUS_MAP_SCREEN),
        Feature("الجدول الدراسي", Icons.Filled.CalendarToday, AppRoutes.SCHEDULE_SCREEN),
        Feature("الأخبار والفعاليات", Icons.Filled.Newspaper, AppRoutes.NEWS_AND_EVENTS_SCREEN),
        Feature("خدمات و أسئلة", Icons.Filled.Quiz, AppRoutes.SERVICES_AND_FAQ_SCREEN),
        Feature("المحادثات", Icons.AutoMirrored.Filled.Chat, AppRoutes.CHAT_SCREEN)

    )
}