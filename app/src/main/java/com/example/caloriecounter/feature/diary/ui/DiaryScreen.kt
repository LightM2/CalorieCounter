package com.example.caloriecounter.feature.diary.ui

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.sp
import com.example.caloriecounter.feature.diary.DiaryViewModel

@Composable
fun DiaryScreen(
    vm: DiaryViewModel,
) {
    Text(
        text = "DiaryScreen",
        fontSize = 24.sp,
        color = Color.DarkGray,
        modifier = Modifier.fillMaxSize()
    )
}