package com.example.caloriecounter.di

import android.content.Context
import androidx.room.Room
import com.example.data.repositories.RoomRepoImpl
import com.example.data.room.AppDatabase
import com.example.data.room.MealDao
import com.example.domain.repositories.RoomRepo
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class DbModel {
    @Provides
    @Singleton
    fun provideDatabase(context: Context): AppDatabase =
        Room.databaseBuilder(
            context.applicationContext,
            AppDatabase::class.java,
            "meals_db"
        ).build()

    @Provides
    @Singleton
    fun provideDao(appDatabase: AppDatabase): MealDao =
        appDatabase.mealDao()

    @Provides
    fun provideRoomRepo(roomRepoImpl: RoomRepoImpl): RoomRepo = roomRepoImpl

}