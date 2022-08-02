package com.example.caloriecounter.feature.restaurant.ui.meals

import com.example.caloriecounter.base.BaseEvent
import com.example.caloriecounter.base.BaseSideEffect
import com.example.caloriecounter.base.BaseState
import com.example.domain.models.Meal

class MealsContract {
    sealed class Event : BaseEvent {
        data class SelectedMeal(val mealId: String) : Event()
        object ReloadData : Event()
    }

    sealed class State : BaseState {
        data class Success(val category: String, val meals: List<Meal>) : State()
        data class Error(val message: String?) : State()
        object Loading : State()
    }

    sealed class Effect : BaseSideEffect {
        sealed class Navigation : Effect() {
            data class ToMealRecipe(val mealId: String) : Navigation()
        }
    }
}
