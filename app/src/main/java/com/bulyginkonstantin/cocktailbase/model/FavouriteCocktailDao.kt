package com.bulyginkonstantin.cocktailbase.model

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query

@Dao
interface FavouriteCocktailDao : BaseDao<FavouriteCocktail> {

    //methods for work with "favourite_cocktails" table
    @Insert
    suspend fun insertInFavourite(cocktail: FavouriteCocktail?)

    @Query("SELECT * FROM favourite_cocktails")
    suspend fun getAllCocktailsFromFavourite(): List<FavouriteCocktail>

    @Query("SELECT * FROM favourite_cocktails WHERE drink_id ==:cocktailId")
    suspend fun getFavouriteCocktailById(cocktailId: Int): FavouriteCocktail

    @Query("DELETE FROM favourite_cocktails")
    suspend fun deleteAllFavouriteCocktails()

    @Delete
    suspend fun deleteFavouriteCocktail(cocktail: FavouriteCocktail)
}