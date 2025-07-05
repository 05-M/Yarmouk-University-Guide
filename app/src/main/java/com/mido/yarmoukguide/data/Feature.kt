package com.mido.yarmoukguide.data

import androidx.compose.ui.graphics.vector.ImageVector

data class Feature(
    val title: String,
    val icon: ImageVector,
    val route: String // كل ميزة ليها "طريق" أو "مسار" عشان نعرف نوديها فين
)
