package com.example.roomtest.data

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "photo_table")
data class Photo (
    @PrimaryKey(autoGenerate = true)
    val id: Int,
    val name: String,
    val logo: String
)