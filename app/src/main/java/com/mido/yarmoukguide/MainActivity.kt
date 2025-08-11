package com.mido.yarmoukguide

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.ui.platform.LocalContext
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.mido.yarmoukguide.data.YarmoukGuideDatabase
import com.mido.yarmoukguide.ui.screens.NewsScreen
import com.mido.yarmoukguide.ui.theme.YarmoukGuideTheme
import com.mido.yarmoukguide.userinterface.viewmodel.screens.CampusMapScreen
import com.mido.yarmoukguide.userinterface.viewmodel.screens.ChatScreen
import com.mido.yarmoukguide.userinterface.viewmodel.screens.CollegesScreen
import com.mido.yarmoukguide.userinterface.viewmodel.screens.ComingSoonScreen
import com.mido.yarmoukguide.userinterface.viewmodel.screens.FacultyDetailsScreen
import com.mido.yarmoukguide.userinterface.viewmodel.screens.FaqScreen
import com.mido.yarmoukguide.userinterface.viewmodel.screens.GenderSelectionScreen
import com.mido.yarmoukguide.userinterface.viewmodel.screens.HomeScreen
import com.mido.yarmoukguide.userinterface.viewmodel.screens.RoleSelectionScreen
import com.mido.yarmoukguide.userinterface.viewmodel.screens.ScheduleScreen
import com.mido.yarmoukguide.userinterface.viewmodel.screens.SplashScreen


object AppRoutes {
    const val SPLASH_SCREEN = "splash"
    const val ROLE_SELECTION_SCREEN = "role_selection"
    const val GENDER_SELECTION_SCREEN = "gender_selection"
    const val HOME_SCREEN = "home"
    const val COLLEGES_SCREEN = "colleges"
    const val FACULTY_DETAILS_SCREEN = "faculty_details/{facultyId}"
    const val  CAMPUS_MAP_SCREEN = "campus_map"
    const val SCHEDULE_SCREEN = "schedule"
    const val NEWS_AND_EVENTS_SCREEN = "news_and_events"
    const val SERVICES_AND_FAQ_SCREEN = "services_and_faq"
    const val CHAT_SCREEN = "chat"
}

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            YarmoukGuideTheme {
                val navController = rememberNavController()
                NavHost(
                    navController = navController,
                    startDestination = AppRoutes.SPLASH_SCREEN
                ) {
                    composable(route = AppRoutes.SPLASH_SCREEN){
                        SplashScreen(navController = navController)
                    }
                    composable(route = AppRoutes.ROLE_SELECTION_SCREEN){
                        RoleSelectionScreen(navController = navController)
                    }
                    composable(route = AppRoutes.GENDER_SELECTION_SCREEN){
                        GenderSelectionScreen(navController = navController)
                    }
                    composable(route = AppRoutes.HOME_SCREEN) {
                        HomeScreen(navController = navController)
                    }
                    composable(route = AppRoutes.COLLEGES_SCREEN) {
                        val dao = YarmoukGuideDatabase.getDatabase(LocalContext.current).facultyDao()
                        CollegesScreen(navController = navController)
                    }
                    composable(
                        route = AppRoutes.FACULTY_DETAILS_SCREEN,
                        arguments = listOf(navArgument("facultyId") { type = NavType.StringType })
                    ) { backStackEntry ->
                        val facultyId = backStackEntry.arguments?.getString("facultyId")
                        FacultyDetailsScreen(
                            facultyId = facultyId,
                            navController = navController
                        )
                    }
                    composable(route = AppRoutes.CAMPUS_MAP_SCREEN) {
                        CampusMapScreen(navController = navController)
                    }
                    composable(route = "services_screen") {
                        ComingSoonScreen()
                    }
                    composable(route = "news_screen") {
                        ComingSoonScreen()
                    }
                    composable(route = AppRoutes.SCHEDULE_SCREEN) {
                        ScheduleScreen(navController = navController)
                    }
                    composable(route = AppRoutes.NEWS_AND_EVENTS_SCREEN) {
                        NewsScreen(navController = navController)
                    }
                    composable(route = AppRoutes.SERVICES_AND_FAQ_SCREEN) {
                        FaqScreen(navController = navController)
                    }
                    composable(route = AppRoutes.CHAT_SCREEN) {
                        ChatScreen(navController = navController)
                    }
                }
            }
        }
    }
}