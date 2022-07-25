package com.example.caloriecounter.feature.restaurant

import androidx.lifecycle.viewModelScope
import com.example.caloriecounter.base.BaseViewModel
import com.example.caloriecounter.base.DataState
import com.example.domain.handle
import com.example.domain.usecases.retrofit.GetCategoryListUseCase
import kotlinx.coroutines.launch
import javax.inject.Inject

class RestaurantViewModel @Inject constructor(
    val getCategoryListUseCase: GetCategoryListUseCase,
) : BaseViewModel<RestaurantContract.Event, RestaurantContract.State, RestaurantContract.Effect>() {

    init {
        getCategories()
    }

    private fun getCategories() {
        viewModelScope.launch {
            getCategoryListUseCase().handle(
                onSuccess = {
                    setState {
                        copy(categories = DataState(it, false))
                    }
                },
                onError = {}
            )
        }
    }

    override fun setInitialState(): RestaurantContract.State = RestaurantContract.State(
        categories = DataState(listOf(), true),
        meals = DataState(listOf(), true),
        mealRecipe = DataState(null, true),
    )

    override fun handleEvents(event: RestaurantContract.Event) {
        when (event) {
            is RestaurantContract.Event.SelectedCategory -> {
                setEffect { RestaurantContract.Effect.Navigation.ToCategoryMeals(event.category) }

            }
        }
    }
}