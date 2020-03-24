package com.bulyginkonstantin.cocktailbase.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation

import com.bulyginkonstantin.cocktailbase.R
import kotlinx.android.synthetic.main.fragment_result_list.*

/**
 * A simple [Fragment] subclass.
 */
class ResultAllListFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_result_list, container, false)
    }
}
