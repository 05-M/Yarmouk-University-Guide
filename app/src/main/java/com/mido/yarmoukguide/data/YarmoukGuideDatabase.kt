package com.mido.yarmoukguide.data

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase


@Database(
    entities = [Faculty::class],
    version = 1,
    exportSchema = false
)
abstract class YarmoukGuideDatabase: RoomDatabase() {
    abstract fun facultyDao (): FacultyDao

    companion object{
        @Volatile
        private var INSTANCE: YarmoukGuideDatabase? = null

        fun getDataBase(context: Context): YarmoukGuideDatabase{
            return INSTANCE?:synchronized(this){
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    YarmoukGuideDatabase::class.java,
                    "yarmouk_guide_database"
                )
                    .build()
                INSTANCE= instance
                instance
            }
        }
    }
}