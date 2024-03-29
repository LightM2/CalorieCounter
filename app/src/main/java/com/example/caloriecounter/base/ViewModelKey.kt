package com.example.caloriecounter.base

import androidx.lifecycle.ViewModel
import dagger.MapKey
import kotlin.reflect.KClass

@MapKey
internal annotation class ViewModelKey(val value: KClass<out ViewModel>)
