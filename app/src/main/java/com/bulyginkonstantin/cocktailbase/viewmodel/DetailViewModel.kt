package com.bulyginkonstantin.cocktailbase.viewmodel

import android.app.Application
import androidx.lifecycle.MutableLiveData
import com.bulyginkonstantin.cocktailbase.model.Cocktail
import com.bulyginkonstantin.cocktailbase.model.CocktailDatabase
import kotlinx.coroutines.launch

class DetailViewModel(application: Application) : BaseViewModel(application) {

    val cocktailFromDatabase = MutableLiveData<Cocktail>()
    val dbCocktail = CocktailDatabase.invoke(getApplication()).getCocktailDao()
    val dbFavCocktail = CocktailDatabase.invoke(getApplication()).getFavouriteCocktailDao()


    fun fetchFromDatabaseById(uuid: Int) {
        launch {
            val cocktail = CocktailDatabase(getApplication()).getCocktailDao().getCocktailById(uuid)
            cocktailFromDatabase.value = cocktail
        }
    }
}