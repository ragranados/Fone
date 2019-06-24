package com.example.fonetesting.architecture_components

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface MatchWordGameDao {
    @Query("SELECT passed FROM table_matchwordgame")
    fun getAllLevels(): LiveData<List<Boolean>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(passed: MatchWordGame)

    @Query("DELETE FROM table_matchwordgame")
    suspend fun nukeTable()
}