package com.example.caloriecounter.feature.restaurant.ui.meals

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.sp
import com.example.caloriecounter.feature.restaurant.RestaurantViewModel

@Composable
fun MealList(category: String) {
    Text(
        text = "$category MealList",
        fontSize = 24.sp,
        color = Color.DarkGray,
        modifier = Modifier.fillMaxSize(),
        textAlign = TextAlign.Center,
    )
}