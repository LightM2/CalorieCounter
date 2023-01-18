package com.example.caloriecounter.base

import androidx.compose.runtime.Composable
import androidx.lifecycle.AbstractSavedStateViewModelFactory
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelStoreOwner
import androidx.lifecycle.viewmodel.compose.viewModel

@Composable
inline fun <reified T : ViewModel> daggerViewModel(
    key: String? = null,
    crossinline viewModelInstanceCreator: () -> T
): T = viewModel(
    modelClass = T::class.java,
    key = key,
    factory = object : ViewModelProvider.Factory {
        override fun <T : ViewModel> create(modelClass: Class<T>): T {
            return viewModelInstanceCreator() as T
        }
    }
)

@Composable
inline fun <reified T : ViewModel> daggerViewModel(
    key: String? = null,
    viewModelFactory: ViewModelAssistedFactory<T>,
    owner: ViewModelStoreOwner,
): T = viewModel(
    viewModelStoreOwner = owner,
    key = key,
    factory = object : AbstractSavedStateViewModelFactory(){
        @Suppress("UNCHECKED_CAST")
        override fun <T : ViewModel?> create(
            key: String,
            modelClass: Class<T>,
            handle: SavedStateHandle
        ): T {
            return viewModelFactory.create(handle) as T
        }
    }
)
