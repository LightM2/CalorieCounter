package com.example.domain.repositories

import com.example.domain.Resource
import com.example.domain.models.Category
import com.example.domain.models.Meal

interface RetrofitRepo {
    suspend fun getMeals(category: String): Resource<List<Meal>>

    suspend fun getCategories(): Resource<List<Category>>

    suspend fun getMealInformation(id: String): Resource<Meal?>
}
