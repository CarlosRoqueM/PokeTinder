package com.roque.carlos.poketinder.ui.viewmodel

import android.content.Context
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.room.Room
import com.roque.carlos.poketinder.data.databse.PokemonDatabase
import com.roque.carlos.poketinder.data.databse.entities.MyPokemonEntity
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class FavoriteViewModel : ViewModel() {
    private val POKEMON_DATABASE_NAME = "pokemon_database"

    val myPokemonlist = MutableLiveData<List<MyPokemonEntity>>()

    fun getMyPokemons(context: Context){
        CoroutineScope(Dispatchers.IO).launch {
            val myPokemons = getRoomDataBase(context).getPokemonDao().getAllPokemons()
            myPokemonlist.postValue(myPokemons)
        }
    }

    fun deleteAllPokemon(context: Context){
        viewModelScope.launch {
            getRoomDataBase(context).getPokemonDao().deleteTable()
            myPokemonlist.postValue(emptyList())
        }
    }

    private fun getRoomDataBase(context: Context): PokemonDatabase{
        return  Room.databaseBuilder(
            context,
            PokemonDatabase::class.java,
            POKEMON_DATABASE_NAME).build()
    }
}