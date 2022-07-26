package com.example.caloriecounter.feature.restaurant.ui

sealed class RestaurantScreen(val route: String, val navToRoute: String = route) {
    object CategoryList : RestaurantScreen("category_list")
    data class MealList(val argument: String = "category") :
        RestaurantScreen("meal_list/{$argument}", "meal_list/$argument")

    data class MealRecipe(val argument: String = "mealId") :
        RestaurantScreen("meal_recipe/{$argument}", "meal_list/$argument")
}
