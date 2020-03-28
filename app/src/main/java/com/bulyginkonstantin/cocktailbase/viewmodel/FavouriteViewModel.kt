package com.bulyginkonstantin.cocktailbase.viewmodel

import android.app.Application
import android.widget.Toast
import androidx.lifecycle.MutableLiveData
import com.bulyginkonstantin.cocktailbase.model.CocktailDatabase
import com.bulyginkonstantin.cocktailbase.model.FavouriteCocktail
import io.reactivex.disposables.CompositeDisposable
import kotlinx.coroutines.launch

class FavouriteViewModel(application: Application) : BaseViewModel(application) {

    private val disposable = CompositeDisposable()
    val favouriteCocktails = MutableLiveData<List<FavouriteCocktail>>()
    val cocktailsLoadError = MutableLiveData<Boolean>()
    val loading = MutableLiveData<Boolean>()


    fun fetchFromDatabase() {
        //loading.value = true
        launch {
            val cocktails = CocktailDatabase(getApplication()).getCocktailDao().getAllCocktailsFromFavourite()
            cocktailsRetrieved(cocktails)
            Toast.makeText(
                getApplication(),
                "Cocktails retrieved from database",
                Toast.LENGTH_SHORT
            ).show()
        }
    }

    private fun cocktailsRetrieved(list: List<FavouriteCocktail>) {
        favouriteCocktails.value = list
        cocktailsLoadError.value = false
        loading.value = false
    }

    override fun onCleared() {
        super.onCleared()
        disposable.clear()
    }
}