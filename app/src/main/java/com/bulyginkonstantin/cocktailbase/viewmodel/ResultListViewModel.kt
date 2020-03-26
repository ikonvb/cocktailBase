package com.bulyginkonstantin.cocktailbase.viewmodel

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.bulyginkonstantin.cocktailbase.model.Cocktail
import com.bulyginkonstantin.cocktailbase.model.CocktailApiService
import com.bulyginkonstantin.cocktailbase.model.Drinks
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.observers.DisposableSingleObserver
import io.reactivex.schedulers.Schedulers

class ResultListViewModel : ViewModel() {

    private val cocktailService = CocktailApiService()
    private val disposable = CompositeDisposable()

    val cocktails = MutableLiveData<List<Cocktail>>()
    val cocktailsLoadError = MutableLiveData<Boolean>()
    val loading = MutableLiveData<Boolean>()

    fun refreshData() {
        fetchFromRemote()
    }

    private fun fetchFromRemote() {
        loading.value = true
        disposable.add(
            cocktailService.getCocktailsByName()
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeWith(object : DisposableSingleObserver<Drinks>() {

                    override fun onSuccess(cocktailsFromRemote: Drinks) {
                        val cocktailArrayList = arrayListOf<Cocktail>()
                        for (cocktail in cocktailsFromRemote.drinkObjectOfArrays) {
                            cocktailArrayList.add(cocktail)
                        }
                        cocktails.value = cocktailArrayList
                        cocktailsLoadError.value = false
                        loading.value = false
                    }

                    override fun onError(error: Throwable) {
                        cocktailsLoadError.value = true
                        loading.value = false
                    }
                })
        )
    }

    override fun onCleared() {
        super.onCleared()
        disposable.clear()
    }
}