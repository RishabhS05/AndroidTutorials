package com.example.fragments

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.add
import androidx.fragment.app.commit
import com.example.fragments.frags.Fragment1

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        if (savedInstanceState == null) {

           supportFragmentManager.commit {
               setReorderingAllowed(true)  // when performing FragmentTransaction it optimizes state changes of the fragment. So the transition and animation work correctly.
               add<Fragment1>(R.id.fragmentContainer)
           }
        }

    }
}