package com.example.caloriecounter.feature.diary

import com.example.caloriecounter.base.BaseViewModel

class DiaryViewModel:
    BaseViewModel<DiaryContract.Event, DiaryContract.State, DiaryContract.Effect>() {
    val TAG = "DiaryViewModel"

    override fun setInitialState(): DiaryContract.State {
        return DiaryContract.State()
    }

    override fun handleEvents(event: DiaryContract.Event) {

    }
}