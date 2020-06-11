package com.bulyginkonstantin.cocktailbase.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import androidx.fragment.app.Fragment
import androidx.navigation.Navigation
import com.bulyginkonstantin.cocktailbase.R
import kotlinx.android.synthetic.main.fragment_main.*

/**
 * A simple [Fragment] subclass.
 */
class MainFragment : Fragment() {
    private lateinit var splashScreenAnim: Animation
    private lateinit var btnAnim: Animation

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_main, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        btnAnim = AnimationUtils.loadAnimation(context, R.anim.btn_to_go)
        splashScreenAnim = AnimationUtils.loadAnimation(context, R.anim.alpha_to_go)
        splashScreen.startAnimation(splashScreenAnim)
        buttonAdvance.startAnimation(btnAnim)

        buttonAdvance.setOnClickListener {
            val action = MainFragmentDirections.actionToChooseSearchFragment()
            Navigation.findNavController(it).navigate(action)
        }
    }
}
