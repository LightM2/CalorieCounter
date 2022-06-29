package com.example.caloriecounter.feature.diary

import com.example.caloriecounter.base.BaseViewModel

class DiaryViewModel:
    BaseViewModel<DiaryContract.Event, DiaryContract.State, DiaryContract.Effect>() {

    override fun setInitialState(): DiaryContract.State {
        TODO("Not yet implemented")
    }

    override fun handleEvents(event: DiaryContract.Event) {
        TODO("Not yet implemented")
    }
}