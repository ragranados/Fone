package com.example.fonetesting.architecture_components

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query

@Dao
interface MatchWordGameDao {
    @Query("SELECT * FROM table_matchwordgame")
    fun getAllLevels(): LiveData<List<MatchWordGame>>

    @Insert
    suspend fun insert(passed: MatchWordGame)

    @Query("DELETE FROM table_matchwordgame")
    fun nukeTable()
}