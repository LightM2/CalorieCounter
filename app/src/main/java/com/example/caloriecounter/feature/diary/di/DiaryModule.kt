package com.example.caloriecounter.feature.diary.di

import com.example.caloriecounter.feature.diary.DiaryViewModel
import com.example.domain.usecases.retrofit.GetCategoryListUseCase
import com.example.domain.usecases.room.AddDailyMealUseCase
import dagger.Module
import dagger.Provides

@Module
class DiaryModule {

    @Provides
    @DiaryScope
    fun provideViewModel(): DiaryViewModel = DiaryViewModel()
}
