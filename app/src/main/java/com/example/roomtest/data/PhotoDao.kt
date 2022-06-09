package com.example.roomtest.data

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import kotlinx.coroutines.flow.Flow

@Dao
interface PhotoDao {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun addPhoto(photo: Photo)

    @Query("SELECT * FROM photo_table")
    fun readAllData(): LiveData<List<Photo>>




}