package com.example.caloriecounter.feature.restaurant

import com.example.caloriecounter.base.BaseViewModel
import javax.inject.Inject

class RestaurantViewModel @Inject constructor() :
    BaseViewModel<RestaurantContract.Event, RestaurantContract.State, RestaurantContract.Effect>() {
    override fun setInitialState(): RestaurantContract.State {
        return RestaurantContract.State()
    }

    override fun handleEvents(event: RestaurantContract.Event) {}
}