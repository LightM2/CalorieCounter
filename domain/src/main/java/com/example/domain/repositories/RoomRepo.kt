package com.example.domain.repositories

import com.example.domain.models.Meal

interface RoomRepo {
    suspend fun getAllMeals(): List<Meal>

    suspend fun delete(meal: Meal)

    suspend fun addMeal(meal: Meal)
}