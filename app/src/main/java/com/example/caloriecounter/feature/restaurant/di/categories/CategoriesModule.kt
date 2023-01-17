package com.example.caloriecounter.feature.restaurant.di.categories

import androidx.lifecycle.ViewModel
import com.example.caloriecounter.base.ViewModelAssistedFactory
import com.example.caloriecounter.base.ViewModelKey
import com.example.caloriecounter.feature.restaurant.ui.categories.CategoriesViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
abstract class CategoriesModule {

    @Binds
    @CategoriesScope
    @IntoMap
    @ViewModelKey(CategoriesViewModel::class)
    abstract fun bindViewModel(categoriesViewModel: CategoriesViewModel): ViewModel

}
