package com.mido.yarmoukguide.ui.theme

import android.os.Build
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.dynamicDarkColorScheme
import androidx.compose.material3.dynamicLightColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext

private val DarkColorScheme = darkColorScheme(
    primary = Purple80,
    secondary = PurpleGrey80,
    tertiary = Pink80
)

private val LightColorScheme = lightColorScheme(
     primary = AppBlue,           // اللون الأساسي للأزرار والأيقونات المهمة
    secondary = AppOrange,         // اللون الثانوي
    tertiary = AppAccent,          // اللون التالت (ممكن نستخدم الـ Accent هنا)
    background = AppBackground,    // لون خلفية الشاشات
    surface = AppSurface,          // لون الكروت والأسطح اللي فوق الخلفية
    onPrimary = Color.White,       // لون النص اللي هيتحط فوق اللون الأساسي (primary)
    onSecondary = Color.Black,     // لون النص اللي هيتحط فوق اللون الثانوي
    onTertiary = Color.Black,      // لون النص اللي هيتحط فوق اللون التالت
    onBackground = AppTextPrimary, // لون النص الأساسي اللي على الخلفية
    onSurface = AppTextPrimary     // لون النص اللي على الكروت والأسطح

)

@Composable
fun YarmoukGuideTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    // Dynamic color is available on Android 12+
    dynamicColor: Boolean = false,
    content: @Composable () -> Unit
) {
    val colorScheme = when {
        dynamicColor && Build.VERSION.SDK_INT >= Build.VERSION_CODES.S -> {
            val context = LocalContext.current
            if (darkTheme) dynamicDarkColorScheme(context) else dynamicLightColorScheme(context)
        }

        darkTheme -> DarkColorScheme
        else -> LightColorScheme
    }

    MaterialTheme(
        colorScheme = colorScheme,
        typography = Typography,
        content = content
    )
}