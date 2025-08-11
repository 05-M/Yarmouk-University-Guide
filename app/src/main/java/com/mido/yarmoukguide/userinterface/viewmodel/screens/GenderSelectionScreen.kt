package com.mido.yarmoukguide.userinterface.viewmodel.screens

import android.content.res.Configuration
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ElevatedButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.mido.yarmoukguide.AppRoutes
import com.mido.yarmoukguide.ui.theme.YarmoukGuideTheme


@Composable
fun GenderSelectionScreen(
    navController: NavController,
    modifier: Modifier = Modifier
){
    Box(
        modifier = modifier.fillMaxSize()
            .background(MaterialTheme.colorScheme.background),
        contentAlignment = Alignment.Center
    ) {
        Column(
            modifier = modifier
                .padding(32.dp)
                .background(MaterialTheme.colorScheme.background),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = "Please select your gender",
                style = MaterialTheme.typography.headlineMedium,
                textAlign = TextAlign.Center,
                color = MaterialTheme.colorScheme.onSurface
            )
            Text(
                text = "(This helps in providing a tailored chat experience)",
                style = MaterialTheme.typography.bodyMedium,
                textAlign = TextAlign.Center,
                color = MaterialTheme.colorScheme.onSurface
            )
            Spacer(modifier = modifier.height(48.dp))

            ElevatedButton(
                onClick = {
                    println("User selected: Male")
                    navController.navigate(AppRoutes.HOME_SCREEN) {
                        popUpTo(AppRoutes.ROLE_SELECTION_SCREEN) { inclusive = true }
                    }
                }, modifier = modifier.fillMaxWidth()
            ) {
                Text("Male", color = MaterialTheme.colorScheme.onSurface)
            }
            Spacer(modifier = modifier.height(8.dp))
            ElevatedButton(
                onClick = {
                    println("User selected: Female")
                    navController.navigate(AppRoutes.HOME_SCREEN) {
                        popUpTo(AppRoutes.ROLE_SELECTION_SCREEN) { inclusive = true }
                    }
                }, modifier = modifier.fillMaxWidth()
            ) {
                Text("Female", color = MaterialTheme.colorScheme.onSurface)
            }
        }
    }
}


@Preview(showBackground = true, name = "Light Mode")
@Preview(
    showBackground = true,
    name = "Dark Mode",
    uiMode = Configuration.UI_MODE_NIGHT_YES
)@Composable
fun GenderSelectionScreenPreview() {
    YarmoukGuideTheme {
        GenderSelectionScreen(navController = rememberNavController())
    }
}
