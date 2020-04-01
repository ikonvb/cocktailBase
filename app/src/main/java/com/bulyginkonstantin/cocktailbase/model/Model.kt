package com.bulyginkonstantin.cocktailbase.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName

@Entity
data class Cocktail(
    @PrimaryKey
    @ColumnInfo(name = "drink_id")
    @SerializedName("idDrink")
    var drink_id: String,

    @ColumnInfo(name = "drink_name")
    @SerializedName("strDrink")
    val drinkName: String?,

    @ColumnInfo(name = "drink_category")
    @SerializedName("strCategory")
    val category: String?,

    @ColumnInfo(name = "drink_alcoholic")
    @SerializedName("strAlcoholic")
    val isAlcoholic: String?,

    @ColumnInfo(name = "drink_glass")
    @SerializedName("strGlass")
    val glass: String?,

    @ColumnInfo(name = "drink_instructions")
    @SerializedName("strInstructions")
    val instructions: String?,

    @ColumnInfo(name = "drink_url")
    @SerializedName("strDrinkThumb")
    val imgUrl: String?,

    @ColumnInfo(name = "modified_date")
    @SerializedName("dateModified")
    val lastDateModified: String?

//    @SerializedName("strIngredient")
//    val ingredients: MutableList<String>
)

data class Drinks(
    @SerializedName("drinks")
    val drinkObjectOfArrays: List<Cocktail>
)

@Entity(tableName = "favourite_cocktails")
data class FavouriteCocktail(
    @PrimaryKey
    @ColumnInfo(name = "drink_id")
    @SerializedName("idDrink")
    val drink_id: String,

    @ColumnInfo(name = "drink_name")
    @SerializedName("strDrink")
    val drinkName: String?,

    @ColumnInfo(name = "drink_category")
    @SerializedName("strCategory")
    val category: String?,

    @ColumnInfo(name = "drink_alcoholic")
    @SerializedName("strAlcoholic")
    val isAlcoholic: String?,

    @ColumnInfo(name = "drink_glass")
    @SerializedName("strGlass")
    val glass: String?,

    @ColumnInfo(name = "drink_instructions")
    @SerializedName("strInstructions")
    val instructions: String?,

    @ColumnInfo(name = "drink_url")
    @SerializedName("strDrinkThumb")
    val imgUrl: String?,

    @ColumnInfo(name = "modified_date")
    @SerializedName("dateModified")
    val lastDateModified: String?

//    @SerializedName("strIngredient")
//    val ingredients: MutableList<String>
)