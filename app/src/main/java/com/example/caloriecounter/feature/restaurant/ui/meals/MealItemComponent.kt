package com.example.caloriecounter.feature.restaurant.ui.meals

import androidx.compose.foundation.layout.*
import androidx.compose.material.Card
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.example.caloriecounter.R
import com.example.caloriecounter.ui.theme.CalorieCounterTheme
import com.example.domain.models.Meal

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun MealItemComponent(
    meal: Meal,
    modifier: Modifier = Modifier,
    onClick: (id: String) -> Unit,
) {
    Card(
        modifier = modifier.fillMaxWidth(),
        onClick = { onClick(meal.id) },
        elevation = 4.dp,
    ) {
        Column {
            AsyncImage(
                model = ImageRequest.Builder(LocalContext.current)
                    .data(meal.thumb)
                    .crossfade(true)
                    .build(),
                contentDescription = stringResource(id = R.string.meal),
                placeholder = painterResource(id = R.drawable.ic_meal_placeholder),
                error = painterResource(id = R.drawable.ic_meal_placeholder),
                contentScale = ContentScale.FillBounds,
                modifier = Modifier.aspectRatio(16 / 9f)
            )
            Spacer(modifier = Modifier.height(16.dp))
            Text(
                text = meal.name,
                modifier = Modifier.padding(horizontal = 16.dp),
                style = MaterialTheme.typography.body1,
            )
            Spacer(modifier = Modifier.height(16.dp))
        }
    }
}

@Preview(name = "MealItemComponent")
@Composable
private fun MealItemComponentPreview() {
    CalorieCounterTheme {
        MealItemComponent(
            meal = Meal(
                id = "1",
                name = "Mediterranean Pasta Salad",
                thumb = ""
            ),
            onClick = {}
        )
    }
}
