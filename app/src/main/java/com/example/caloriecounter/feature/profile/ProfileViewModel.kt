package com.example.caloriecounter.feature.profile

import com.example.caloriecounter.base.BaseViewModel
import javax.inject.Inject

class ProfileViewModel @Inject constructor() :
    BaseViewModel<ProfileContract.Event, ProfileContract.State, ProfileContract.Effect>() {
    override fun setInitialState(): ProfileContract.State {
        return ProfileContract.State()
    }

    override fun handleEvents(event: ProfileContract.Event) {}
}
