package com.example.caloriecounter.feature.restaurant.ui.categories

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.caloriecounter.feature.restaurant.RestaurantContract
import com.example.caloriecounter.feature.restaurant.RestaurantViewModel
import com.example.caloriecounter.feature.restaurant.ui.RestaurantScreen
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import com.example.caloriecounter.R

@Composable
fun CategoryListScreen(vm: RestaurantViewModel, navController: NavController) {
    val state = vm.viewState.collectAsState()

    LaunchedEffect(Unit) {
        vm.effect.onEach { effect ->
            when (effect) {
                is RestaurantContract.Effect.Navigation.ToCategoryMeals -> {
                    navController.navigate(RestaurantScreen.MealList.route)
                }
            }
        }.launchIn(this)
    }

    LazyColumn(modifier = Modifier.fillMaxSize()) {
        item {
            Text(
                text = stringResource(id = R.string.categories),
                modifier = Modifier.fillMaxWidth(),
                style = MaterialTheme.typography.h5,
                textAlign = TextAlign.Center,
                color = MaterialTheme.colors.primary
            )
        }

        items(items = state.value.categories.data, key = { it.id }) { category ->
            CategoryItemComponent(
                category = category,
                onClick = { vm.setEvent(RestaurantContract.Event.SelectedCategory(it)) },
                modifier = Modifier.padding(vertical = 8.dp, horizontal = 16.dp)
            )
        }
    }
}
