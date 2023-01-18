package com.example.caloriecounter.feature.restaurant.ui.meals

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.viewModelScope
import com.example.caloriecounter.base.BaseViewModel
import com.example.caloriecounter.base.ViewModelAssistedFactory
import com.example.caloriecounter.feature.restaurant.ui.RestaurantScreen
import com.example.domain.handle
import com.example.domain.usecases.retrofit.GetMealListUseCase
import dagger.assisted.Assisted
import dagger.assisted.AssistedFactory
import dagger.assisted.AssistedInject
import kotlinx.coroutines.launch

class MealsViewModel @AssistedInject constructor(
  private val getMealListUseCase: GetMealListUseCase,
  @Assisted private val savedStateHandle: SavedStateHandle,
) : BaseViewModel<MealsEvent, MealsState, MealsEffect>() {

  private val category: String by lazy {
    savedStateHandle.get<String>(RestaurantScreen.MealList().argument) ?: ""
  }

  init {
    getMealList()
  }

  private fun getMealList() {
    viewModelScope.launch {
      getMealListUseCase(category).handle(
        onSuccess = { meals ->
          setState {
            MealsState.Success(category = category, meals = meals)
          }
        },
        onError = { message ->
          setState {
            MealsState.Error(message)
          }
        }
      )
    }
  }

  override fun setInitialState(): MealsState = MealsState.Loading

  override fun handleEvents(event: MealsEvent) {
    when (event) {
      is MealsEvent.SelectedMeal -> {
        setEffect { MealsEffect.Navigation.ToMealRecipe(event.mealId) }
      }
      is MealsEvent.ReloadData -> {
        setInitialState()
        getMealList()
      }
    }
  }

  @AssistedFactory
  interface Factory : ViewModelAssistedFactory<MealsViewModel>
}
