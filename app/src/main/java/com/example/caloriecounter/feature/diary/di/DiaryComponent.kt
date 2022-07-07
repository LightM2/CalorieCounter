package com.example.caloriecounter.feature.diary.di

import com.example.caloriecounter.di.AppModule
import com.example.caloriecounter.di.NetworkModule
import com.example.caloriecounter.feature.diary.DiaryViewModel
import dagger.Component

@Component(
    modules = [DiaryModule::class, NetworkModule::class]
)
@DiaryScope
interface DiaryComponent {
    @Component.Builder
    interface Builder {
        fun build(): DiaryComponent
    }

    fun getViewModel() : DiaryViewModel
}