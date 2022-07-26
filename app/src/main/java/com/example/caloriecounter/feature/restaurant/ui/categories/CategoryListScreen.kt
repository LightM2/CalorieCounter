package com.example.caloriecounter.feature.restaurant.ui.categories

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
import androidx.compose.ui.unit.dp
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import com.example.caloriecounter.R
import com.example.caloriecounter.base.DataState
import com.example.domain.models.Category
import kotlinx.coroutines.flow.Flow

@Composable
fun CategoryListScreen(
    categories: DataState<List<Category>>,
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

            items(items = categories.data, key = { it.id }) { category ->
                CategoryItemComponent(
                    category = category,
                    onClick = { onEventSent(CategoriesContract.Event.SelectedCategory(it)) },
                    modifier = Modifier.padding(vertical = 8.dp, horizontal = 16.dp)
                )
            }
        }

        AnimatedVisibility(
            visible = categories.isLoading,
            modifier = Modifier.align(Alignment.Center),
            enter = fadeIn(),
            exit = fadeOut()
        ) {
            CircularProgressIndicator()
        }
    }
}
