package com.example.caloriecounter.feature.restaurant.di

import com.example.caloriecounter.feature.restaurant.RestaurantViewModel
import dagger.Module
import dagger.Provides

@Module
class RestaurantModule {

    @Provides
    @RestaurantScope
    fun provideViewModel(): RestaurantViewModel = RestaurantViewModel()
}