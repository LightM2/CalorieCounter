package com.example.caloriecounter.ui

import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import com.example.caloriecounter.base.daggerViewModel
import com.example.caloriecounter.di.ActivityComponent
import com.example.caloriecounter.feature.diary.DiaryViewModel
import com.example.caloriecounter.feature.diary.ui.DiaryScreen
import com.example.caloriecounter.feature.profile.ProfileViewModel
import com.example.caloriecounter.feature.profile.ui.ProfileScreen
import com.example.caloriecounter.feature.restaurant.ui.RestaurantNavGraph
import com.google.accompanist.navigation.animation.AnimatedNavHost
import com.google.accompanist.navigation.animation.composable
import com.google.accompanist.navigation.animation.rememberAnimatedNavController

@OptIn(ExperimentalAnimationApi::class)
@Composable
fun BottomNavGraph(
    navController: NavHostController,
    activityComponent: ActivityComponent,
    modifier: Modifier,
) {
    AnimatedNavHost(
        navController = navController,
        startDestination = BottomBarScreen.Diary.route,
        route = Graph.ROOT,
        modifier = modifier
    ) {
        composable(BottomBarScreen.Diary.route) {
            val component = activityComponent.diaryComponentBuilder.build()

            val viewModel: DiaryViewModel = daggerViewModel {
                component.getViewModel()
            }

            DiaryScreen(vm = viewModel)
        }
        composable(BottomBarScreen.Restaurant.route) {
            val restaurantNavController = rememberAnimatedNavController()
            RestaurantNavGraph(
                navController = restaurantNavController,
                activityComponent = activityComponent
            )
        }
        composable(BottomBarScreen.Profile.route) {
            val component = activityComponent.profileComponentBuilder.build()

            val viewModel: ProfileViewModel = daggerViewModel {
                component.getViewModel()
            }

            ProfileScreen(vm = viewModel)
        }
    }
}

object Graph {
    const val ROOT = "root_graph"
    const val RESTAURANT = "restaurant_graph"
}
