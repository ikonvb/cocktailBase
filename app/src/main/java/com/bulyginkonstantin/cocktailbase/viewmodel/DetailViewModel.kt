package com.bulyginkonstantin.cocktailbase.viewmodel

import android.app.Application
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.bulyginkonstantin.cocktailbase.model.Cocktail
import com.bulyginkonstantin.cocktailbase.model.CocktailDatabase
import com.bulyginkonstantin.cocktailbase.model.FavouriteCocktail
import kotlinx.coroutines.launch

class DetailViewModel(application: Application) : BaseViewModel(application) {

    private val _cocktailFromDatabase = MutableLiveData<Cocktail>()
    val cocktailFromDatabase: LiveData<Cocktail>
        get() = _cocktailFromDatabase

    private val _favCocktailFromDatabase = MutableLiveData<FavouriteCocktail>()
    val favCocktailFromDatabase: LiveData<FavouriteCocktail>
        get() = _favCocktailFromDatabase

    private val dbFavCocktailDao = CocktailDatabase.invoke(getApplication()).getFavouriteCocktailDao()
    private val dbCocktailDao = CocktailDatabase.invoke(getApplication()).getCocktailDao()

    fun getCocktailById(drinkId: Int) {
        launch {
            _cocktailFromDatabase.value = dbCocktailDao.getCocktailById(drinkId)
        }
    }

    fun getFavCocktailById(drinkId: Int) {
        launch {
            _favCocktailFromDatabase.value = dbFavCocktailDao.getFavouriteCocktailById(drinkId)
        }
    }

    fun insertFavCocktail(cocktail: FavouriteCocktail) {
        launch {
            dbFavCocktailDao.insertInFavourite(cocktail)
        }
    }

    fun deleteFavCocktail(cocktail: FavouriteCocktail) {
        launch {
            dbFavCocktailDao.deleteFavouriteCocktail(cocktail)
        }
    }
}