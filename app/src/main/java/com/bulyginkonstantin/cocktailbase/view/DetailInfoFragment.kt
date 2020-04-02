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
import androidx.lifecycle.ViewModelProviders
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

    private lateinit var viewModel: DetailViewModel
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
        viewModel = ViewModelProviders.of(this).get(DetailViewModel::class.java)
        viewModelInit()

        buttonChangeFavourites.setOnClickListener {
            if (favCocktail == null) {
                viewModel.insertFavCocktail(FavouriteCocktail(plainCocktail))
                viewModelInit()
                Log.d("tag", "$favCocktail")
                Toast.makeText(context, "added to favourite", Toast.LENGTH_SHORT).show()
            } else {
                viewModel.deleteFavCocktail(favCocktail!!)
                favCocktail = null
                Log.d("tag", "$favCocktail")
                Toast.makeText(context, "remove from favourite", Toast.LENGTH_SHORT).show()
            }
        }
    }

    private fun viewModelInit() {
        viewModel.fetchFromDatabaseById(cocktailId)
        viewModel.getFavCocktailById(cocktailId)
        observeViewModel()
    }

    private fun observeViewModel() {

        viewModel.cocktailFromDatabase.observe(viewLifecycleOwner, Observer {
            it?.let { _ ->
                dataBinding.cocktailDetail = it
                plainCocktail = it
            }
        })

        viewModel.favCocktailFromDatabase.observe(viewLifecycleOwner, Observer {
            it?.let {
                favCocktail = it
            }
        })

    }


}
