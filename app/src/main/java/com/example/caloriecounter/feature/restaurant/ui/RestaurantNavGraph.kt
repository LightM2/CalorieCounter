package com.example.caloriecounter.feature.restaurant.ui

import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.navigation.*
import com.example.caloriecounter.base.daggerViewModel
import com.example.caloriecounter.di.ActivityComponent
import com.example.caloriecounter.feature.restaurant.ui.categories.CategoryListScreen
import com.example.caloriecounter.feature.restaurant.ui.meals.MealList
import com.example.caloriecounter.ui.Graph
import com.google.accompanist.navigation.animation.AnimatedNavHost
import com.google.accompanist.navigation.animation.composable

@OptIn(ExperimentalAnimationApi::class)
@Composable
fun RestaurantNavGraph(navController: NavHostController, activityComponent: ActivityComponent) {
    AnimatedNavHost(
        navController = navController,
        route = Graph.RESTAURANT,
        startDestination = RestaurantScreen.CategoryList.route
    ) {
        composable(RestaurantScreen.CategoryList.route) {
            val component = activityComponent.restaurantComponentBuilder.build()
            val vm = daggerViewModel {
                component.getViewModel()
            }
            val state = vm.viewState.collectAsState()

            CategoryListScreen(
                categories = state.value.categories,
                effectFlow = vm.effect,
                onEventSent = vm::setEvent,
                onNavigationRequested = { navController.navigate(RestaurantScreen.MealList(it).navToRoute) }
            )
        }
        composable(
            route = RestaurantScreen.MealList().route,
            arguments = listOf(navArgument(RestaurantScreen.MealList().argument) {
                type = NavType.StringType
            })
        ) { backStackEntry ->
            val category =
                backStackEntry.arguments?.getString(RestaurantScreen.MealList().argument) ?: ""
            MealList(category)
        }
        composable(
            route = RestaurantScreen.MealRecipe().route,
            arguments = listOf(navArgument(RestaurantScreen.MealRecipe().argument) {
                type = NavType.StringType
            })
        ) {

        }
    }
}
