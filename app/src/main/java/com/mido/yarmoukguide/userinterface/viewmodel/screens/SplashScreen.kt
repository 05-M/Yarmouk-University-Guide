package com.mido.yarmoukguide.userinterface.viewmodel.screens

import android.content.res.Configuration
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.graphics.DefaultAlpha
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.mido.yarmoukguide.AppRoutes
import com.mido.yarmoukguide.R
import com.mido.yarmoukguide.ui.theme.YarmoukGuideTheme
import kotlinx.coroutines.delay

@Composable
fun SplashScreen(navController: NavController) {
    var startAnimation by remember { mutableStateOf(false) }

    val alphaAnimation = animateFloatAsState(
        targetValue = if(startAnimation)1f else 0f,
        animationSpec = tween(durationMillis = 1000)
    )

    LaunchedEffect(key1 = true) {
        startAnimation = true
        delay(1500L)

        navController.navigate(AppRoutes.ROLE_SELECTION_SCREEN) {
            popUpTo(AppRoutes.SPLASH_SCREEN) {
                inclusive = true
            }
        }
    }

    SplashScreenUIWithAnimation(alpha = alphaAnimation.value)
}

@Composable
fun SplashScreenUIWithAnimation(alpha: Float) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(MaterialTheme.colorScheme.background),
        contentAlignment = Alignment.Center
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
           Image(
               painter = painterResource(id = R.drawable.app_logo),
               contentDescription = "Yarmouk Guide App Logo",
               modifier = Modifier.size(325.dp)
                   .alpha(alpha)
           )
            Spacer(modifier = Modifier.height(8.dp))
            Text(
                text = "Yarmouk Guide",
                color = MaterialTheme.colorScheme.onSurface.copy(alpha = 0.8f),
                fontSize = 24.sp,
                modifier =Modifier.alpha(alpha)
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
fun Preview(){
    YarmoukGuideTheme {
        SplashScreenUIWithAnimation(alpha = DefaultAlpha)
    }
}