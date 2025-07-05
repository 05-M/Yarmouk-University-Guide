package com.mido.yarmoukguide.userinterface.viewmodel

import androidx.lifecycle.ViewModel
import com.mido.yarmoukguide.data.Lecture

class ScheduleViewModel: ViewModel(){
    val weeklySchedule: List<Lecture> = listOf(
        // محاضرات يوم الأحد
        Lecture(1, "CS101: Intro to Programming", "Hall 101", "Sunday", "08:00 AM", "09:30 AM"),
        Lecture(2, "MATH201: Calculus II", "Hall 305", "Sunday", "11:30 AM", "01:00 PM"),

        // محاضرات يوم الإثنين
        Lecture(3, "PHY102: Physics II", "Lab 2B", "Monday", "10:00 AM", "11:30 AM"),

        // محاضرات يوم الثلاثاء
        Lecture(4, "CS101: Intro to Programming", "Hall 101", "Tuesday", "08:00 AM", "09:30 AM"),
        Lecture(5, "ENG205: Technical Writing", "Hall 401", "Tuesday", "02:00 PM", "03:30 PM"),

        // محاضرات يوم الأربعاء
        Lecture(6, "PHY102: Physics II", "Lab 2B", "Wednesday", "10:00 AM", "11:30 AM"),
        Lecture(7, "MATH201: Calculus II", "Hall 305", "Wednesday", "11:30 AM", "01:00 PM"),

        // محاضرات يوم الخميس
        Lecture(8, "ENG205: Technical Writing", "Hall 401", "Thursday", "02:00 PM", "03:30 PM")
    )
}