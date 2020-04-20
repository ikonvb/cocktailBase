package com.bulyginkonstantin.cocktailbase.view

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.bulyginkonstantin.cocktailbase.R
import com.bulyginkonstantin.cocktailbase.databinding.FragmentDetailInfoBinding
import com.bulyginkonstantin.cocktailbase.model.Cocktail
import com.bulyginkonstantin.cocktailbase.model.FavouriteCocktail
import com.bulyginkonstantin.cocktailbase.viewmodel.DetailViewModel
import kotlinx.android.synthetic.main.fragment_detail_info.*

/**
 * A simple [Fragment] subclass.
 */
class DetailInfoFragment : Fragment() {

    private lateinit var detailViewModel: DetailViewModel
    private var cocktailId = 0
    private lateinit var dataBinding: FragmentDetailInfoBinding
    private lateinit var plainCocktail: Cocktail
    private var favCocktail: FavouriteCocktail? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        dataBinding =
            DataBindingUtil.inflate(inflater, R.layout.fragment_detail_info, container, false)
        return dataBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        arguments?.let {
            cocktailId = DetailInfoFragmentArgs.fromBundle(it).cocktailId
        }
        viewModelInit()
        observePlainCocktail()
        observeFavouriteCocktail()

        buttonChangeFavourites.setOnClickListener {

            if (favCocktail == null) {
                favCocktail = FavouriteCocktail(plainCocktail)
                detailViewModel.insertFavCocktail(favCocktail!!)
                Toast.makeText(context, "added to favourite", Toast.LENGTH_SHORT).show()
                setFavourite()
            } else {
                detailViewModel.deleteFavCocktail(favCocktail!!)
                favCocktail = null
                setFavourite()
                Toast.makeText(context, "remove from favourite", Toast.LENGTH_SHORT).show()
            }
        }

    }

    private fun viewModelInit() {
        detailViewModel = ViewModelProvider(this).get(DetailViewModel::class.java)
        detailViewModel.getCocktailById(cocktailId)
        detailViewModel.getFavCocktailById(cocktailId)
    }

    private fun observePlainCocktail() {

        detailViewModel.cocktailFromDatabase.observe(viewLifecycleOwner, Observer {
            it?.let { _ ->
                dataBinding.cocktailDetail = it
                plainCocktail = it
            }
        })

    }

    private fun observeFavouriteCocktail() {
        detailViewModel.favCocktailFromDatabase.observe(viewLifecycleOwner, Observer {
            favCocktail = it
            setFavourite()
        })
    }


    private fun setFavourite() {
        Log.d("tag", "$favCocktail")
        if (favCocktail == null) {
            buttonChangeFavourites.text = getString(R.string.add_to_favourite)
        } else {
            buttonChangeFavourites.text = getString(R.string.remove_favourite)
        }
    }

}
