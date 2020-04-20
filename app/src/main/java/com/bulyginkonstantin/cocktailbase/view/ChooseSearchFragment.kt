package com.bulyginkonstantin.cocktailbase.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation

import com.bulyginkonstantin.cocktailbase.R
import kotlinx.android.synthetic.main.fragment_choose_search.*

/**
 * A simple [Fragment] subclass.
 */
class ChooseSearchFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_choose_search, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        buttonFindByName.setOnClickListener {
            val action = ChooseSearchFragmentDirections.actionToSearchByNameFragment()
            Navigation.findNavController(it).navigate(action)
        }

        buttonShowAll.setOnClickListener {
            val action = ChooseSearchFragmentDirections.actionToResulAlltListFragment()
            Navigation.findNavController(it).navigate(action)
        }

        buttonFavourite.setOnClickListener {
            val action = ChooseSearchFragmentDirections.actionFromChooseSearchFragmentToFavouriteListFragment()
            Navigation.findNavController(it).navigate(action)
        }

    }
}
