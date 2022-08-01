package com.example.caloriecounter.feature.restaurant.di.categories

import com.example.caloriecounter.feature.restaurant.ui.categories.CategoriesViewModel
import dagger.Subcomponent

@Subcomponent(modules = [CategoriesModule::class])
@CategoriesScope
interface CategoriesComponent {
    @Subcomponent.Builder
    interface Builder {
        fun build(): CategoriesComponent
    }

    fun getViewModel(): CategoriesViewModel
}
