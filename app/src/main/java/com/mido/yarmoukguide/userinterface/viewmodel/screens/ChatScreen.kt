package com.mido.yarmoukguide.userinterface.viewmodel.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.automirrored.filled.Send
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import com.mido.yarmoukguide.data.ChatMessage
import com.mido.yarmoukguide.data.MessageSender
import com.mido.yarmoukguide.userinterface.viewmodel.ChatViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ChatScreen(
    navController: NavController,
    modifier: Modifier = Modifier
){
    val viewModel: ChatViewModel = viewModel()
    val messages = viewModel.messages

    Scaffold(
        topBar = {
            TopAppBar(
                title = {Text("Student help chat")},
                navigationIcon = {
                    IconButton(onClick = {navController.popBackStack()}) {
                        Icon(Icons.AutoMirrored.Filled.ArrowBack, contentDescription = "Back")
                    }
                }
            )
        },
        bottomBar = {
            ChatInputBar()
        }
    ){ innerPadding ->
        LazyColumn(
            modifier = modifier
                .padding(innerPadding)
                .fillMaxSize(),
            contentPadding = PaddingValues(16.dp),
            reverseLayout = true
        ){
            items(messages.reversed()){ message ->
                MessageBubble(chatMessage = message)
                Spacer(modifier = Modifier.height(8.dp))

            }
        }
    }
}

@Composable
fun MessageBubble(chatMessage: ChatMessage){
    val horizontalArrangement = if(chatMessage.sender == MessageSender.ME) Arrangement.End else Arrangement.Start

    Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = horizontalArrangement
    ){
        Box(
            modifier = Modifier
                .clip(
                    RoundedCornerShape( // شكل الفقاعة بحواف دائرية
                        topStart = 24.dp,
                        topEnd = 24.dp,
                        bottomStart = if (chatMessage.sender == MessageSender.ME) 24.dp else 0.dp,
                        bottomEnd = if (chatMessage.sender == MessageSender.ME) 0.dp else 24.dp
                    )
                )
                .background(
                    if (chatMessage.sender == MessageSender.ME) MaterialTheme.colorScheme.primary // لوني أزرق
                    else MaterialTheme.colorScheme.surfaceVariant // لون الآخر رمادي فاتح
                )
                .padding(16.dp)
        ) {
            Text(
                text = chatMessage.text,
                color = if (chatMessage.sender == MessageSender.ME) MaterialTheme.colorScheme.onPrimary // نصي أبيض
                else MaterialTheme.colorScheme.onSurfaceVariant // نص الآخر أسود
            )
        }
    }
}

@Composable
fun ChatInputBar(modifier: Modifier = Modifier){
    Row(
        modifier = modifier.fillMaxWidth()
            .padding(8.dp),
        verticalAlignment = Alignment.CenterVertically
    ){
        TextField(
            value = "",
            onValueChange = {},
            modifier = Modifier.weight(1f),
            placeholder = { Text("Type a message...") }
        )
        Spacer(modifier = Modifier.width(8.dp))
        IconButton(onClick = { /* TODO: Send message logic */ }) {
            Icon(Icons.AutoMirrored.Filled.Send, contentDescription = "Send")
        }
    }
}