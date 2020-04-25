package com.bulyginkonstantin.cocktailbase.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation

import com.bulyginkonstantin.cocktailbase.R
import kotlinx.android.synthetic.main.fragment_search_by_name.*

/**
 * A simple [Fragment] subclass.
 */
class SearchByNameFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_search_by_name, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        buttonSearchByName.setOnClickListener {
            val action = SearchByNameFragmentDirections.actionToResulAlltListFragment()
            action.cocktailName = editTextCocktailName.text.toString()
            Navigation.findNavController(it).navigate(action)
        }
    }
}
