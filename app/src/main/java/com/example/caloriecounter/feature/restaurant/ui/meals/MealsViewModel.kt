package com.example.caloriecounter.feature.restaurant.ui.meals

import androidx.lifecycle.viewModelScope
import androidx.navigation.NavBackStackEntry
import com.example.caloriecounter.base.BaseViewModel
import com.example.caloriecounter.feature.restaurant.ui.RestaurantScreen
import com.example.domain.handle
import com.example.domain.usecases.retrofit.GetMealListUseCase
import kotlinx.coroutines.launch
import javax.inject.Inject

class MealsViewModel @Inject constructor(
    private val getMealListUseCase: GetMealListUseCase,
    private val backStackEntry: NavBackStackEntry,
) : BaseViewModel<MealsEvent, MealsState, MealsEffect>() {

    private var category = ""

    init {
        getCategory()
        getMealList()
    }

    private fun getCategory() {
        category = backStackEntry.arguments
            ?.getString(RestaurantScreen.MealList().argument) ?: ""
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
}
