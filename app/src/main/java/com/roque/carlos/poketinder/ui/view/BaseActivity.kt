package com.roque.carlos.poketinder.ui.view

import android.os.Bundle
import androidx.viewbinding.ViewBinding
import android.view.LayoutInflater
import androidx.appcompat.app.AppCompatActivity

abstract class BaseActivity<B : ViewBinding>(val bindingFactory: (LayoutInflater) -> B) : AppCompatActivity(){

    lateinit var binding: B

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = bindingFactory(layoutInflater)
        setContentView(binding.root)
    }
}