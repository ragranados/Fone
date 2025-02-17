package com.fone.fonetesting.architecture_components

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

    @Query("UPDATE table_game1 SET nivel_juego1=:nivel WHERE id= 1")
    suspend fun updateLevel(nivel: Int)

    @Query("UPDATE table_game1 SET nivel_juego2=:nivel WHERE id= 1")
    suspend fun updateLevel2(nivel: Int)





    @Query("SELECT * FROM table_game1 WHERE id=1")
    fun searchId(): LiveData<game1>
}