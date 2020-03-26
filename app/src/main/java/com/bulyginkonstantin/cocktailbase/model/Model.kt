package com.bulyginkonstantin.cocktailbase.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName

@Entity
data class Cocktail(
    @ColumnInfo(name = "drink_id")
    @SerializedName("idDrink")
    val idDrink: String,

    @ColumnInfo(name = "drink_name")
    @SerializedName("strDrink")
    val drinkName: String,

    @ColumnInfo(name = "drink_category")
    @SerializedName("strCategory")
    val category: String,

    @ColumnInfo(name = "drink_alcoholic")
    @SerializedName("strAlcoholic")
    val isAlcoholic: String,

    @ColumnInfo(name = "drink_glass")
    @SerializedName("strGlass")
    val glass: String,

    @ColumnInfo(name = "drink_instructions")
    @SerializedName("strInstructions")
    val instructions: String,

    @ColumnInfo(name = "drink_url")
    @SerializedName("strDrinkThumb")
    val imgUrl: String,

    @ColumnInfo(name = "modified_date")
    @SerializedName("dateModified")
    val lastDateModified: String

//    @SerializedName("strIngredient")
//    val ingredients: MutableList<String>
) {
    @PrimaryKey(autoGenerate = true)
    var uuid: Int = 0
}

data class Drinks(
    @SerializedName("drinks")
    val drinkObjectOfArrays: List<Cocktail>
)