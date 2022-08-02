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
) : BaseViewModel<MealsContract.Event, MealsContract.State, MealsContract.Effect>() {

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
                        MealsContract.State.Success(category = category, meals = meals)
                    }
                },
                onError = { message ->
                    setState {
                        MealsContract.State.Error(message)
                    }
                }
            )
        }
    }

    override fun setInitialState(): MealsContract.State = MealsContract.State.Loading

    override fun handleEvents(event: MealsContract.Event) {
        when (event) {
            is MealsContract.Event.SelectedMeal -> {
                setEffect { MealsContract.Effect.Navigation.ToMealRecipe(event.mealId) }
            }
            is MealsContract.Event.ReloadData -> {
                setInitialState()
                getMealList()
            }
        }
    }
}
