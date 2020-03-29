package com.bulyginkonstantin.cocktailbase.viewmodel

import android.app.Application
import androidx.lifecycle.MutableLiveData
import com.bulyginkonstantin.cocktailbase.model.Cocktail
import com.bulyginkonstantin.cocktailbase.model.CocktailDatabase
import kotlinx.coroutines.launch

class DetailViewModel(application: Application) : BaseViewModel(application) {

    val cocktailFromDatabase = MutableLiveData<Cocktail>()
    // var favouriteCocktailFromDatabase: FavouriteCocktail? = null


    fun fetchFromDatabaseById(uuid: Int) {
        launch {
            val cocktail = CocktailDatabase(getApplication()).getCocktailDao().getCocktailById(uuid)
            cocktailFromDatabase.value = cocktail
        }
    }

//    fun getFavouriteCocktailFromDatabase(uuid: Int): FavouriteCocktail? {
//        launch {
//            favouriteCocktailFromDatabase =
//                CocktailDatabase(getApplication()).getCocktailDao().getFavouriteCocktailById(uuid)
//        }
//        return if (favouriteCocktailFromDatabase != null) favouriteCocktailFromDatabase else null
//    }
//
//    fun insertFavouriteCocktail(cocktail: Cocktail?) {
//        launch {
//            if (cocktail != null) {
//                val dao = CocktailDatabase(getApplication()).getCocktailDao()
//                dao.insertInFavourite(cocktail)
//            }
//        }
//    }
//
//    fun deleteFavouriteCocktail(cocktailId: Int) {
//        launch {
//            CocktailDatabase(getApplication()).getCocktailDao()
//                .deleteFavouriteCocktailsByIId(cocktailId)
//        }
//    }

}