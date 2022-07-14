package com.example.domain.usecases.room

import com.example.domain.annotation.IODispatcher
import com.example.domain.models.Meal
import com.example.domain.repositories.RoomRepo
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.withContext
import javax.inject.Inject

class AddDailyMealUseCase @Inject constructor(
    private val roomRepo: RoomRepo,
    @IODispatcher val ioDispatcher: CoroutineDispatcher
) {
    suspend operator fun invoke(meal: Meal) {
        withContext(ioDispatcher) { roomRepo.addMeal(meal) }
    }
}
