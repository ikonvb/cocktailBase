package com.bulyginkonstantin.cocktailbase.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView
import com.bulyginkonstantin.cocktailbase.R
import com.bulyginkonstantin.cocktailbase.model.Cocktail
import com.bulyginkonstantin.cocktailbase.util.getProgressDrawable
import com.bulyginkonstantin.cocktailbase.util.loadImage
import com.bulyginkonstantin.cocktailbase.view.ResultAllListFragmentDirections
import kotlinx.android.synthetic.main.detail_cocktail_info.view.*

class CocktailListAdapter(private val cocktailList: ArrayList<Cocktail>) :
    RecyclerView.Adapter<CocktailListAdapter.CocktailViewHolder>() {

    fun updateCocktailList(newCocktailList: List<Cocktail>) {
        cocktailList.clear()
        cocktailList.addAll(newCocktailList)
        notifyDataSetChanged()
    }

    class CocktailViewHolder(var view: View) : RecyclerView.ViewHolder(view)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CocktailViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val view = inflater.inflate(R.layout.detail_cocktail_info, parent, false)
        return CocktailViewHolder(view)
    }

    override fun getItemCount() = cocktailList.size

    override fun onBindViewHolder(holder: CocktailViewHolder, position: Int) {
        holder.view.imageViewSmallPoster.loadImage(cocktailList[position].imgUrl, getProgressDrawable(holder.view.imageViewSmallPoster.context))
        holder.view.textViewCocktailName.text = cocktailList[position].drinkName
        holder.view.setOnClickListener {
            Navigation.findNavController(it).navigate(ResultAllListFragmentDirections.actionToDetailInfoFragment())
        }
    }
}