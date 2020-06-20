package com.bulyginkonstantin.cocktailbase.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView
import com.bulyginkonstantin.cocktailbase.R
import com.bulyginkonstantin.cocktailbase.databinding.DetailFavouriteCocktailInfoBinding
import com.bulyginkonstantin.cocktailbase.model.FavouriteCocktail
import com.bulyginkonstantin.cocktailbase.view.CocktailClickListener
import com.bulyginkonstantin.cocktailbase.view.FavouriteListFragmentDirections
import kotlinx.android.synthetic.main.detail_cocktail_info.view.*

class FavouriteCocktailListAdapter :
    RecyclerView.Adapter<FavouriteCocktailListAdapter.CocktailViewHolder>(), CocktailClickListener {

    private val favCocktailList = ArrayList<FavouriteCocktail>()

    fun updateCocktailListWithFav(newCocktailList: List<FavouriteCocktail>) {
        favCocktailList.clear()
        favCocktailList.addAll(newCocktailList)
        notifyDataSetChanged()
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CocktailViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val view = DataBindingUtil.inflate<DetailFavouriteCocktailInfoBinding>(
            inflater,
            R.layout.detail_favourite_cocktail_info,
            parent,
            false
        )
        return CocktailViewHolder(view)
    }

    override fun getItemCount() = favCocktailList.size

    override fun onBindViewHolder(holder: CocktailViewHolder, position: Int) {
        holder.view.favCocktail = favCocktailList[position]
        holder.view.listener = this
    }

    override fun onCocktailClicked(v: View) {
        val drinkId = v.cocktailId.text.toString().toInt()
        val action = FavouriteListFragmentDirections.actionFromFavouriteListFragmentToDetailInfoFragment()
        action.cocktailId = drinkId
        Navigation.findNavController(v).navigate(action)
    }

    class CocktailViewHolder(var view: DetailFavouriteCocktailInfoBinding) :
        RecyclerView.ViewHolder(view.root)
}