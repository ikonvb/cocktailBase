package com.bulyginkonstantin.cocktailbase.model

import io.reactivex.Single
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

class CocktailApiService {

    private val BASE_URL = "https://raw.githubusercontent.com"
    private val api = Retrofit.Builder()
        .baseUrl(BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
        .build()
        .create(CocktailApi::class.java)

    fun getCocktailsByLetter(): Single<List<Cocktail>> {
        return api.getCocktailsByLetter()
    }

    fun getCocktailsByName(): Single<List<Cocktail>> {
        return api.getCocktailsByName()
    }
}

// https://www.thecocktaildb.com/api/json/v1/1/search.php?f=a
// https://raw.githubusercontent.com/DevTides/DogsApi/master/dogs.json