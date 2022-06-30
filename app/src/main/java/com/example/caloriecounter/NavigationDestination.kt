package com.example.caloriecounter

sealed class NavigationDestination(val destination: String) {
    object DiaryScreen : NavigationDestination("DiaryScreen")
    object RestaurantScreen : NavigationDestination("RestaurantScreen")
}
