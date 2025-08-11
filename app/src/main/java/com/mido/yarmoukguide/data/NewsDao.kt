package com.mido.yarmoukguide.data

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import kotlinx.coroutines.flow.Flow

@Dao
interface NewsDao {
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insertAll(news: List<NewsItem>)

    @Query("SELECT * FROM news_table ORDER BY id DESC") // DESC عشان الأحدث يظهر فوق
    fun getAllNews(): Flow<List<NewsItem>>
}