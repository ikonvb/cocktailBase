package com.bulyginkonstantin.cocktailbase.viewmodel

import android.app.Application
import android.widget.Toast
import androidx.lifecycle.MutableLiveData
import com.bulyginkonstantin.cocktailbase.model.*
import com.bulyginkonstantin.cocktailbase.util.SharedPreferencesHelper
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.observers.DisposableSingleObserver
import io.reactivex.schedulers.Schedulers
import kotlinx.coroutines.launch

class ResultListViewModel(application: Application) : BaseViewModel(application) {

    private var refreshTime = 5 * 60 * 1000 * 1000 * 1000L
    private var prefHelper = SharedPreferencesHelper(getApplication())
    private val cocktailService = CocktailApiService()
    private val disposable = CompositeDisposable()

    val cocktails = MutableLiveData<List<Cocktail>>()
    val cocktailsLoadError = MutableLiveData<Boolean>()
    val loading = MutableLiveData<Boolean>()

    fun refreshData() {
        val updateTime = prefHelper.getUpdateTime()
        if (updateTime != null && updateTime != 0L && System.nanoTime() - updateTime < refreshTime) {
            fetchFromDatabase()
        } else {
            fetchFromRemote()
        }
    }

    fun refreshByPassCache() {
        fetchFromRemote()
    }

    private fun fetchFromDatabase() {
        loading.value = true
        launch {
            val cocktails = CocktailDatabase(getApplication()).getCocktailDao().getAllCocktails()
            cocktailsRetrieved(cocktails)
            Toast.makeText(
                getApplication(),
                "Cocktails retrieved from database",
                Toast.LENGTH_SHORT
            ).show()
        }
    }

    private fun fetchFromRemote() {
        loading.value = true
        disposable.add(
            cocktailService.getCocktailsByName()
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeWith(object : DisposableSingleObserver<Drinks>() {

                    override fun onSuccess(cocktailsFromRemote: Drinks) {
                        val list = getCocktails(cocktailsFromRemote)
                        storeCocktailsLocally(list)
                        Toast.makeText(
                            getApplication(),
                            "Cocktails retrieved from Internet",
                            Toast.LENGTH_SHORT
                        ).show()
                    }

                    override fun onError(error: Throwable) {
                        cocktailsLoadError.value = true
                        loading.value = false
                    }
                })
        )
    }

    //get Cocktail objects from array named "drinks" in api
    private fun getCocktails(cocktailsFromRemote: Drinks): List<Cocktail> {
        val cocktailArrayList = arrayListOf<Cocktail>()
        for (cocktail in cocktailsFromRemote.drinkObjectOfArrays) {
            cocktailArrayList.add(cocktail)
        }
        return cocktailArrayList
    }

    //add cocktails to data base
    private fun storeCocktailsLocally(list: List<Cocktail>) {
        launch {
            val dao = CocktailDatabase(getApplication()).getCocktailDao()
            dao.deleteAllCocktails()
            dao.insertAll(list)
            cocktailsRetrieved(list)
        }
        prefHelper.saveUpdateTime(System.nanoTime())
    }

    //add cocktails to MutableLiveData and to recycler View
    private fun cocktailsRetrieved(list: List<Cocktail>) {
        cocktails.value = list
        cocktailsLoadError.value = false
        loading.value = false
    }

    override fun onCleared() {
        super.onCleared()
        disposable.clear()
    }
}