package com.roque.carlos.poketinder.ui.view

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import com.roque.carlos.poketinder.R
import com.roque.carlos.poketinder.data.databse.entities.MyPokemonEntity
import com.roque.carlos.poketinder.databinding.FragmentFavoriteBinding
import com.roque.carlos.poketinder.ui.adapter.MyPokemonsAdapter
import com.roque.carlos.poketinder.ui.viewmodel.FavoriteViewModel

class FavoriteFragment : BaseFragment
<FragmentFavoriteBinding>(FragmentFavoriteBinding::inflate) {

    private val favoriteViewModel: FavoriteViewModel by viewModels()

    private val listMyPokemon = mutableListOf<MyPokemonEntity>()

    private val adapter by lazy { MyPokemonsAdapter(listMyPokemon) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        favoriteViewModel.getMyPokemons(requireContext())

        binding.rvPokemons.adapter = adapter

        favoriteViewModel.myPokemonlist.observe(this){
            listMyPokemon.addAll(it)
            adapter.notifyDataSetChanged()
        }
        binding.floatingActionDelete.setOnClickListener{
            favoriteViewModel.deleteAllPokemon(requireContext())
        }
    }
}