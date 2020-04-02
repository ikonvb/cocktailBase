package com.bulyginkonstantin.cocktailbase.model

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface CocktailDao {

    //methods for work with "cocktail" table
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAll(cocktails: List<Cocktail>)

    @Query("SELECT * FROM cocktail")
    suspend fun getAllCocktails(): List<Cocktail>

    @Query("SELECT * FROM cocktail WHERE drink_id ==:cocktailId")
    suspend fun getCocktailById(cocktailId: Int): Cocktail

    @Query("DELETE FROM cocktail")
    suspend fun deleteAllCocktails()
}