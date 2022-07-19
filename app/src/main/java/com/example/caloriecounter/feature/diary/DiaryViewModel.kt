package com.example.caloriecounter.feature.diary

import com.example.caloriecounter.base.BaseViewModel
import javax.inject.Inject

private const val TAG = "DiaryViewModel"

class DiaryViewModel @Inject constructor() :
    BaseViewModel<DiaryContract.Event, DiaryContract.State, DiaryContract.Effect>() {

    override fun setInitialState(): DiaryContract.State {
        return DiaryContract.State()
    }

    override fun handleEvents(event: DiaryContract.Event) {}
}
