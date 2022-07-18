package com.example.caloriecounter

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.foundation.layout.systemBarsPadding
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.runtime.SideEffect
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.core.view.WindowCompat
import com.example.caloriecounter.base.daggerViewModel
import com.example.caloriecounter.di.DaggerActivityComponent
import com.example.caloriecounter.feature.diary.DiaryViewModel
import com.example.caloriecounter.feature.diary.ui.DiaryScreen
import com.example.caloriecounter.ui.BottomBar
import com.example.caloriecounter.ui.BottomBarScreen
import com.example.caloriecounter.ui.BottomNavGraph
import com.example.caloriecounter.ui.theme.CalorieCounterTheme
import com.google.accompanist.navigation.animation.AnimatedNavHost
import com.google.accompanist.navigation.animation.composable
import com.google.accompanist.navigation.animation.rememberAnimatedNavController
import com.google.accompanist.systemuicontroller.rememberSystemUiController

class MainActivity : ComponentActivity() {
    @OptIn(ExperimentalAnimationApi::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val activityComponent = DaggerActivityComponent
            .builder()
            .activity(this)
            .context(applicationContext)
            .build()

        WindowCompat.setDecorFitsSystemWindows(window, false)

        setContent {
            CalorieCounterTheme {
                val systemUiController = rememberSystemUiController()
                val useDarkIcons = MaterialTheme.colors.isLight
                val navController = rememberAnimatedNavController()

                SideEffect {
                    systemUiController.setSystemBarsColor(
                        color = Color.Transparent,
                        darkIcons = useDarkIcons
                    )
                }

                Scaffold(
                    bottomBar = {
                        BottomBar(navController = navController)
                    }
                ) { it ->
                    it.calculateTopPadding()
                    BottomNavGraph(
                        navController = navController,
                        activityComponent = activityComponent
                    )
                }


            }
        }
    }
}
