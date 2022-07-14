package com.example.domain.usecases.retrofit

import com.example.domain.Resource
import com.example.domain.annotation.IODispatcher
import com.example.domain.models.Meal
import com.example.domain.repositories.RetrofitRepo
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.withContext
import javax.inject.Inject

class GetMealInformationUseCase @Inject constructor(
    val retrofitRepo: RetrofitRepo,
    @IODispatcher val ioDispatcher: CoroutineDispatcher
) {

    suspend operator fun invoke(id: String): Resource<Meal?> =
        withContext(ioDispatcher) { retrofitRepo.getMealInformation(id) }
}
