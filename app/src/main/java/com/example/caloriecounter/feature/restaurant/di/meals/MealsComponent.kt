package com.example.caloriecounter.feature.restaurant.di.meals

import androidx.lifecycle.SavedStateHandle
import androidx.navigation.NavBackStackEntry
import com.example.caloriecounter.feature.restaurant.ui.meals.MealsViewModel
import dagger.BindsInstance
import dagger.Subcomponent

@Subcomponent(modules = [MealsModule::class])
@MealsScope
interface MealsComponent {
    @Subcomponent.Builder
    interface Builder {
        @BindsInstance
        fun navBackStackEntry(entry: NavBackStackEntry): Builder

        fun build(): MealsComponent
    }

    fun getViewModel(): MealsViewModel
}
