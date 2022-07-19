package com.example.caloriecounter.feature.restaurant.di

import com.example.caloriecounter.feature.restaurant.RestaurantViewModel
import dagger.Subcomponent

@Subcomponent(modules = [RestaurantModule::class])
@RestaurantScope
interface RestaurantComponent {
    @Subcomponent.Builder
    interface Builder {
        fun build(): RestaurantComponent
    }

    fun getViewModel(): RestaurantViewModel
}