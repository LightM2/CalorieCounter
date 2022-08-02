package com.example.caloriecounter.feature.restaurant.ui.categories

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
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import com.example.caloriecounter.R
import com.example.caloriecounter.feature.restaurant.ui.LoadingScreen
import com.example.caloriecounter.ui.ErrorScreen
import kotlinx.coroutines.flow.Flow

@Composable
fun CategoryListScreen(
    categoriesState: CategoriesContract.State,
    effectFlow: Flow<CategoriesContract.Effect>,
    onEventSent: (event: CategoriesContract.Event) -> Unit,
    onNavigationRequested: (category: String) -> Unit,
) {
    LaunchedEffect(Unit) {
        effectFlow.onEach { effect ->
            when (effect) {
                is CategoriesContract.Effect.Navigation.ToCategoryMeals -> {
                    onNavigationRequested(effect.category)
                }
            }
        }.launchIn(this)
    }

    Box(modifier = Modifier.fillMaxSize()) {
        Column {
            Text(
                text = stringResource(id = R.string.categories),
                modifier = Modifier.fillMaxWidth(),
                style = MaterialTheme.typography.h5,
                textAlign = TextAlign.Center,
                color = MaterialTheme.colors.primary
            )

            when (categoriesState) {
                is CategoriesContract.State.Success -> {
                    LazyColumn {
                        items(
                            items = categoriesState.categories,
                            key = { category -> category.id })
                        { category ->
                            CategoryItemComponent(
                                category = category,
                                onClick = { onEventSent(CategoriesContract.Event.SelectedCategory(it)) },
                                modifier = Modifier.padding(vertical = 8.dp, horizontal = 16.dp)
                            )
                        }
                    }
                }
                is CategoriesContract.State.Error -> {
                    ErrorScreen(
                        errorMessage = categoriesState.message
                            ?: stringResource(id = R.string.error),
                        reloadData = { onEventSent(CategoriesContract.Event.ReloadData) }
                    )
                }
            }
        }

        LoadingScreen(visible = categoriesState is CategoriesContract.State.Loading)
    }
}
