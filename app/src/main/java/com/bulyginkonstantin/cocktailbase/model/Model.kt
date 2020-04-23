package com.bulyginkonstantin.cocktailbase.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.Ignore
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName

data class Drinks(@SerializedName("drinks") val drinkObjectOfArrays: List<Cocktail>)



data class InitCocktail(

    @SerializedName("idDrink")
    var drink_id: String,

    @SerializedName("strDrink")
    val drinkName: String?,

    @SerializedName("strCategory")
    val category: String?,

    @SerializedName("strAlcoholic")
    val isAlcoholic: String?,

    @SerializedName("strGlass")
    val glass: String?,

    @SerializedName("strInstructions")
    val instructions: String?,

    @SerializedName("strDrinkThumb")
    val imgUrl: String?,

    @SerializedName("dateModified")
    val lastDateModified: String?,

    @SerializedName("strIngredient1")
    val ingredient1: String?,

    @SerializedName("strIngredient2")
    val ingredient2: String?,

    @SerializedName("strIngredient3")
    val ingredient3: String?,

    @SerializedName("strIngredient4")
    val ingredient4: String?,

    @SerializedName("strIngredient5")
    val ingredient5: String?,

    @SerializedName("strIngredient6")
    val ingredient6: String?,

    @SerializedName("strIngredient7")
    val ingredient7: String?,

    @SerializedName("strIngredient8")
    val ingredient8: String?,

    @SerializedName("strIngredient9")
    val ingredient9: String?,

    @SerializedName("strIngredient10")
    val ingredient10: String?,

    @SerializedName("strIngredient11")
    val ingredient11: String?,

    @SerializedName("strIngredient12")
    val ingredient12: String?,

    @SerializedName("strIngredient13")
    val ingredient13: String?,

    @SerializedName("strIngredient14")
    val ingredient14: String?,

    @SerializedName("strIngredient15")
    val ingredient15: String?
)

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
    val lastDateModified: String?,

    @SerializedName("strIngredient1")
    val ingredients: String?
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
    val lastDateModified: String?,

    @SerializedName("strIngredient1")
    val ingredient1: String?

) {
    @Ignore
    constructor(cocktail: Cocktail) : this(
        cocktail.drink_id,
        cocktail.drinkName,
        cocktail.category,
        cocktail.isAlcoholic,
        cocktail.glass,
        cocktail.instructions,
        cocktail.imgUrl,
        cocktail.lastDateModified,
        cocktail.ingredients
    )
}