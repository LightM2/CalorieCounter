package com.example.caloriecounter.ui

import androidx.annotation.StringRes
import com.example.caloriecounter.R

sealed class BottomBarScreen(
    var route: String,
    @StringRes var title: Int,
    var icon: Int
) {
    object Diary : BottomBarScreen("diary", R.string.diary_screen, R.drawable.ic_diary)
    object Restaurant : BottomBarScreen("restaurant", R.string.restaurant_screen, R.drawable.ic_restaurant)
    object Profile : BottomBarScreen("profile", R.string.profile_screen, R.drawable.ic_profile)
}
