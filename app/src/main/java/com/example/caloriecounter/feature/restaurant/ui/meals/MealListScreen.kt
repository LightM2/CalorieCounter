package com.example.caloriecounter.feature.restaurant.ui.meals

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.example.caloriecounter.R
import com.example.caloriecounter.feature.restaurant.ui.LoadingScreen
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
            when (mealsState) {
                is MealsContract.State.Success -> {
                    Text(
                        text = mealsState.category,
                        modifier = Modifier.fillMaxWidth(),
                        style = MaterialTheme.typography.h5,
                        textAlign = TextAlign.Center,
                        color = MaterialTheme.colors.primary
                    )

                    LazyColumn {
                        items(
                            items = mealsState.meals,
                            key = { meal -> meal.id }
                        ) { meal ->
                            MealItemComponent(
                                meal = meal,
                                onClick = onNavigationRequested,
                                modifier = Modifier.padding(vertical = 8.dp, horizontal = 16.dp)
                            )
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

        LoadingScreen(visible = mealsState is MealsContract.State.Loading)
    }
}
