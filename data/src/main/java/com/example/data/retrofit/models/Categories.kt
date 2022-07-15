package com.example.data.retrofit.models

import com.example.domain.models.Category
import com.google.gson.annotations.SerializedName

data class Categories(
    @SerializedName("categories")
    val data: List<CategoryDetails>
)

fun Categories.toListOfCategory(): List<Category> = data.map { it.toCategory() }
