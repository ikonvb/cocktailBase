package com.bulyginkonstantin.cocktailbase.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.bulyginkonstantin.cocktailbase.model.Cocktail

class DetailViewModel : ViewModel() {

    val cocktailLiveData = MutableLiveData<Cocktail>()

    fun fetchFromDatabase() {
        val cocktail1 = Cocktail("1", "Margarita", "Ordinary", "Alcoholic", "glass", "drink it", "sdsdsd", "20.02.20")
        cocktailLiveData.value = cocktail1
    }
}