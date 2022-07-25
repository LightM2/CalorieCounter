package com.example.caloriecounter.feature.restaurant

import com.example.caloriecounter.base.BaseEvent
import com.example.caloriecounter.base.BaseSideEffect
import com.example.caloriecounter.base.BaseState
import com.example.caloriecounter.base.DataState
import com.example.domain.models.Category
import com.example.domain.models.Meal

class RestaurantContract {
    sealed class Event : BaseEvent {
        data class SelectedCategory(val category: String) : Event()
    }

    data class State(
        val categories: DataState<List<Category>>,
        val meals: DataState<List<Meal>>,
        val mealRecipe: DataState<Meal?>,
    ) : BaseState

    sealed class Effect : BaseSideEffect {
        sealed class Navigation : Effect() {
            data class ToCategoryMeals(val category: String) : Navigation()
        }
    }
}