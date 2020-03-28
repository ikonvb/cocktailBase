package com.bulyginkonstantin.cocktailbase.viewmodel

import android.app.Application
import android.content.Context
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.bulyginkonstantin.cocktailbase.model.Cocktail
import com.bulyginkonstantin.cocktailbase.model.CocktailDatabase
import kotlinx.coroutines.launch

class DetailViewModel(application: Application) : BaseViewModel(application) {

    val cocktailLiveData = MutableLiveData<Cocktail>()

    fun fetchFromDatabase(uuid: Int) {
        launch {
            val cocktail = CocktailDatabase(getApplication()).getCocktailDao().getCocktailById(uuid)
            cocktailLiveData.value = cocktail
        }

    }
}