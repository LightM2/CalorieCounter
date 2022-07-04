package com.example.caloriecounter.di

import android.app.Application
import com.example.caloriecounter.App
import dagger.Binds
import dagger.Module
import dagger.Provides
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers

@Module
abstract class AppModule {

    @Binds
    abstract fun application(app: App): Application

    companion object {
        @Provides
        fun appDispatcher(): CoroutineDispatcher = Dispatchers.IO
    }
}