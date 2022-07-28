package com.example.caloriecounter.feature.restaurant.ui.categories

import com.example.caloriecounter.base.BaseEvent
import com.example.caloriecounter.base.BaseSideEffect
import com.example.caloriecounter.base.BaseState
import com.example.domain.models.Category

class CategoriesContract {
    sealed class Event : BaseEvent {
        data class SelectedCategory(val category: String) : Event()
        object ReloadData : Event()
    }

    sealed class State : BaseState {
        data class Success(val categories: List<Category>) : State()
        data class Error(val message: String?) : State()
        object Loading : State()
    }

    sealed class Effect : BaseSideEffect {
        sealed class Navigation : Effect() {
            data class ToCategoryMeals(val category: String) : Navigation()
        }
    }
}
