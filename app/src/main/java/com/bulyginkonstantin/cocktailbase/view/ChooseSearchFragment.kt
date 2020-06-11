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
import kotlinx.android.synthetic.main.fragment_choose_search.*

/**
 * A simple [Fragment] subclass.
 */
class ChooseSearchFragment : Fragment() {

    private lateinit var imvAnim: Animation
    private lateinit var btnAnim: Animation


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_choose_search, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        imvAnim = AnimationUtils.loadAnimation(context, R.anim.choose_fragment_to_go)
        btnAnim = AnimationUtils.loadAnimation(context, R.anim.btn_to_go)
        imageViewSearch.startAnimation(imvAnim)
        textView.startAnimation(imvAnim)
        buttonFindByName.startAnimation(btnAnim)
        buttonShowAll.startAnimation(btnAnim)
        buttonFavourite.startAnimation(btnAnim)



        buttonFindByName.setOnClickListener {
            val action = ChooseSearchFragmentDirections.actionToSearchByNameFragment()
            Navigation.findNavController(it).navigate(action)
        }

        buttonShowAll.setOnClickListener {
            val action = ChooseSearchFragmentDirections.actionToResulAlltListFragment()
            action.cocktailName = ""
            Navigation.findNavController(it).navigate(action)
        }

        buttonFavourite.setOnClickListener {
            val action = ChooseSearchFragmentDirections.actionFromChooseSearchFragmentToFavouriteListFragment()
            Navigation.findNavController(it).navigate(action)
        }

    }
}
