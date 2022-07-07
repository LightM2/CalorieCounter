package com.example.domain.models

data class Meal(
    val id: String,
    val name: String,
    val thumb: String,
    val area: String,
    val category: String,
    val instructions: String,
    val ingredients: List<Ingredient>,
)
