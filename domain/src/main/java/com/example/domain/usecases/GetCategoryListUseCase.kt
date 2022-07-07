package com.example.domain.usecases

import com.example.domain.Resource
import com.example.domain.models.Category
import com.example.domain.repositories.RetrofitRepo
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

class GetCategoryListUseCase @Inject constructor(private val retrofitRepo: RetrofitRepo) {

    suspend operator fun invoke(): Resource<List<Category>> =
        withContext(Dispatchers.IO) { retrofitRepo.getCategories() }

}
