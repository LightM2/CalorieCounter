package com.example.caloriecounter.feature.restaurant.ui.meals

import androidx.lifecycle.SavedStateHandle
import com.example.caloriecounter.base.BaseViewModel
import com.example.domain.usecases.retrofit.GetMealListUseCase
import javax.inject.Inject

class MealsViewModel @Inject constructor(
    private val getMealListUseCase: GetMealListUseCase,
    private val stateHandle: SavedStateHandle,
) : BaseViewModel<MealsContract.Event, MealsContract.State, MealsContract.Effect>() {


    override fun setInitialState(): MealsContract.State = MealsContract.State.Loading

    override fun handleEvents(event: MealsContract.Event) {
        when (event) {
            is MealsContract.Event.SelectedMeal -> {
                setEffect { MealsContract.Effect.Navigation.ToMealRecipe(event.mealId) }
            }
            is MealsContract.Event.ReloadData -> {

            }
        }
    }
}
