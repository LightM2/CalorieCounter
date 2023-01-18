package com.example.domain.models

data class Ingredient(private val _name: String?, private val _measure: String?) {
    val name: String
        get() = _name.orEmpty()

    val measure: String
        get() = _measure.orEmpty()
}
