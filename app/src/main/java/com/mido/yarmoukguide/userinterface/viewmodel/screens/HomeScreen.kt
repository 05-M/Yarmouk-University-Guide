package com.mido.yarmoukguide.userinterface.viewmodel.screens

import android.annotation.SuppressLint
import android.content.res.Configuration
import android.icu.util.Calendar
import androidx.compose.animation.core.Animatable
import androidx.compose.animation.core.FastOutSlowInEasing
import androidx.compose.animation.core.RepeatMode
import androidx.compose.animation.core.animateFloat
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.infiniteRepeatable
import androidx.compose.animation.core.rememberInfiniteTransition
import androidx.compose.animation.core.tween
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.interaction.collectIsPressedAsState
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.BoxWithConstraints
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.School
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.scale
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.mido.yarmoukguide.data.Feature
import com.mido.yarmoukguide.ui.theme.YarmoukGuideTheme
import com.mido.yarmoukguide.userinterface.viewmodel.HomeViewModel
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

//@Composable
//fun HomeScreen(
//    navController: NavController,
//    modifier: Modifier = Modifier
//) {
//    val homeViewModel: HomeViewModel = viewModel()
//    val features = homeViewModel.features
//
//    LazyVerticalGrid(
//        columns = GridCells.Fixed(2),
//        modifier = modifier.fillMaxSize()
//            .background(MaterialTheme.colorScheme.background),
//        contentPadding = PaddingValues(8.dp),
//        verticalArrangement = Arrangement.spacedBy(8.dp),
//        horizontalArrangement = Arrangement.spacedBy(8.dp)
//    ) {
//        items(features) { feature ->
//            FeatureCard(
//                feature = feature,
//                onClick = {
//                    navController.navigate(feature.route)
//                }
//            )
//        }
//    }
//}

//@OptIn(ExperimentalMaterial3Api::class)
//@Composable
//fun FeatureCard(
//    feature: Feature,
//    onClick: () -> Unit,
//    modifier: Modifier = Modifier
//) {
//    ElevatedCard(
//        modifier = modifier
//            .aspectRatio(1f)
//            .padding(8.dp)
//            .background(MaterialTheme.colorScheme.surface),
//        elevation = CardDefaults.cardElevation(defaultElevation = 4.dp),
//        onClick = onClick
//    ) {
//        Column(
//            modifier = Modifier.fillMaxSize().padding(8.dp),
//            verticalArrangement = Arrangement.Center,
//            horizontalAlignment = Alignment.CenterHorizontally
//        ) {
//            Icon(
//                imageVector = feature.icon,
//                contentDescription = feature.title,
//                modifier = Modifier.size(48.dp),
//                tint = MaterialTheme.colorScheme.primary
//            )
//            Spacer(modifier = Modifier.height(12.dp))
//            Text(
//                text = feature.title,
//                fontWeight = FontWeight.Bold,
//                style = MaterialTheme.typography.titleMedium,
//                color = MaterialTheme.colorScheme.onSurface
//            )
//        }
//    }
//}

@Composable
fun AnimatedGradientBackground(modifier: Modifier = Modifier){
    val gradientColors = listOf(
        MaterialTheme.colorScheme.primary.copy(alpha = 0.3f),
        MaterialTheme.colorScheme.tertiary.copy(alpha = 0.3f),
        MaterialTheme.colorScheme.secondary.copy(alpha = 0.3f),
        MaterialTheme.colorScheme.primary.copy(alpha = 0.3f)
    )
    val transition = rememberInfiniteTransition(label = "background color transition")

    val translateAnimation = transition.animateFloat(
        initialValue = 0f,
        targetValue = 8500f,
        animationSpec = infiniteRepeatable(
            animation = tween(durationMillis = 8500, easing = FastOutSlowInEasing),
            repeatMode = RepeatMode.Restart
        ), label = "background translate animation"
    )
    val brush = Brush.linearGradient(
        colors = gradientColors,
        start = Offset(x = translateAnimation.value - 5000, y = translateAnimation.value - 5000),
        end = Offset(x = translateAnimation.value, y = translateAnimation.value)
    )
    Box(modifier = modifier.background(brush))
}
@SuppressLint("UnusedBoxWithConstraintsScope")
@Composable
fun HomeScreen(
    navController: NavController,
    modifier: Modifier = Modifier
) {
    val homeViewModel: HomeViewModel = viewModel()
    val features = homeViewModel.features
    val nightMood = isNight()
    val iconTintColor = if(nightMood){
        MaterialTheme.colorScheme.secondary
    } else {
        MaterialTheme.colorScheme.primary
    }
    // BoxWithConstraints بيدينا معلومات عن حجم الشاشة المتاح
    BoxWithConstraints(
        modifier = modifier
            .fillMaxSize()
    ) {
        val screenWidth = maxWidth // عرض الشاشة
        val screenHeight = maxHeight // طول الشاشة

        AnimatedGradientBackground(modifier = Modifier.fillMaxSize())

        features.forEachIndexed { index, feature ->
            // --- هنا هنعمل شوية حسابات بسيطة عشان نحدد مكان كل أيقونة ---
            val xOffset = when (index % 2) { // لو الـ index زوجي أو فردي
                0 -> screenWidth * 0.22f // لو زوجي (0, 2, 4)، خليه على الشمال شوية
                else -> screenWidth * -0.22f // لو فردي (1, 3, 5)، خليه على اليمين شوية
            }
            val yOffset = (screenHeight * 0.15f * index) - (screenHeight * 0.37f)
            // دي معادلة بسيطة عشان تخليهم ينزلوا لتحت مع كل أيقونة

            AnimatedFeatureCard(
                feature = feature,
                index = index,
                navController = navController,
                iconTint = iconTintColor,
                modifier = Modifier
                    .align(Alignment.Center) // نخليهم كلهم يبدأوا من النص
                    .offset(x = xOffset, y = yOffset) // وبعدين نزق كل واحد لمكانه
            )
        }
    }
}

@Composable
fun AnimatedFeatureCard(
    feature: Feature,
    index: Int,
    navController: NavController,
    iconTint: Color,
    modifier: Modifier = Modifier
){
    val yOffset = remember { Animatable(300f) }
    val alpha = remember { Animatable(0f) }

    LaunchedEffect(key1 = feature.route) {
        coroutineScope{
            launch {
                delay(index * 150L)
                yOffset.animateTo(
                    targetValue = 0f,
                    animationSpec = tween(durationMillis = 500, easing = androidx.compose.animation.core.EaseOutCubic)
                )
            }
            launch {
                delay(index * 150L) // نفس التأخير
                alpha.animateTo(
                    targetValue = 1f, // الهدف: يبقى ظاهر تماماً
                    animationSpec = tween(durationMillis = 600)
                )
            }
        }
    }
    Box(
        modifier = modifier
            .offset(y = yOffset.value.dp) // نطبق الإزاحة الرأسية المتحركة
            .alpha(alpha.value)           // نطبق الشفافية المتحركة
    ) {
        CircularFeatureCard( // <<< الكارت الدائري اللي عملناه المرة اللي فاتت
            feature = feature,
            onClick = {
                navController.navigate(feature.route)
            },
            iconTint = iconTint
        )
    }
}



@Composable
fun CircularFeatureCard(
    feature: Feature,
    onClick: ()-> Unit,
    iconTint: Color,
    modifier: Modifier = Modifier
){
    val interactionSource = remember { MutableInteractionSource() }
    val isPressed by interactionSource.collectIsPressedAsState()
    val scale = animateFloatAsState(targetValue = if (isPressed) 0.95f else 1f, label = "scale").value

    Column(
        modifier = modifier.clickable(
          interactionSource = interactionSource,
            indication = null,
            onClick = onClick
        ),
        horizontalAlignment = Alignment.CenterHorizontally
    ){
        Card(
            modifier = Modifier
                .size(120.dp)
                .scale(scale),
            shape = CircleShape,
            elevation = CardDefaults.cardElevation(defaultElevation = 8.dp)
        ){
            Box(
                modifier = Modifier.fillMaxSize(),
                contentAlignment = Alignment.Center
            ){
                Icon(
                    imageVector = feature.icon,
                    contentDescription = feature.title,
                    modifier = Modifier.size(48.dp),
                    tint = iconTint
                )
            }
        }
        Spacer(modifier = Modifier.height(8.dp))
        Text(
            text = feature.title,
            style = MaterialTheme.typography.titleMedium,
            color = MaterialTheme.colorScheme.onSurface
        )
    }
}


@Composable
fun isNight(): Boolean{
    val calendar = Calendar.getInstance()
    val hour = calendar.get(Calendar.HOUR_OF_DAY)
    return hour < 6 || hour >= 18
}


@Preview(showBackground = true, name = "Light Mode")
@Preview(
    showBackground = true,
    name = "Dark Mode",
    uiMode = Configuration.UI_MODE_NIGHT_YES
)@Composable
fun HomeScreenPreview() {
    YarmoukGuideTheme {
        HomeScreen(navController = rememberNavController())
        CircularFeatureCard( feature = Feature("Colleges", Icons.Filled.School, "colleges"),
            onClick = {},
            iconTint = MaterialTheme.colorScheme.primary
        )
    }
}

// في آخر ملف HomeScreen.kt مثلاً

@Composable
fun ComingSoonScreen(modifier: Modifier = Modifier) {
    Box(
        modifier = modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        Text(
            text = "This feature is coming soon!",
            style = MaterialTheme.typography.headlineMedium
        )
    }
}

