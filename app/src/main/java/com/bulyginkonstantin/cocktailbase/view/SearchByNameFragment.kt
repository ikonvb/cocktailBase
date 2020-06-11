package com.bulyginkonstantin.cocktailbase.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import androidx.navigation.Navigation

import com.bulyginkonstantin.cocktailbase.R
import kotlinx.android.synthetic.main.fragment_search_by_name.*

/**
 * A simple [Fragment] subclass.
 */
class SearchByNameFragment : Fragment() {
    private lateinit var imvAnim: Animation

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_search_by_name, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        imvAnim = AnimationUtils.loadAnimation(context, R.anim.choose_fragment_to_go)
        imageView.startAnimation(imvAnim)
        editTextCocktailName.startAnimation(imvAnim)
        buttonSearchByName.startAnimation(imvAnim)

        buttonSearchByName.setOnClickListener {
            val action = SearchByNameFragmentDirections.actionToResulAlltListFragment()
            action.cocktailName = editTextCocktailName.text.toString()
            Navigation.findNavController(it).navigate(action)
        }
    }
}
