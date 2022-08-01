package com.example.caloriecounter.feature.restaurant.di.meals

import com.example.caloriecounter.feature.restaurant.ui.meals.MealsViewModel
import dagger.Subcomponent

@Subcomponent(modules = [MealsModule::class])
@MealsScope
interface MealsComponent {
    @Subcomponent.Builder
    interface Builder {
        fun build(): MealsComponent
    }

    fun getViewModel(): MealsViewModel
}
