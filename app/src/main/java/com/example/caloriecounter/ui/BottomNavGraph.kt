package com.example.caloriecounter.ui

import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.foundation.layout.systemBarsPadding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import com.example.caloriecounter.base.daggerViewModel
import com.example.caloriecounter.di.ActivityComponent
import com.example.caloriecounter.feature.diary.DiaryViewModel
import com.example.caloriecounter.feature.diary.ui.DiaryScreen
import com.example.caloriecounter.feature.profile.ProfileViewModel
import com.example.caloriecounter.feature.profile.ui.ProfileScreen
import com.example.caloriecounter.feature.restaurant.RestaurantViewModel
import com.example.caloriecounter.feature.restaurant.ui.RestaurantScreen
import com.example.caloriecounter.feature.restaurant.ui.restaurantNavGraph
import com.google.accompanist.navigation.animation.AnimatedNavHost
import com.google.accompanist.navigation.animation.composable

@OptIn(ExperimentalAnimationApi::class)
@Composable
fun BottomNavGraph(
    navController: NavHostController,
    activityComponent: ActivityComponent,
) {
    AnimatedNavHost(
        navController = navController,
        startDestination = BottomBarScreen.Diary.route,
        route = Graph.ROOT,
        modifier = Modifier.systemBarsPadding()
    ) {
        composable(BottomBarScreen.Diary.route) {
            val component = activityComponent.diaryComponentBuilder.build()

            val viewModel: DiaryViewModel = daggerViewModel {
                component.getViewModel()
            }

            DiaryScreen(vm = viewModel)
        }
        composable(BottomBarScreen.Restaurant.route) {
            navController.navigate(Graph.RESTAURANT)
        }
        composable(BottomBarScreen.Profile.route) {
            val component = activityComponent.profileComponentBuilder.build()

            val viewModel: ProfileViewModel = daggerViewModel {
                component.getViewModel()
            }

            ProfileScreen(vm = viewModel)
        }
        restaurantNavGraph(navController, activityComponent)
    }
}

object Graph {
    const val ROOT = "root_graph"
    const val RESTAURANT = "restaurant_graph"
}
