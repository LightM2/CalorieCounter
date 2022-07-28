package com.example.caloriecounter

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.runtime.SideEffect
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.core.view.WindowCompat
import com.example.caloriecounter.di.DaggerActivityComponent
import com.example.caloriecounter.ui.BottomBar
import com.example.caloriecounter.ui.BottomNavGraph
import com.example.caloriecounter.ui.theme.CalorieCounterTheme
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
                ) { paddings ->
                    BottomNavGraph(
                        navController = navController,
                        activityComponent = activityComponent,
                        modifier = Modifier
                            .padding(bottom = paddings.calculateBottomPadding())
                            .statusBarsPadding()
                    )
                }
            }
        }
    }
}
