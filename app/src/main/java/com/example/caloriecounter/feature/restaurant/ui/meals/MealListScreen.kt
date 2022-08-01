package com.example.caloriecounter.feature.restaurant.ui.meals

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import com.example.caloriecounter.R
import com.example.caloriecounter.ui.ErrorScreen
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach

@Composable
fun MealListScreen(
    mealsState: MealsContract.State,
    effectFlow: Flow<MealsContract.Effect>,
    onEventSent: (event: MealsContract.Event) -> Unit,
    onNavigationRequested: (mealId: String) -> Unit,
) {
    LaunchedEffect(Unit) {
        effectFlow.onEach { effect ->
            when (effect) {
                is MealsContract.Effect.Navigation.ToMealRecipe -> {
                    onNavigationRequested(effect.mealId)
                }
            }
        }.launchIn(this)
    }

    Box(modifier = Modifier.fillMaxSize()) {
        Column {
            Text(
                text = stringResource(id = R.string.meals),
                modifier = Modifier.fillMaxWidth(),
                style = MaterialTheme.typography.h5,
                textAlign = TextAlign.Center,
                color = MaterialTheme.colors.primary
            )

            when (mealsState) {
                is MealsContract.State.Success -> {
                    LazyColumn {
                        items(
                            items = mealsState.meals,
                            key = { meal -> meal.id })
                        { meal ->
                            MealItemComponent(meal = meal, onClick = onNavigationRequested)
                        }
                    }
                }
                is MealsContract.State.Error -> {
                    ErrorScreen(
                        errorMessage = mealsState.message
                            ?: stringResource(id = R.string.error),
                        reloadData = { onEventSent(MealsContract.Event.ReloadData) }
                    )
                }
            }
        }

        //Loading
        AnimatedVisibility(
            visible = mealsState is MealsContract.State.Loading,
            modifier = Modifier.align(Alignment.Center),
            enter = fadeIn(),
            exit = fadeOut()
        ) {
            CircularProgressIndicator()
        }
    }
}
