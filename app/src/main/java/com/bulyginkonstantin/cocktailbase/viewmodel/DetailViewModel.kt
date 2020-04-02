package com.bulyginkonstantin.cocktailbase.viewmodel

import android.app.Application
import androidx.lifecycle.MutableLiveData
import com.bulyginkonstantin.cocktailbase.model.Cocktail
import com.bulyginkonstantin.cocktailbase.model.CocktailDatabase
import com.bulyginkonstantin.cocktailbase.model.FavouriteCocktail
import kotlinx.coroutines.launch

class DetailViewModel(application: Application) : BaseViewModel(application) {

    val cocktailFromDatabase = MutableLiveData<Cocktail>()
    val favCocktailFromDatabase = MutableLiveData<FavouriteCocktail>()
    private val dbFavCocktail = CocktailDatabase.invoke(getApplication()).getFavouriteCocktailDao()


    fun fetchFromDatabaseById(drinkId: Int) {
        launch {
            val cocktail = CocktailDatabase(getApplication()).getCocktailDao().getCocktailById(drinkId)
            cocktailFromDatabase.value = cocktail
        }
    }

    fun getFavCocktailById(drinkId: Int) {
        launch {
            val favCocktail = dbFavCocktail.getFavouriteCocktailById(drinkId)
            favCocktailFromDatabase.value = favCocktail
        }
    }

    fun insertFavCocktail(cocktail: FavouriteCocktail) {
        launch {
            dbFavCocktail.insertInFavourite(cocktail)
        }
    }

    fun deleteFavCocktail(cocktail: FavouriteCocktail) {
        launch {
            dbFavCocktail.deleteFavouriteCocktail(cocktail)
        }
    }
}