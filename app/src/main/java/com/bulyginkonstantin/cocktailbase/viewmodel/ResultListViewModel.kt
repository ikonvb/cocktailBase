package com.bulyginkonstantin.cocktailbase.viewmodel

import android.util.Log
import android.widget.Toast
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.bulyginkonstantin.cocktailbase.model.Cocktail
import com.bulyginkonstantin.cocktailbase.model.CocktailApiService
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
            cocktailService.getCocktailsByLetter()
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeWith(object : DisposableSingleObserver<List<Cocktail>>() {

                    override fun onSuccess(cocktailsFromRemote: List<Cocktail>) {

                        for (i in cocktailsFromRemote) {
                            Log.d("tag", "${cocktailsFromRemote[0]}")
                        }
                        Log.d("tag", "${cocktailsFromRemote[0]}")
                        cocktails.value = cocktailsFromRemote
                        cocktailsLoadError.value = false
                        loading.value = false
                    }

                    override fun onError(error: Throwable) {
                        cocktailsLoadError.value = true
                        loading.value = false
                        Log.d("tag", "${error.printStackTrace()}")
                    }
                })
        )
    }

    override fun onCleared() {
        super.onCleared()
        disposable.clear()
    }
}