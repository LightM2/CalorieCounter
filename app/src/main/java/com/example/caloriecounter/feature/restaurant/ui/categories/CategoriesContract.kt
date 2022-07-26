package com.example.caloriecounter.feature.restaurant.ui.categories

import com.example.caloriecounter.base.BaseEvent
import com.example.caloriecounter.base.BaseSideEffect
import com.example.caloriecounter.base.BaseState
import com.example.caloriecounter.base.DataState
import com.example.domain.models.Category

class CategoriesContract {
    sealed class Event : BaseEvent {
        data class SelectedCategory(val category: String) : Event()
    }

    data class State(
        val categories: DataState<List<Category>>,
    ) : BaseState

    sealed class Effect : BaseSideEffect {
        sealed class Navigation : Effect() {
            data class ToCategoryMeals(val category: String) : Navigation()
        }
    }
}