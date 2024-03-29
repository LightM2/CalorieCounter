package com.example.caloriecounter.feature.restaurant.ui.categories

import androidx.compose.animation.animateContentSize
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.Card
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.example.caloriecounter.R
import com.example.caloriecounter.ui.theme.CalorieCounterTheme
import com.example.domain.models.Category

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun CategoryItemComponent(
    category: Category,
    modifier: Modifier = Modifier,
    onClick: (String) -> Unit,
) {
    Card(
        modifier = modifier.fillMaxWidth(),
        onClick = { onClick(category.name) },
        elevation = 4.dp,
    ) {
        var expanded by rememberSaveable { mutableStateOf(false) }
        Column {
            AsyncImage(
                model = ImageRequest.Builder(LocalContext.current)
                    .data(category.thumb)
                    .crossfade(true)
                    .build(),
                contentDescription = stringResource(id = R.string.category),
                placeholder = painterResource(id = R.drawable.ic_meal_placeholder),
                error = painterResource(id = R.drawable.ic_meal_placeholder),
                contentScale = ContentScale.FillWidth,
                modifier = Modifier.aspectRatio(16 / 9f)
            )
            Spacer(modifier = Modifier.height(16.dp))
            Text(
                text = category.name,
                modifier = Modifier.padding(horizontal = 16.dp),
                style = MaterialTheme.typography.body1.copy(fontWeight = FontWeight.Bold),
            )
            Spacer(modifier = Modifier.height(8.dp))
            Text(
                text = category.description,
                modifier = Modifier
                    .padding(horizontal = 16.dp)
                    .animateContentSize()
                    .clickable { expanded = !expanded },
                style = MaterialTheme.typography.body2,
                color = MaterialTheme.colors.onBackground.copy(alpha = 0.5f),
                maxLines = if (expanded) 10 else 2,
                overflow = TextOverflow.Ellipsis
            )
            Spacer(modifier = Modifier.height(16.dp))
        }
    }
}

@Preview(name = "CategoryItemComponent")
@Composable
private fun CategoryItemComponentPreview() {
    CalorieCounterTheme {
        CategoryItemComponent(
            category = Category(
                id = "1",
                name = "Dessert",
                description = "Dessert is a course that concludes a meal. The course usually " +
                        "consists of sweet foods, such as confections dishes or fruit, and " +
                        "possibly a beverage such as dessert wine or liqueur, however in the " +
                        "United States it may include coffee, cheeses, nuts, or other savory " +
                        "items regarded as a separate course elsewhere.",
                thumb = ""
            ),
            onClick = {}
        )
    }
}
