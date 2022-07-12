package com.example.caloriecounter.di

import com.example.caloriecounter.MainActivity
import com.example.caloriecounter.feature.diary.di.DiaryComponent
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjectionModule
import javax.inject.Singleton

@Singleton
@Component(
    modules = [
        AndroidInjectionModule::class,
        AppModule::class,
        NetworkModule::class,
    ]
)
interface ActivityComponent {
    val diaryComponentBuilder: DiaryComponent.Builder

    @Component.Builder
    interface Builder {

        @BindsInstance
        fun activity(activity: MainActivity): Builder

        fun build(): ActivityComponent
    }
}