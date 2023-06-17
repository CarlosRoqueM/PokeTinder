package com.roque.carlos.poketinder.ui.view

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.webkit.WebView
import androidx.fragment.app.viewModels
import com.roque.carlos.poketinder.R
import com.roque.carlos.poketinder.databinding.FragmentInfoBinding
import com.roque.carlos.poketinder.ui.viewmodel.InfoViewModel

class InfoFragment : BaseFragment<FragmentInfoBinding>(FragmentInfoBinding::inflate) {

    private val viewModel: InfoViewModel by viewModels()

    private lateinit var webView: WebView

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        webView = binding.wvInfoFragment

        webView.settings.javaScriptEnabled = true

       viewModel.getUrlPokemon().observe(viewLifecycleOwner){
           webView.loadUrl(it)
       }
    }
}