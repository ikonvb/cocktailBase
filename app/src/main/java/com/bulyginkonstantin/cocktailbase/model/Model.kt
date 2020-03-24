package com.bulyginkonstantin.cocktailbase.model

data class Cocktail(
    val idDrink: String,
    val strDrink: String,
    val strCategory: String,
    val strAlcoholic:String,
    val strGlass: String,
    val strInstructions: String,
    val strDrinkThumb: String,
    val strIngredient: MutableList<String>,
    val dateModified: String
)