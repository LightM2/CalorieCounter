package com.example.caloriecounter.feature.restaurant.di.meals

import androidx.lifecycle.SavedStateHandle
import com.example.caloriecounter.feature.restaurant.ui.meals.MealsViewModel
import com.example.domain.usecases.retrofit.GetMealListUseCase
import dagger.Module
import dagger.Provides

@Module
class MealsModule {

    @Provides
    @MealsScope
    fun provideViewModel(
        getMealListUseCase: GetMealListUseCase,
        savedHandle: SavedStateHandle
    ): MealsViewModel = MealsViewModel(getMealListUseCase, savedHandle)
}
