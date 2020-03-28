package com.bulyginkonstantin.cocktailbase.viewmodel

import android.app.Application
import androidx.lifecycle.MutableLiveData
import com.bulyginkonstantin.cocktailbase.model.Cocktail
import com.bulyginkonstantin.cocktailbase.model.CocktailDatabase
import kotlinx.coroutines.launch

class DetailViewModel(application: Application) : BaseViewModel(application) {

    val detailCocktailLiveData = MutableLiveData<Cocktail>()

    fun fetchFromDatabase(uuid: Int) {
        launch {
            val cocktail = CocktailDatabase(getApplication()).getCocktailDao().getCocktailById(uuid)
            detailCocktailLiveData.value = cocktail
        }

    }
}