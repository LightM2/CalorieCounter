package com.example.caloriecounter.feature.diary

import android.util.Log
import androidx.lifecycle.viewModelScope
import com.example.caloriecounter.base.BaseViewModel
import com.example.domain.handle
import com.example.domain.models.Meal
import com.example.domain.usecases.retrofit.GetCategoryListUseCase
import com.example.domain.usecases.room.AddDailyMealUseCase
import kotlinx.coroutines.launch
import javax.inject.Inject

private const val TAG = "DiaryViewModel"

class DiaryViewModel @Inject constructor(
    private val getCategoryListUseCase: GetCategoryListUseCase,
    private val addDailyMealUseCase: AddDailyMealUseCase,
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

        addMealToDB()
    }

    private fun addMealToDB() {
        val meal = Meal(
            "1",
            "meal",
            "url",
            "area",
            "category",
            "instruction",
            listOf()
        )
        viewModelScope.launch {
            addDailyMealUseCase(meal)
        }
    }

    override fun setInitialState(): DiaryContract.State {
        return DiaryContract.State()
    }

    override fun handleEvents(event: DiaryContract.Event) {
    }
}
