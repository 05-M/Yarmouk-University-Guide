package com.mido.yarmoukguide.data

enum class MessageSender{
    ME,
    OTHER
}

data class ChatMessage(
    val id: Int,
    val text: String,
    val sender: MessageSender,
    val timestamp: String
)