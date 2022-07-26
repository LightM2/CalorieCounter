package com.example.caloriecounter.feature.restaurant.di.categories

import com.example.caloriecounter.feature.restaurant.di.RestaurantScope
import com.example.caloriecounter.feature.restaurant.ui.categories.CategoriesViewModel
import com.example.domain.usecases.retrofit.GetCategoryListUseCase
import dagger.Module
import dagger.Provides

@Module
class CategoriesModule {
    @Provides
    @RestaurantScope
    fun provideViewModel(getCategoryListUseCase: GetCategoryListUseCase): CategoriesViewModel =
        CategoriesViewModel(getCategoryListUseCase)
}
