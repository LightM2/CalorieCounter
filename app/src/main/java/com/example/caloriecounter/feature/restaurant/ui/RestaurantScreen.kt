package com.example.caloriecounter.feature.restaurant.ui

sealed class RestaurantScreen(val route: String) {
    object CategoryList : RestaurantScreen("category_list")
    data class MealList(val argument: String = "category") : RestaurantScreen("meal_list")
    data class MealRecipe(val argument: String = "mealId") : RestaurantScreen("meal_recipe")
}
