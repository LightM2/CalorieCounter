package com.example.caloriecounter.di

import com.example.caloriecounter.MainActivity
import com.example.caloriecounter.feature.diary.di.DiaryComponent
import com.example.domain.annotation.IODispatcher
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjectionModule
import kotlinx.coroutines.CoroutineDispatcher
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

    @get:IODispatcher val ioDispatcher: CoroutineDispatcher

    @Component.Builder
    interface Builder {

        @BindsInstance
        fun activity(activity: MainActivity): Builder

        fun build(): ActivityComponent
    }
}
