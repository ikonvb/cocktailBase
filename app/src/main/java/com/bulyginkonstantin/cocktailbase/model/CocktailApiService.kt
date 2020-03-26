package com.bulyginkonstantin.cocktailbase.model

import io.reactivex.Single
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

class CocktailApiService {

    private val BASE_URL = "https://www.thecocktaildb.com/"
    private val api = Retrofit.Builder()
        .baseUrl(BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
        .build()
        .create(CocktailApi::class.java)


    fun getCocktailsByLetter(): Single<Drinks> {
        return api.getCocktailsByLetter()
    }

    fun getCocktailsByName(): Single<Drinks> {
        return api.getCocktailsByName()
    }
}