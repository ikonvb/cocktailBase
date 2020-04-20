package com.bulyginkonstantin.cocktailbase.viewmodel

import android.app.Application
import android.widget.Toast
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.bulyginkonstantin.cocktailbase.model.CocktailDatabase
import com.bulyginkonstantin.cocktailbase.model.FavouriteCocktail
import kotlinx.coroutines.launch

class FavouriteViewModel(application: Application) : BaseViewModel(application) {

    private val _favouriteCocktails = MutableLiveData<List<FavouriteCocktail>>()
    val favouriteCocktails: LiveData<List<FavouriteCocktail>>
        get() = _favouriteCocktails

    val cocktailsLoadError = MutableLiveData<Boolean>()
    val loading = MutableLiveData<Boolean>()
    private val dbFavCocktailDao =
        CocktailDatabase.invoke(getApplication()).getFavouriteCocktailDao()


    fun getFavouriteFromDatabase() {
        loading.value = true
        launch {
            val favCocktails = dbFavCocktailDao.getAllCocktailsFromFavourite()
            cocktailsRetrieved(favCocktails)
            Toast.makeText(
                getApplication(),
                "Cocktails retrieved from favourite database",
                Toast.LENGTH_SHORT
            ).show()
        }
    }

    private fun cocktailsRetrieved(list: List<FavouriteCocktail>) {
        _favouriteCocktails.value = list
        cocktailsLoadError.value = false
        loading.value = false
    }

}