package com.example.caloriecounter.feature.profile.di

import com.example.caloriecounter.feature.profile.ProfileViewModel
import dagger.Module
import dagger.Provides

@Module
class ProfileModule {

    @Provides
    @ProfileScope
    fun provideViewModel(): ProfileViewModel = ProfileViewModel()
}