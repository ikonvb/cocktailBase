package com.bulyginkonstantin.cocktailbase.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.bulyginkonstantin.cocktailbase.R
import com.bulyginkonstantin.cocktailbase.databinding.FragmentDetailInfoBinding
import com.bulyginkonstantin.cocktailbase.viewmodel.DetailViewModel
import kotlinx.android.synthetic.main.fragment_detail_info.*

/**
 * A simple [Fragment] subclass.
 */
class DetailInfoFragment : Fragment() {

    private lateinit var viewModel: DetailViewModel
    private var cocktailId = 0
    private lateinit var dataBinding: FragmentDetailInfoBinding

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
        viewModel.fetchFromDatabaseById(cocktailId)

        observeViewModel()

        buttonChangeFavourites.setOnClickListener {
//            val cocktail = viewModel.getFavouriteCocktailFromDatabase(cocktailId)
//            if (cocktail == null) {
//                viewModel.insertFavouriteCocktail(viewModel.cocktailFromDatabase.value)
//                Toast.makeText(context, "Cocktail added to favourite", Toast.LENGTH_SHORT).show()
//            } else {
//                viewModel.deleteFavouriteCocktail(cocktailId)
//                Toast.makeText(context, "Cocktail deleted from favourite", Toast.LENGTH_SHORT).show()
//            }
        }
    }

    private fun observeViewModel() {
        viewModel.cocktailFromDatabase.observe(viewLifecycleOwner, Observer {
            it?.let { _ ->
                dataBinding.cocktailDetail = it
            }
        })
    }
}
