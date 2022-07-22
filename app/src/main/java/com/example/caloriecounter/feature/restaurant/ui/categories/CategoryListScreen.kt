package com.example.caloriecounter.feature.restaurant.ui.categories

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.caloriecounter.feature.restaurant.RestaurantViewModel
import com.example.caloriecounter.feature.restaurant.ui.RestaurantScreen

@Composable
fun CategoryListScreen(vm: RestaurantViewModel, navController: NavController) {
    Column(modifier = Modifier.fillMaxSize(),) {
        Text(
            text = "CategoryList",
            fontSize = 24.sp,
            color = Color.DarkGray,
            textAlign = TextAlign.Center,
        )
        Spacer(modifier = Modifier.height(24.dp))
        Button(onClick = { navController.navigate(RestaurantScreen.MealList.route) }) {
            Text(
                text = "MealList",
            )
        }
    }

}