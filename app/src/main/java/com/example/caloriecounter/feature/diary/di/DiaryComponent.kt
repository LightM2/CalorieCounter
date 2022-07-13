package com.example.caloriecounter.feature.diary.di

import com.example.caloriecounter.feature.diary.DiaryViewModel
import dagger.Subcomponent

@Subcomponent(modules = [DiaryModule::class])
@DiaryScope
interface DiaryComponent {
    @Subcomponent.Builder
    interface Builder {
        fun build(): DiaryComponent
    }

    fun getViewModel(): DiaryViewModel
}
