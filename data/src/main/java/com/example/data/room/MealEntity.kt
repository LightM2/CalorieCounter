package com.example.data.room

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.domain.models.Meal

@Entity(tableName = "MealEntity")
data class MealEntity(
    @PrimaryKey
    val id: String,
    @ColumnInfo(name = "name")
    val name: String,
    @ColumnInfo(name = "thumb")
    val thumb: String,
    @ColumnInfo(name = "area")
    val area: String,
    @ColumnInfo(name = "category")
    val category: String,
)

fun MealEntity.toMeal() = Meal(
    id,
    name,
    thumb,
    area,
    category,
    instructions = "",
    ingredients = listOf(),
)

fun Meal.toMealEntity() = MealEntity(id, name, thumb, area, category)
