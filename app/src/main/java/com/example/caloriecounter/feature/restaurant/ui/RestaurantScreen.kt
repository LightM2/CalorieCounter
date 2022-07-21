package com.example.caloriecounter.feature.restaurant.ui

sealed class RestaurantScreen(val route: String){
    object CategoryList : RestaurantScreen("category_list")
    object MealList : RestaurantScreen("meal_list")
    object MealRecipe : RestaurantScreen("meal_recipe")
}
