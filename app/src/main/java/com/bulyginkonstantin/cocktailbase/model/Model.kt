package com.bulyginkonstantin.cocktailbase.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.Ignore
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName

data class Drinks(@SerializedName("drinks") val drinkObjectOfArrays: List<InitCocktail>)


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
    val ingredient15: String?,

    var initIngredients: String = ""
) {

    fun getAllIngredients() {

        if (ingredient1 != null) {
            initIngredients = "$ingredient1\n"
        }

        if (ingredient2 != null) {
            initIngredients += "$ingredient2\n"
        }

        if (ingredient3 != null) {
            initIngredients += "$ingredient3\n"
        }

        if (ingredient4 != null) {
            initIngredients += "$ingredient4\n"
        }

        if (ingredient5 != null) {
            initIngredients += "$ingredient5\n"
        }

        if (ingredient6 != null) {
            initIngredients += "$ingredient6\n"
        }

        if (ingredient7 != null) {
            initIngredients += "$ingredient7\n"
        }

        if (ingredient8 != null) {
            initIngredients += "$ingredient8\n"
        }

        if (ingredient9 != null) {
            initIngredients += "$ingredient9\n"
        }

        if (ingredient10 != null) {
            initIngredients += "$ingredient10\n"
        }

        if (ingredient11 != null) {
            initIngredients += "$ingredient11\n"
        }

        if (ingredient12 != null) {
            initIngredients += "$ingredient12\n"
        }

        if (ingredient13 != null) {
            initIngredients += "$ingredient13\n"
        }

        if (ingredient14 != null) {
            initIngredients += "$ingredient14\n"
        }

        if (ingredient15 != null) {
            initIngredients += "$ingredient15\n"
        }
    }
}

@Entity
data class Cocktail(
    @PrimaryKey
    @ColumnInfo(name = "drink_id")
    var drink_id: String,

    @ColumnInfo(name = "drink_name")
    val drinkName: String?,

    @ColumnInfo(name = "drink_category")
    val category: String?,

    @ColumnInfo(name = "drink_alcoholic")
    val isAlcoholic: String?,

    @ColumnInfo(name = "drink_glass")
    val glass: String?,

    @ColumnInfo(name = "drink_instructions")
    val instructions: String?,

    @ColumnInfo(name = "drink_url")
    val imgUrl: String?,

    @ColumnInfo(name = "modified_date")
    val lastDateModified: String?,

    val ingredients: String?
)

@Entity(tableName = "favourite_cocktails")
data class FavouriteCocktail(
    @PrimaryKey
    @ColumnInfo(name = "drink_id")
    val drink_id: String,

    @ColumnInfo(name = "drink_name")
    val drinkName: String?,

    @ColumnInfo(name = "drink_category")
    val category: String?,

    @ColumnInfo(name = "drink_alcoholic")
    val isAlcoholic: String?,

    @ColumnInfo(name = "drink_glass")
    val glass: String?,

    @ColumnInfo(name = "drink_instructions")
    val instructions: String?,

    @ColumnInfo(name = "drink_url")
    val imgUrl: String?,

    @ColumnInfo(name = "modified_date")
    val lastDateModified: String?,

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