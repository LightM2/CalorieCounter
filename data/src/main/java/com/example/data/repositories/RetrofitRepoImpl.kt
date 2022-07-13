package com.example.data.repositories

import com.example.data.ApiService
import com.example.data.models.*
import com.example.domain.Resource
import com.example.domain.handleMappedResponse
import com.example.domain.models.Category
import com.example.domain.models.Meal
import com.example.domain.repositories.RetrofitRepo
import javax.inject.Inject

class RetrofitRepoImpl @Inject constructor(private val apiService: ApiService) : RetrofitRepo {
    override suspend fun getMeals(category: String): Resource<List<Meal>> =
        handleMappedResponse(
            call = { apiService.getMeals(category) },
            toDomainModel = Meals::toListOfMeal
        )

    override suspend fun getCategories(): Resource<List<Category>> =
        handleMappedResponse(
            call = { apiService.getCategories() },
            toDomainModel = Categories::toListOfCategory
        )

    override suspend fun getMealInformation(id: String): Resource<Meal?> =
        handleMappedResponse(
            call = { apiService.getMealInformation(id) },
            toDomainModel = Meals::toMeal
        )
}
