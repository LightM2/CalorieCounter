package com.example.caloriecounter.feature.restaurant.ui.meals

import com.example.caloriecounter.base.BaseEvent
import com.example.caloriecounter.base.BaseSideEffect
import com.example.caloriecounter.base.BaseState
import com.example.domain.models.Meal

sealed class MealsEvent : BaseEvent {
  data class SelectedMeal(val mealId: String) : MealsEvent()
  object ReloadData : MealsEvent()
}

sealed class MealsState : BaseState {
  data class Success(val category: String, val meals: List<Meal>) : MealsState()
  data class Error(val message: String?) : MealsState()
  object Loading : MealsState()
}

sealed class MealsEffect : BaseSideEffect {
  sealed class Navigation : MealsEffect() {
    data class ToMealRecipe(val mealId: String) : Navigation()
  }
}

