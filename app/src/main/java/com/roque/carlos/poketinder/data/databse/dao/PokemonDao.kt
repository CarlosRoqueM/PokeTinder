package com.roque.carlos.poketinder.data.databse.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.roque.carlos.poketinder.data.databse.entities.MyPokemonEntity

@Dao
interface PokemonDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(pokemon: MyPokemonEntity)

    @Query("SELECT * FROM pokemon_table")
    suspend fun getAllPokemons() : List<MyPokemonEntity>

    @Query("DELETE FROM pokemon_table")
    suspend fun deleteTable();
}