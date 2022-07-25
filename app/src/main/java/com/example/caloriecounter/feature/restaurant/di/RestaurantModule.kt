package com.example.caloriecounter.feature.restaurant.di

import com.example.caloriecounter.feature.restaurant.RestaurantViewModel
import com.example.domain.usecases.retrofit.GetCategoryListUseCase
import dagger.Module
import dagger.Provides

@Module
class RestaurantModule {

    @Provides
    @RestaurantScope
    fun provideViewModel(getCategoryListUseCase: GetCategoryListUseCase): RestaurantViewModel =
        RestaurantViewModel(getCategoryListUseCase)
}