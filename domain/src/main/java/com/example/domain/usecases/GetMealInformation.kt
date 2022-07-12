package com.example.domain.usecases

import com.example.domain.Resource
import com.example.domain.models.Meal
import com.example.domain.repositories.RetrofitRepo
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

class GetMealInformation @Inject constructor(val retrofitRepo: RetrofitRepo) {

    suspend operator fun invoke(id: String): Resource<Meal?> =
        withContext(Dispatchers.IO) { retrofitRepo.getMealInformation(id) }

}
