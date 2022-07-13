package com.example.caloriecounter.feature.diary

import com.example.caloriecounter.base.BaseEvent
import com.example.caloriecounter.base.BaseSideEffect
import com.example.caloriecounter.base.BaseState

class DiaryContract {

    sealed class Event : BaseEvent

    data class State(
        val isLoading: Boolean = false
    ) : BaseState

    sealed class Effect : BaseSideEffect
}
