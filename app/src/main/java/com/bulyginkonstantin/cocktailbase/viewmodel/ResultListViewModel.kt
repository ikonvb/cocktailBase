package com.bulyginkonstantin.cocktailbase.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.bulyginkonstantin.cocktailbase.model.Cocktail

class ResultListViewModel : ViewModel() {

    val cocktails = MutableLiveData<List<Cocktail>>()
    val cocktailsLoadError = MutableLiveData<Boolean>()
    val loading = MutableLiveData<Boolean>()

    fun refreshInfo() {
        val cocktail1 = Cocktail("1", "Margarita", "Ordinary", "Alcoholic", "glass", "drink it", "sdsdsd", "20.02.20")
        val cocktail2 = Cocktail("2", "Margarita Lollipop", "Ordinary", "Alcoholic", "glass", "drink it", "sdsdsd", "01.02.20")
        val cocktail3 = Cocktail("3", "Margarita Aloha", "Ordinary", "Alcoholic", "glass", "drink it", "sdsdsd", "13.02.20")
        val cocktailList = arrayListOf<Cocktail>(cocktail1, cocktail2, cocktail3)
        cocktails.value = cocktailList
        cocktailsLoadError.value = false
        loading.value = false
    }
}