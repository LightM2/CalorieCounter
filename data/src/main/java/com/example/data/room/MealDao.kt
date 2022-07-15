package com.example.data.room

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query

@Dao
interface MealDao {
    @Query("SELECT * FROM MealEntity")
    fun getAll(): List<MealEntity>

    @Insert
    suspend fun insert(meal: MealEntity)

    @Delete
    fun delete(meal: MealEntity)
}