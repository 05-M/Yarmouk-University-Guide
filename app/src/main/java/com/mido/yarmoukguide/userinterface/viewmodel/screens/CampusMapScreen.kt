package com.mido.yarmoukguide.userinterface.viewmodel.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.gestures.rememberTransformableState
import androidx.compose.foundation.gestures.transformable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.mido.yarmoukguide.R
import com.mido.yarmoukguide.ui.theme.YarmoukGuideTheme

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CampusMapScreen(
    navController: NavController,
    modifier: Modifier = Modifier
){
    Scaffold (
        topBar = {
            TopAppBar(
                title = { Text("Campus Map")},
                navigationIcon = {
                    IconButton(onClick = { navController.popBackStack()}){
                        Icon(Icons.AutoMirrored.Filled.ArrowBack, contentDescription = "Back")
                    }
                }
            )
        }
    ){ innerPadding ->
        var scale by remember{ mutableStateOf(1f) }
        var offset by remember { mutableStateOf(Offset.Zero) }
        val state = rememberTransformableState { zoomChange,offsetChange,_ ->
            scale *= zoomChange
            offset += offsetChange
        }
        Box(
            modifier = modifier.padding(innerPadding)
                .fillMaxSize()
                .graphicsLayer(
                    scaleX = scale,
                    scaleY = scale,
                    translationX = offset.x,
                    translationY = offset.y
                )
                .transformable(state = state),
            contentAlignment = Alignment.Center
        ){
            Image(
                painter = painterResource(id = R.drawable.yarmouk_campus_map),
                contentDescription = "Yarmouk University Campus Map",
                modifier = modifier.fillMaxSize(),
                contentScale = ContentScale.Fit
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun CampusMapScreenPreview() {
    YarmoukGuideTheme {
        // بنبعت navController وهمي للـ Preview
        CampusMapScreen(navController = rememberNavController())
    }
}
