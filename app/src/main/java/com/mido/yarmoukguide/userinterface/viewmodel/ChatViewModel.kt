package com.mido.yarmoukguide.userinterface.viewmodel

import androidx.lifecycle.ViewModel
import com.mido.yarmoukguide.data.ChatMessage
import com.mido.yarmoukguide.data.MessageSender

class ChatViewModel : ViewModel(){
    val messages: List<ChatMessage> = listOf(
        ChatMessage(1, "السلام عليكم، كيف أصل لمبنى كلية العلوم؟", MessageSender.ME, "10:00 AM"),
        ChatMessage(2, "وعليكم السلام! مبنى S2، بجوار المكتبة الرئيسية مباشرة.", MessageSender.OTHER, "10:01 AM"),
        ChatMessage(3, "تمام، شكراً جزيلاً!", MessageSender.ME, "10:02 AM"),
        ChatMessage(4, "العفو، بالتوفيق!", MessageSender.OTHER, "10:03 AM"),
        ChatMessage(5, "سؤال آخر لو سمحت، متى تبدأ فترة السحب والإضافة؟", MessageSender.ME, "10:15 AM"),
        ChatMessage(6, "تبدأ الأسبوع القادم يوم الأحد، تابع إعلانات التسجيل.", MessageSender.OTHER, "10:16 AM")
    )
}