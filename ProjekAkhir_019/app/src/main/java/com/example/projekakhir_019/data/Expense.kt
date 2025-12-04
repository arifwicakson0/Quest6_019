package com.example.projekakhir_019.data

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "expense")
data class Expense(
    @PrimaryKey(autoGenerate = true) val id: Int = 0,
    val amount: Long,
    val category: String,
    val note: String?,
    val date: Long
)
