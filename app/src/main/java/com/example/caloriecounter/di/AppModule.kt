package com.example.caloriecounter.di

import com.example.domain.annotation.IODispatcher
import dagger.Module
import dagger.Provides
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers

@Module
class AppModule {

    @get:[Provides IODispatcher]
    val ioDispatcher: CoroutineDispatcher = Dispatchers.IO
}
