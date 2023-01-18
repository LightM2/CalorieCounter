package com.example.caloriecounter.feature.restaurant.di.meals

import androidx.lifecycle.ViewModel
import com.example.caloriecounter.base.ViewModelAssistedFactory
import com.example.caloriecounter.base.ViewModelKey
import com.example.caloriecounter.feature.restaurant.ui.meals.MealsViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
abstract class MealsModule {

    @Binds
    @MealsScope
    @IntoMap
    @ViewModelKey(MealsViewModel::class)
    abstract fun bindFactory(factory: MealsViewModel.Factory): ViewModelAssistedFactory<out ViewModel>

}
