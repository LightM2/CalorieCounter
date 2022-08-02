package com.example.caloriecounter.feature.restaurant.ui

import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.navigation.*
import com.example.caloriecounter.base.connectArgs
import com.example.caloriecounter.base.daggerViewModel
import com.example.caloriecounter.base.withArgs
import com.example.caloriecounter.di.ActivityComponent
import com.example.caloriecounter.feature.restaurant.ui.categories.CategoryListScreen
import com.example.caloriecounter.feature.restaurant.ui.meals.MealListScreen
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
            val component = activityComponent.restaurantCategoriesComponentBuilder.build()
            val vm = daggerViewModel {
                component.getViewModel()
            }
            val state = vm.viewState.collectAsState()

            CategoryListScreen(
                categoriesState = state.value,
                effectFlow = vm.effect,
                onEventSent = vm::setEvent,
                onNavigationRequested = { category ->
                    RestaurantScreen.MealList(category).apply {
                        navController.navigate(route.withArgs(argument))
                    }
                }
            )
        }
        composable(
            route = RestaurantScreen.MealList().let { it.route.connectArgs(it.argument) },
            arguments = listOf(navArgument(RestaurantScreen.MealList().argument) {
                type = NavType.StringType
            })
        ) { backStackEntry ->
            val component = activityComponent.restaurantMealsComponentBuilder
                .navBackStackEntry(backStackEntry)
                .build()
            val vm = daggerViewModel {
                component.getViewModel()
            }
            val state = vm.viewState.collectAsState()

            MealListScreen(
                mealsState = state.value,
                effectFlow = vm.effect,
                onEventSent = vm::setEvent,
                onNavigationRequested = { mealId ->
                    RestaurantScreen.MealRecipe(mealId).apply {
                        navController.navigate(route.withArgs(argument))
                    }
                }
            )
        }
        composable(
            route = RestaurantScreen.MealRecipe().let { it.route.connectArgs(it.argument) },
            arguments = listOf(navArgument(RestaurantScreen.MealRecipe().argument) {
                type = NavType.StringType
            })
        ) {

        }
    }
}
