package com.example.projekakhir_019.data

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query

@Dao
interface ExpenseDao {

    @Insert
    suspend fun addExpense(expense: Expense)

    @Query("SELECT * FROM expense ORDER BY date DESC")
    suspend fun getAllExpenses(): List<Expense>
}
