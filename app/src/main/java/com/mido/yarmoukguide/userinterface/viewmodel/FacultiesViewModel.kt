// في ملف ui/viewmodel/FacultiesViewModel.kt

package com.mido.yarmoukguide.ui.viewmodel // تأكد من الباكج نيم

import androidx.lifecycle.ViewModel
import com.mido.yarmoukguide.data.Faculty // لازم نعمل import للـ data class بتاعنا

class FacultiesViewModel : ViewModel() {

    // --- هنا الجزء المهم اللي غالباً ناقص ---
    // بنعرف خاصية (property) اسمها faculties جوه الكلاس
    val faculties: List<Faculty> = listOf(
        Faculty(1, "Science", "The Faculty of Science has many departments..."),
        Faculty(2, "Medicine", "The Faculty of Medicine is one of the top faculties..."),
        Faculty(3, "Engineering", "The Faculty of Engineering is known for..."),
        Faculty(4, "Law", "The Faculty of Law prepares students for..."),
        Faculty(5, "Arts", "The Faculty of Arts includes various language and humanities departments."),
        Faculty(6, "Economics", "The Faculty of Economics and Administrative Sciences.")
    )
    // ------------------------------------
}