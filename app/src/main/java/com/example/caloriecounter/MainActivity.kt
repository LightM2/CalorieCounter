package com.example.caloriecounter

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.systemBarsPadding
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.SideEffect
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import androidx.core.view.WindowCompat
import androidx.navigation.compose.rememberNavController
import com.example.caloriecounter.base.daggerViewModel
import com.example.caloriecounter.feature.diary.DiaryViewModel
import com.example.caloriecounter.feature.diary.di.DaggerDiaryComponent
import com.example.caloriecounter.ui.theme.CalorieCounterTheme
import com.google.accompanist.navigation.animation.AnimatedNavHost
import com.google.accompanist.navigation.animation.composable
import com.google.accompanist.navigation.animation.rememberAnimatedNavController
import com.google.accompanist.systemuicontroller.rememberSystemUiController

class MainActivity : ComponentActivity() {
    @OptIn(ExperimentalAnimationApi::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
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

                AnimatedNavHost(
                    navController = navController,
                    startDestination = NavigationDestination.DiaryScreen.destination
                ) {
                    composable(NavigationDestination.DiaryScreen.destination) {

                        val component = DaggerDiaryComponent.builder().build()

                        val viewModel: DiaryViewModel = daggerViewModel {
                            component.getViewModel()
                        }

                        Text(
                            text = "DiaryScreen: vm - ${viewModel.TAG}",
                            modifier = Modifier.systemBarsPadding(),
                            color = Color.DarkGray
                        )
                    }

                }

            }
        }
    }
}
