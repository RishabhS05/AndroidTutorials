package com.example.hilttutorials

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.hilttutorials.viewModel.HomeViewModel
import dagger.hilt.android.AndroidEntryPoint
import androidx.activity.viewModels

@AndroidEntryPoint
class HomeActivity : AppCompatActivity() {
    val viewModel : HomeViewModel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
}