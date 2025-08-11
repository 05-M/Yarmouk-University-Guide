package com.mido.yarmoukguide.ui.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
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
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.mido.yarmoukguide.R
import com.mido.yarmoukguide.data.NewsItem
import com.mido.yarmoukguide.ui.theme.YarmoukGuideTheme
import com.mido.yarmoukguide.userinterface.viewmodel.NewsViewModel

// --- الشاشة الكاملة ---
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun NewsScreen(
    navController: NavController,
    modifier: Modifier = Modifier
) {
    val viewModel: NewsViewModel = viewModel()
    val newsItems by viewModel.allNews.collectAsState(initial = emptyList())
    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("News & Events") },
                navigationIcon = {
                    IconButton(onClick = { navController.popBackStack() }) {
                        Icon(Icons.AutoMirrored.Filled.ArrowBack, contentDescription = "Back")
                    }
                }
            )
        }
    ) { innerPadding ->
        LazyColumn(
            modifier = modifier
                .padding(innerPadding)
                .fillMaxSize(),
            contentPadding = PaddingValues(16.dp),
            verticalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            items(newsItems) { news ->
                NewsCard(newsItem = news)
            }
        }
    }
}

// --- كارت الخبر الواحد ---
@Composable
fun NewsCard(newsItem: NewsItem, modifier: Modifier = Modifier) {
    Card(
        modifier = modifier.fillMaxWidth(),
        elevation = CardDefaults.cardElevation(defaultElevation = 4.dp)
    ) {
        Column {
            // --- الجزء بتاع الصورة ---
            // لو فيه imageUrl هنعرضها، لو مفيش هنعرض صورة placeholder
            Image(
                // ملاحظة: في التطبيق الحقيقي هنستخدم مكتبة زي Coil لتحميل الصور من النت
                // دلوقتي هنعرض صورة ثابتة من الـ drawable
                painter = painterResource(id = R.drawable.yarmouk_campus_map), // <<< استخدمت صورة الخريطة كـ placeholder مؤقتاً
                contentDescription = newsItem.title,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(180.dp),
                contentScale = ContentScale.Crop // Crop بتملأ المساحة وبتقص الزيادات
            )

            // --- الجزء بتاع النصوص ---
            Column(modifier = Modifier.padding(16.dp)) {
                Text(
                    text = newsItem.title,
                    style = MaterialTheme.typography.titleLarge,
                    fontWeight = FontWeight.Bold,
                    maxLines = 2 // عشان العنوان ميطولش أوي
                )
                Spacer(modifier = Modifier.height(4.dp))
                Text(
                    text = newsItem.date,
                    style = MaterialTheme.typography.bodySmall,
                    color = Color.Gray
                )
                Spacer(modifier = Modifier.height(8.dp))
                Text(
                    text = newsItem.summary,
                    style = MaterialTheme.typography.bodyMedium,
                    maxLines = 3 // الملخص برضه ميطولش أوي
                )
            }
        }
    }
}

// --- الـ Preview ---
@Preview(showBackground = true)
@Composable
fun NewsScreenPreview() {
    YarmoukGuideTheme {
        NewsScreen(navController = rememberNavController())
    }
}