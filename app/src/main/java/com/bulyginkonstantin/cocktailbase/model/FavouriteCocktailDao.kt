package com.bulyginkonstantin.cocktailbase.model

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query

@Dao
interface FavouriteCocktailDao : BaseDao<FavouriteCocktail> {

    //methods for work with "favourite_cocktails" table
    @Insert
    suspend fun insertInFavourite(vararg cocktails: FavouriteCocktail): List<Long>

    @Query("SELECT * FROM favourite_cocktails")
    suspend fun getAllCocktailsFromFavourite(): List<FavouriteCocktail>

    @Query("SELECT * FROM favourite_cocktails WHERE uuid=:cocktailId")
    suspend fun getFavouriteCocktailById(cocktailId: Int): FavouriteCocktail

    @Query("DELETE FROM favourite_cocktails")
    suspend fun deleteAllFavouriteCocktails()

    @Query("DELETE FROM favourite_cocktails WHERE uuid=:cocktailId")
    suspend fun deleteFavouriteCocktailsByIId(cocktailId: Int)
}