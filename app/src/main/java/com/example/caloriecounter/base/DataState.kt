package com.example.caloriecounter.base

data class DataState<out A>(
    val data: A,
    val isLoading: Boolean
)
