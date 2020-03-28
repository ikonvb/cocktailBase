package com.bulyginkonstantin.cocktailbase.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView
import com.bulyginkonstantin.cocktailbase.R
import com.bulyginkonstantin.cocktailbase.databinding.DetailCocktailInfoBinding
import com.bulyginkonstantin.cocktailbase.model.Cocktail
import com.bulyginkonstantin.cocktailbase.view.CocktailClickListener
import com.bulyginkonstantin.cocktailbase.view.ResultAllListFragmentDirections
import kotlinx.android.synthetic.main.detail_cocktail_info.view.*

class CocktailListAdapter(private val cocktailList: ArrayList<Cocktail>) :
    RecyclerView.Adapter<CocktailListAdapter.CocktailViewHolder>(), CocktailClickListener {

    fun updateCocktailList(newCocktailList: List<Cocktail>) {
        cocktailList.clear()
        cocktailList.addAll(newCocktailList)
        notifyDataSetChanged()
    }

    class CocktailViewHolder(var view: DetailCocktailInfoBinding) :
        RecyclerView.ViewHolder(view.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CocktailViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val view = DataBindingUtil.inflate<DetailCocktailInfoBinding>(
            inflater,
            R.layout.detail_cocktail_info,
            parent,
            false
        )
        return CocktailViewHolder(view)
    }

    override fun getItemCount() = cocktailList.size

    override fun onBindViewHolder(holder: CocktailViewHolder, position: Int) {
        holder.view.cocktail = cocktailList[position]
        holder.view.listener = this
    }

    override fun onCocktailClicked(v: View) {
        val uuid = v.cocktailId.text.toString().toInt()
        val action = ResultAllListFragmentDirections.actionToDetailInfoFragment()
        action.cocktailId = uuid
        Navigation.findNavController(v).navigate(action)
    }
}