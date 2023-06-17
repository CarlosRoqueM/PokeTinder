package com.roque.carlos.poketinder.ui.view

import android.os.Bundle
import androidx.navigation.findNavController

import androidx.navigation.ui.setupWithNavController
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.roque.carlos.poketinder.R
import com.roque.carlos.poketinder.databinding.ActivityMainBinding
import com.roque.carlos.poketinder.ui.viewmodel.MainViewModel



class MainActivity : BaseActivity<ActivityMainBinding>(ActivityMainBinding::inflate){

    private val viewModel by lazy { MainViewModel() }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val navView: BottomNavigationView = binding.navView

        val navController = findNavController(R.id.nav_host_fragment)

        navView.setupWithNavController(navController)

    }
}