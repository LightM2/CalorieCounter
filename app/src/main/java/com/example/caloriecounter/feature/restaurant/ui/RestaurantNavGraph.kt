package com.example.caloriecounter.feature.restaurant.ui

import androidx.compose.animation.ExperimentalAnimationApi
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.navigation
import com.example.caloriecounter.base.daggerViewModel
import com.example.caloriecounter.di.ActivityComponent
import com.example.caloriecounter.feature.restaurant.RestaurantViewModel
import com.example.caloriecounter.feature.restaurant.ui.categories.CategoryListScreen
import com.example.caloriecounter.ui.Graph
import com.google.accompanist.navigation.animation.composable

@OptIn(ExperimentalAnimationApi::class)
fun NavGraphBuilder.restaurantNavGraph(navController: NavHostController, activityComponent: ActivityComponent) {
    navigation(
        startDestination = RestaurantScreen.CategoryList.route,
        route = Graph.RESTAURANT
    ) {
        var viewModel: RestaurantViewModel? = null

        composable(RestaurantScreen.CategoryList.route) {
            val component = activityComponent.restaurantComponentBuilder.build()

            viewModel = daggerViewModel {
                component.getViewModel()
            }
            viewModel?.let { CategoryListScreen(vm = it) }

        }
        composable(RestaurantScreen.MealList.route) {

        }
        composable(RestaurantScreen.MealRecipe.route) {

        }
    }
}
