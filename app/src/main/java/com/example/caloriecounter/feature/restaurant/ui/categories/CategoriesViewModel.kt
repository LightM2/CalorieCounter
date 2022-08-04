package com.example.caloriecounter.feature.restaurant.ui.categories

import androidx.lifecycle.viewModelScope
import com.example.caloriecounter.base.BaseViewModel
import com.example.domain.handle
import com.example.domain.usecases.retrofit.GetCategoryListUseCase
import kotlinx.coroutines.launch
import javax.inject.Inject

class CategoriesViewModel @Inject constructor(
    val getCategoryListUseCase: GetCategoryListUseCase,
) : BaseViewModel<CategoriesEvent, CategoriesState, CategoriesEffect>() {

    init {
        getCategories()
    }

    private fun getCategories() {
        viewModelScope.launch {
            getCategoryListUseCase().handle(
                onSuccess = { categories ->
                    setState {
                        CategoriesState.Success(categories)
                    }
                },
                onError = { message ->
                    setState {
                        CategoriesState.Error(message)
                    }
                }
            )
        }
    }

    override fun setInitialState(): CategoriesState = CategoriesState.Loading

    override fun handleEvents(event: CategoriesEvent) {
        when (event) {
            is CategoriesEvent.SelectedCategory -> {
                setEffect { CategoriesEffect.Navigation.ToCategoryMeals(event.category) }
            }
            is CategoriesEvent.ReloadData -> {
                setInitialState()
                getCategories()
            }
        }
    }
}
