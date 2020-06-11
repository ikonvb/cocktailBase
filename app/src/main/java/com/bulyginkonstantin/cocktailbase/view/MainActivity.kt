package com.bulyginkonstantin.cocktailbase.view

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.bulyginkonstantin.cocktailbase.R


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        //Stetho.initializeWithDefaults(this)
    }
}
