package com.example.caloriecounter.feature.restaurant.ui.categories

import androidx.lifecycle.viewModelScope
import com.example.caloriecounter.base.BaseViewModel
import com.example.caloriecounter.base.DataState
import com.example.domain.handle
import com.example.domain.usecases.retrofit.GetCategoryListUseCase
import kotlinx.coroutines.launch
import javax.inject.Inject

class CategoriesViewModel @Inject constructor(
    val getCategoryListUseCase: GetCategoryListUseCase,
) : BaseViewModel<CategoriesContract.Event, CategoriesContract.State, CategoriesContract.Effect>() {

    init {
        getCategories()
    }

    private fun getCategories() {
        viewModelScope.launch {
            getCategoryListUseCase().handle(
                onSuccess = {
                    setState {
                        copy(
                            categories = DataState(
                                data = it,
                                isLoading = false,
                                errorMessage = null
                            )
                        )
                    }
                },
                onError = {
                    setState {
                        copy(
                            categories = DataState(
                                emptyList(),
                                isLoading = false,
                                errorMessage = it,
                            )
                        )
                    }
                }
            )
        }
    }

    override fun setInitialState(): CategoriesContract.State = CategoriesContract.State(
        categories = DataState(emptyList(), isLoading = true, errorMessage = null)
    )

    override fun handleEvents(event: CategoriesContract.Event) {
        when (event) {
            is CategoriesContract.Event.SelectedCategory -> {
                setEffect { CategoriesContract.Effect.Navigation.ToCategoryMeals(event.category) }
            }
            is CategoriesContract.Event.ReloadData -> {
                setInitialState()
                getCategories()
            }
        }
    }
}
