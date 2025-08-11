package com.mido.yarmoukguide.data

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import kotlinx.coroutines.flow.Flow

@Dao
interface FaqDao {
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insertAll(faqItems: List<FaqItem>)

    @Query("SELECT * FROM faq_table ORDER BY id ASC")
    fun getAllFaqs(): Flow<List<FaqItem>>
}