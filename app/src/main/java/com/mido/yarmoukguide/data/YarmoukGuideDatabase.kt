// في ملف data/YarmoukGuideDatabase.kt

package com.mido.yarmoukguide.data

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.sqlite.db.SupportSQLiteDatabase // <<< Import جديد
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

@Database(
    entities = [Faculty::class, Department::class, FaqItem::class, Lecture::class, NewsItem::class], // <<< ضفت Lecture و NewsItem بالمرة
    version = 5, // <<< هنزود الـ version لـ 4
    exportSchema = false
)
abstract class YarmoukGuideDatabase : RoomDatabase() {

    abstract fun facultyDao(): FacultyDao
    abstract fun departmentDao(): DepartmentDao
    abstract fun faqDao(): FaqDao
    abstract fun lectureDao(): LectureDao // (لما نعملهم)
    abstract fun newsDao(): NewsDao // (لما نعملهم)

    companion object {
        @Volatile
        private var INSTANCE: YarmoukGuideDatabase? = null

        fun getDatabase(context: Context): YarmoukGuideDatabase {
            return INSTANCE ?: synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    YarmoukGuideDatabase::class.java,
                    "yarmouk_guide_database"
                )
                    .fallbackToDestructiveMigration()
                    // --- هنا التعديل السحري ---
                    .addCallback(DatabaseCallback(context)) // بنضيف الـ Callback بتاعنا
                    .build()
                INSTANCE = instance
                instance
            }
        }
    }

    // --- هنعمل كلاس داخلي للـ Callback ---
    private class DatabaseCallback(private val context: Context) : RoomDatabase.Callback() {
        override fun onCreate(db: SupportSQLiteDatabase) {
            super.onCreate(db)
            INSTANCE?.let { database ->
                CoroutineScope(Dispatchers.IO).launch {
                    val repository = Repository(
                        database.facultyDao(),
                        database.departmentDao(),
                        database.faqDao(),
                        database.lectureDao() ,
                        database.newsDao()// <<< نبعت الـ DAO الجديد
                    )
                    repository.insertInitialData()
                }
            }
        }
    }
}