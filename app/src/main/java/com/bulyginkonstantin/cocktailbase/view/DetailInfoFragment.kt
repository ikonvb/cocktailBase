package com.bulyginkonstantin.cocktailbase.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.bulyginkonstantin.cocktailbase.R
import com.bulyginkonstantin.cocktailbase.viewmodel.DetailViewModel
import kotlinx.android.synthetic.main.fragment_detail_info.*

/**
 * A simple [Fragment] subclass.
 */
class DetailInfoFragment : Fragment() {

    private lateinit var viewModel: DetailViewModel
    private var cocktailId = 0

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_detail_info, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel = ViewModelProviders.of(this).get(DetailViewModel::class.java)
        viewModel.fetchFromDatabase()

        arguments?.let {
            cocktailId = DetailInfoFragmentArgs.fromBundle(it).cocktailId
        }

        observeViewModel()
    }

    private fun observeViewModel() {
        viewModel.cocktailLiveData.observe(viewLifecycleOwner, Observer {
            it?.let {
                cocktailNameTextView.text = it.strDrink
                glassTextView.text = it.strGlass
                alcoholicTextView.text = it.strAlcoholic
                styleTextView.text = it.strCategory
                instructionsTextView.text = it.strInstructions
            }
        })
    }
}
