package com.example.domain.usecases.retrofit

import com.example.domain.Resource
import com.example.domain.annotation.IODispatcher
import com.example.domain.models.Category
import com.example.domain.repositories.RetrofitRepo
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.withContext
import javax.inject.Inject

class GetCategoryListUseCase @Inject constructor(
    val retrofitRepo: RetrofitRepo,
    @IODispatcher val ioDispatcher: CoroutineDispatcher
) {

    suspend operator fun invoke(): Resource<List<Category>> =
        withContext(ioDispatcher) { retrofitRepo.getCategories() }
}
