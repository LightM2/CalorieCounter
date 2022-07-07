package com.example.data.models

import com.example.domain.models.Category
import com.google.gson.annotations.SerializedName

data class CategoryDetails(
    @SerializedName("idCategory")
    val id: String,
    @SerializedName("strCategory")
    val name: String,
    @SerializedName("strCategoryDescription")
    val description: String,
    @SerializedName("strCategoryThumb")
    val thumb: String
)

fun CategoryDetails.toCategory() = Category(id, name, description, thumb)