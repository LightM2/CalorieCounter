package com.example.data.retrofit

import com.example.data.retrofit.models.Categories
import com.example.data.retrofit.models.Meals
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

interface ApiService {

    @GET("filter.php?c={category}")
    suspend fun getMeals(@Path("category") category: String): Response<Meals>

    @GET("categories.php")
    suspend fun getCategories(): Response<Categories>

    @GET("lookup.php?i={id}")
    suspend fun getMealInformation(@Path("id") id: String): Response<Meals>
}
