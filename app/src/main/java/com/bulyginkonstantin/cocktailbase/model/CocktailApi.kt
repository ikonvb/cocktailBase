package com.bulyginkonstantin.cocktailbase.model

import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Query

interface CocktailApi {

    //endpoint to search by name
//    @GET("api/json/v1/1/search.php?s=margarita")
//    fun getCocktailsByName(): Single<Drinks>

    @GET("api/json/v1/1/search.php")
    fun getCocktailsByName(@Query("s") name: String): Single<Drinks>

    //endpoint to search by letter
    @GET("api/json/v1/1/search.php?f=a")
    fun getCocktailsByLetter(): Single<Drinks>

    //endpoint to Search random cocktail
    @GET("api/json/v1/1/random.php")
    fun getRandomCocktail(): Single<Drinks>

    //endpoint to Search cocktail by ingredient
    @GET("api/json/v1/1/filter.php?i=Gin")
    fun getCocktailByIngredient(): Single<Drinks>
}