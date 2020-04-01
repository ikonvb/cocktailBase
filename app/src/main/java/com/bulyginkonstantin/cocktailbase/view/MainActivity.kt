package com.bulyginkonstantin.cocktailbase.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.bulyginkonstantin.cocktailbase.R
import com.facebook.stetho.Stetho

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        Stetho.initializeWithDefaults(this);
    }
}
