package com.mido.yarmoukguide.ui.theme

import android.os.Build
import androidx.compose.animation.animateColorAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.ColorScheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.dynamicDarkColorScheme
import androidx.compose.material3.dynamicLightColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext

private val DarkColorScheme = darkColorScheme(
    primary = AppBlueDark,
    secondary = AppOrangeDark,
    tertiary = AppAccentDark,
    background = AppBackgroundDark,
    surface = AppSurfaceDark,
    onPrimary = Color.Black, // نص أسود على الأزرق الفاتح
    onSecondary = Color.Black,
    onTertiary = Color.Black,
    onBackground = AppTextPrimaryDark, // نص فاتح على الخلفية الغامقة
    onSurface = AppTextPrimaryDark
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
private fun animateColors(colorScheme: ColorScheme): ColorScheme {
    // animateColorAsState بتخلي أي تغيير في اللون يحصل بشكل ناعم
    val animationSpec = tween<Color>(durationMillis = 0) // مدة الأنيميشن نص ثانية

    val primary = animateColorAsState(colorScheme.primary, animationSpec).value
    val onPrimary = animateColorAsState(colorScheme.onPrimary, animationSpec).value
    val secondary = animateColorAsState(colorScheme.secondary, animationSpec).value
    val onSecondary = animateColorAsState(colorScheme.onSecondary, animationSpec).value
    val tertiary = animateColorAsState(colorScheme.tertiary, animationSpec).value
    val onTertiary = animateColorAsState(colorScheme.onTertiary, animationSpec).value
    val background = animateColorAsState(colorScheme.background, animationSpec).value
    val onBackground = animateColorAsState(colorScheme.onBackground, animationSpec).value
    val surface = animateColorAsState(colorScheme.surface, animationSpec).value
    val onSurface = animateColorAsState(colorScheme.onSurface, animationSpec).value
    // ... ممكن نضيف باقي الألوان بنفس الطريقة لو بنستخدمها ...
    val error = animateColorAsState(colorScheme.error, animationSpec).value
    val onError = animateColorAsState(colorScheme.onError, animationSpec).value

    // بنرجع ColorScheme
    // جديد بالقيم المتحركة
    return remember(
        primary, onPrimary, secondary, onSecondary, tertiary, onTertiary,
        background, onBackground, surface, onSurface, error, onError
    ) {
        colorScheme.copy(
            primary = primary,
            onPrimary = onPrimary,
            secondary = secondary,
            onSecondary = onSecondary,
            tertiary = tertiary,
            onTertiary = onTertiary,
            background = background,
            onBackground = onBackground,
            surface = surface,
            onSurface = onSurface,
            error = error,
            onError = onError
        )
    }
}
@Composable
fun YarmoukGuideTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    // Dynamic color is available on Android 12+
    dynamicColor: Boolean = false,
    content: @Composable () -> Unit
) {
    val nonAnimatedColorScheme = when {
        dynamicColor && Build.VERSION.SDK_INT >= Build.VERSION_CODES.S -> {
            val context = LocalContext.current
            if (darkTheme) dynamicDarkColorScheme(context) else dynamicLightColorScheme(context)
        }

        darkTheme -> DarkColorScheme
        else -> LightColorScheme
    }

    val animatedColorScheme = animateColors(nonAnimatedColorScheme)

    MaterialTheme(
        colorScheme = animatedColorScheme,
        typography = Typography,
        content = content
    )
}