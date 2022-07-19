package com.example.caloriecounter.feature.profile.di

import com.example.caloriecounter.feature.profile.ProfileViewModel
import dagger.Subcomponent

@Subcomponent(modules = [ProfileModule::class])
@ProfileScope
interface ProfileComponent {
    @Subcomponent.Builder
    interface Builder {
        fun build(): ProfileComponent
    }

    fun getViewModel(): ProfileViewModel
}