package com.example.data.retrofit

import com.example.data.retrofit.models.Categories
import com.example.data.retrofit.models.Meals
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface ApiService {

    @GET("filter.php")
    suspend fun getMeals(@Query("c") categoryName: String): Response<Meals>

    @GET("categories.php")
    suspend fun getCategories(): Response<Categories>

    @GET("lookup.php")
    suspend fun getMealInformation(@Query("i") id: String): Response<Meals>
}
