package com.example.caloriecounter.feature.restaurant.ui.categories

import com.example.caloriecounter.base.BaseEvent
import com.example.caloriecounter.base.BaseSideEffect
import com.example.caloriecounter.base.BaseState
import com.example.domain.models.Category

sealed class CategoriesEvent : BaseEvent {
  data class SelectedCategory(val category: String) : CategoriesEvent()
  object ReloadData : CategoriesEvent()
}

sealed class CategoriesState : BaseState {
  data class Success(val categories: List<Category>) : CategoriesState()
  data class Error(val message: String?) : CategoriesState()
  object Loading : CategoriesState()
}

sealed class CategoriesEffect : BaseSideEffect {
  sealed class Navigation : CategoriesEffect() {
    data class ToCategoryMeals(val category: String) : Navigation()
  }
}

