// في ملف: app/src/main/java/com/mido/yarmoukguide/data/YarmoukGuideDatabase.kt

package com.mido.yarmoukguide.data

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(
    entities = [
        Faculty::class,
        Department::class,
        FaqItem::class
    ],
    version = 3,
    exportSchema = false
)
abstract class YarmoukGuideDatabase : RoomDatabase() {

    abstract fun facultyDao(): FacultyDao
    abstract fun departmentDao(): DepartmentDao
    abstract fun faqDao(): FaqDao

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
                    .build()
                INSTANCE = instance
                instance
            }
        }
    }
}