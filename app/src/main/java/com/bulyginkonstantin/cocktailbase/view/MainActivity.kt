package com.bulyginkonstantin.cocktailbase.view

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.findNavController
import androidx.navigation.ui.setupWithNavController
import com.bulyginkonstantin.cocktailbase.R
import com.google.android.material.bottomnavigation.BottomNavigationView
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        //setupNav()

        //sql observation in browser
        //Stetho.initializeWithDefaults(this)
    }

    //setup bottom navigation view behavior
//    private fun setupNav() {
//        val navController = findNavController(R.id.nav_host_fragment)
//        findViewById<BottomNavigationView>(R.id.bottomNavigationView)
//            .setupWithNavController(navController)
//
//        navController.addOnDestinationChangedListener { _, destination, _ ->
//            when (destination.id) {
//                R.id.mainFragment -> hideBottomNav()
//                R.id.nav_host_fragment -> hideBottomNav()
//                R.id.chooseSearchFragment -> hideBottomNav()
//                else -> showBottomNav()
//            }
//        }
//    }
//
//    private fun showBottomNav() {
//        bottomNavigationView.visibility = View.VISIBLE
//    }
//
//    private fun hideBottomNav() {
//        bottomNavigationView.visibility = View.GONE
//    }

}
