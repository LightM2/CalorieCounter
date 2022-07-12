package com.example.caloriecounter.di

import dagger.Module
import dagger.Provides
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers

@Module
abstract class AppModule {

    companion object {
        @Provides
        fun appDispatcher(): CoroutineDispatcher = Dispatchers.IO
    }
}
