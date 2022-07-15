package com.example.data.repositories

import com.example.data.room.MealDao
import com.example.data.room.toMeal
import com.example.data.room.toMealEntity
import com.example.domain.models.Meal
import com.example.domain.repositories.RoomRepo
import javax.inject.Inject

class RoomRepoImpl @Inject constructor(private val mealDao: MealDao) : RoomRepo {
    override suspend fun getAllMeals(): List<Meal> {
        return mealDao.getAll().map { it.toMeal() }
    }

    override suspend fun delete(meal: Meal) {
        val mealEntity = meal.toMealEntity()
        mealDao.delete(mealEntity)
    }

    override suspend fun addMeal(meal: Meal) {
        val mealEntity = meal.toMealEntity()
        mealDao.insert(mealEntity)
    }
}
