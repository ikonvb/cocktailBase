package com.bulyginkonstantin.cocktailbase.model

import com.google.gson.annotations.SerializedName

data class Cocktail(
    @SerializedName("idDrink")
    val idDrink: String,

    @SerializedName("strDrink")
    val drinkName: String,

    @SerializedName("strCategory")
    val category: String,

    @SerializedName("strAlcoholic")
    val isAlcoholic:String,

    @SerializedName("strGlass")
    val glass: String,

    @SerializedName("strInstructions")
    val instructions: String,

    @SerializedName("strDrinkThumb")
    val imgUrl: String

//    @SerializedName("strIngredient")
//    val ingredients: MutableList<String>,

//    @SerializedName("dateModified")
//    val lastDateModified: String
)

data class Drinks(
    @SerializedName("drinks")
    val drinkObjectOfArrays: List<Cocktail>
)