package com.example.caloriecounter.feature.diary

import android.util.Log
import androidx.lifecycle.viewModelScope
import com.example.caloriecounter.base.BaseViewModel
import com.example.domain.handle
import com.example.domain.usecases.retrofit.GetCategoryListUseCase
import kotlinx.coroutines.launch
import javax.inject.Inject

private const val TAG = "DiaryViewModel"

class DiaryViewModel @Inject constructor(
    private val getCategoryListUseCase: GetCategoryListUseCase,
) : BaseViewModel<DiaryContract.Event, DiaryContract.State, DiaryContract.Effect>() {

    init {
        viewModelScope.launch {
            getCategoryListUseCase().handle(
                onSuccess = {
                    Log.d(TAG, "categories - $it")
                },
                onError = {
                    Log.e(TAG, "error - $it")
                }
            )
        }
    }

    override fun setInitialState(): DiaryContract.State {
        return DiaryContract.State()
    }

    override fun handleEvents(event: DiaryContract.Event) {
    }
}
