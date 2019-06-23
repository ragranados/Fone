package com.example.fonetesting.architecture_components

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query

@Dao
interface game1Dao {
    @Query("SELECT * FROM table_game1")
    fun getGames(): LiveData<List<game1>>

    @Insert
    suspend fun insert(game: game1)


    @Query("SELECT * FROM table_game1 WHERE id LIKE:id")
    fun searchId(id:Int): LiveData<List<game1>>
}