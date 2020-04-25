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

    @SerializedName("strMeasure1")
    val measure1: String?,

    @SerializedName("strMeasure2")
    val measure2: String?,

    @SerializedName("strMeasure3")
    val measure3: String?,

    @SerializedName("strMeasure4")
    val measure4: String?,

    @SerializedName("strMeasure5")
    val measure5: String?,

    @SerializedName("strMeasure6")
    val measure6: String?,

    @SerializedName("strMeasure7")
    val measure7: String?,

    @SerializedName("strMeasure8")
    val measure8: String?,

    @SerializedName("strMeasure9")
    val measure9: String?,

    @SerializedName("strMeasure10")
    val measure10: String?,

    @SerializedName("strMeasure11")
    val measure11: String?,

    @SerializedName("strMeasure12")
    val measure12: String?,

    @SerializedName("strMeasure13")
    val measure13: String?,

    @SerializedName("strMeasure14")
    val measure14: String?,

    @SerializedName("strMeasure15")
    val measure15: String?,

    var allMeasure: String = "",

    var initIngredients: String = ""
) {

    fun getAllMeasures() {

        val result = arrayListOf<String>()
        var i = 1
        if (measure1 != null) {
            result.add(measure1)
        }

        if (measure2 != null) {
            result.add(measure2)
        }

        if (measure3 != null) {
            result.add(measure3)
        }

        if (measure4 != null) {
            result.add(measure4)
        }

        if (measure5 != null) {
            result.add(measure5)
        }

        if (measure6 != null) {
            result.add(measure6)
        }

        if (measure7 != null) {
            result.add(measure7)
        }

        if (measure8 != null) {
            result.add(measure8)
        }

        if (measure9 != null) {
            result.add(measure9)
        }

        if (measure10 != null) {
            result.add(measure10)
        }

        if (measure11 != null) {
            result.add(measure11)
        }

        if (measure12 != null) {
            result.add(measure12)
        }

        if (measure13 != null) {
            result.add(measure13)
        }

        if (measure14 != null) {
            result.add(measure14)
        }

        if (measure15 != null) {
            result.add(measure15)
        }

        for (measure in result) {
            if (allMeasure.isNullOrEmpty()) {
                allMeasure = "$i. $measure \n"
                i++
            } else {
                allMeasure += "$i. $measure \n"
                i++
            }
        }
    }

    fun getAllIngredients() {
        val result = arrayListOf<String>()
        var i = 1
        if (ingredient1 != null) {
            result.add(ingredient1)
        }
        if (ingredient2 != null) {
            result.add(ingredient2)
        }
        if (ingredient3 != null) {
            result.add(ingredient3)
        }
        if (ingredient4 != null) {
            result.add(ingredient4)
        }
        if (ingredient5 != null) {
            result.add(ingredient5)
        }
        if (ingredient6 != null) {
            result.add(ingredient6)
        }
        if (ingredient7 != null) {
            result.add(ingredient7)
        }
        if (ingredient8 != null) {
            result.add(ingredient8)
        }
        if (ingredient9 != null) {
            result.add(ingredient9)
        }
        if (ingredient10 != null) {
            result.add(ingredient10)
        }
        if (ingredient11 != null) {
            result.add(ingredient11)
        }
        if (ingredient12 != null) {
            result.add(ingredient12)
        }
        if (ingredient13 != null) {
            result.add(ingredient13)
        }
        if (ingredient14 != null) {
            result.add(ingredient14)
        }
        if (ingredient15 != null) {
            result.add(ingredient15)
        }

        for (ingredient in result) {
            if (initIngredients.isNullOrEmpty()) {
                initIngredients = "$i. $ingredient \n"
                i++
            } else {
                initIngredients += "$i. $ingredient \n"
                i++
            }
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

    val allIngredients: String?,

    val allMeasure: String?
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

    val allIngredients: String?,

    val allMeasure: String?

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
        cocktail.allIngredients,
        cocktail.allMeasure
    )
}