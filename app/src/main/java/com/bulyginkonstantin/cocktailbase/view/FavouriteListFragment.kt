package com.bulyginkonstantin.cocktailbase.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import com.bulyginkonstantin.cocktailbase.R
import com.bulyginkonstantin.cocktailbase.adapters.CocktailListAdapter
import com.bulyginkonstantin.cocktailbase.model.Cocktail
import com.bulyginkonstantin.cocktailbase.viewmodel.FavouriteViewModel
import kotlinx.android.synthetic.main.fragment_favourite_list.*

class FavouriteListFragment : Fragment() {

    private lateinit var viewModelResult: FavouriteViewModel
    private val cocktailListAdapter = CocktailListAdapter()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_favourite_list, container, false)
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModelResult = ViewModelProviders.of(this).get(FavouriteViewModel::class.java)
        viewModelResult.fetchFromDatabase()

        rvFavoriteCocktailsList.apply {
            layoutManager = LinearLayoutManager(context)
            adapter = cocktailListAdapter
        }
        observeViewModel()
    }

    private fun observeViewModel() {
        viewModelResult.favouriteCocktails.observe(viewLifecycleOwner, Observer {
            it?.let {
                rvFavoriteCocktailsList.visibility = View.VISIBLE
                cocktailListAdapter.updateCocktailListWithFav(it)
            }
        })

        viewModelResult.cocktailsLoadError.observe(viewLifecycleOwner, Observer {
            it?.let {
                errorListFavorite.visibility = if (it) View.VISIBLE else View.GONE
            }
        })

        viewModelResult.loading.observe(viewLifecycleOwner, Observer {
            it?.let {
                loadingProgressBarFavourite.visibility = if (it) View.VISIBLE else View.GONE
                if (it) {
                    errorListFavorite.visibility = View.GONE
                    rvFavoriteCocktailsList.visibility = View.GONE
                }
            }
        })
    }


}
