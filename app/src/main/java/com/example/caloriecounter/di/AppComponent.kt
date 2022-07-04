package com.example.caloriecounter.di

import com.example.caloriecounter.App
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjectionModule
import javax.inject.Singleton

@Singleton
@Component(modules = [AndroidInjectionModule::class, AppModule::class, NetworkModule::class])
interface AppComponent {
    fun inject(app: App)

    @Component.Factory
    interface Factory {
        fun create(@BindsInstance application: App): AppComponent
    }
}