package com.example.caloriecounter.di

import android.content.Context
import com.example.caloriecounter.MainActivity
import com.example.caloriecounter.feature.diary.di.DiaryComponent
import com.example.caloriecounter.feature.profile.di.ProfileComponent
import com.example.caloriecounter.feature.restaurant.di.categories.CategoriesComponent
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
        DbModel::class,
    ]
)
interface ActivityComponent {
    val diaryComponentBuilder: DiaryComponent.Builder
    val profileComponentBuilder: ProfileComponent.Builder
    val restaurantCategoriesComponentBuilder: CategoriesComponent.Builder

    @get:IODispatcher
    val ioDispatcher: CoroutineDispatcher

    @Component.Builder
    interface Builder {

        @BindsInstance
        fun activity(activity: MainActivity): Builder

        @BindsInstance
        fun context(context: Context): Builder

        fun build(): ActivityComponent
    }
}
