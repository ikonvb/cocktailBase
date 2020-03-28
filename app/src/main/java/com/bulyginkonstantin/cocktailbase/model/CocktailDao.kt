package com.bulyginkonstantin.cocktailbase.model

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query

@Dao
interface CocktailDao {

    //methods for work with "cocktail" table
    @Insert
    suspend fun insertAll(vararg cocktails: Cocktail): List<Long>

    @Query("SELECT * FROM cocktail")
    suspend fun getAllCocktails(): List<Cocktail>

    @Query("SELECT * FROM cocktail WHERE uuid=:cocktailId")
    suspend fun getCocktailById(cocktailId: Int): Cocktail

    @Query("DELETE FROM cocktail")
    suspend fun deleteAllCocktails()
    //------------------------------------------------------------------------

    //methods for work with "favourite_cocktails" table
    @Insert
    suspend fun insertAllInFavourite(vararg cocktails: Cocktail): List<Long>

    @Query("SELECT * FROM favourite_cocktails")
    suspend fun getAllCocktailsFromFavourite(): List<FavouriteCocktail>

    @Query("SELECT * FROM favourite_cocktails WHERE uuid=:cocktailId")
    suspend fun getFavouriteCocktailById(cocktailId: Int): FavouriteCocktail

    @Query("DELETE FROM favourite_cocktails")
    suspend fun deleteAllFavouriteCocktails()

    @Query("DELETE FROM favourite_cocktails WHERE uuid=:cocktailId")
    suspend fun deleteFavouriteCocktailsByIId(cocktailId: Int)

}