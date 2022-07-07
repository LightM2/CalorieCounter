package com.example.data.models

import com.example.domain.models.Meal
import com.google.gson.annotations.SerializedName

data class Meals(
    @SerializedName("meals")
    val data: List<MealDetails>
)

fun Meals.toListOfMeal(): List<Meal> = data.map { it.toMeal() }

fun Meals.toMeal(): Meal? = data.firstOrNull()?.toMeal()
