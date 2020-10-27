package com.example1.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val currentFragment =
                supportFragmentManager.findFragmentById(R.id.fragment_container)

        supportFragmentManager
                .beginTransaction()
                .add(R.id.fragment_container, Fragment2.newInstance())
                .commit()

    }
    }
