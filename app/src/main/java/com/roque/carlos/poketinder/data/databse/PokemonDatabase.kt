package com.roque.carlos.poketinder.data.databse

import androidx.room.Database
import androidx.room.RoomDatabase
import com.roque.carlos.poketinder.data.databse.dao.PokemonDao
import com.roque.carlos.poketinder.data.databse.entities.MyPokemonEntity

@Database(entities = [MyPokemonEntity::class], version = 1)
abstract class PokemonDatabase: RoomDatabase() {

    abstract fun getPokemonDao(): PokemonDao
}