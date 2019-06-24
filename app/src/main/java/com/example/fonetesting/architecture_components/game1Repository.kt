package com.example.fonetesting.architecture_components

import androidx.annotation.WorkerThread
import androidx.lifecycle.LiveData

class game1Repository(private val gameDao: game1Dao) {

    val allGames: LiveData<List<game1>> = gameDao.getGames()

    @WorkerThread
    suspend fun insert(game: game1){
        gameDao.insert(game)
    }

    @WorkerThread
    fun updateLevel(level: Int){
        gameDao.updateLevel(level)
    }
    fun getLevel(): LiveData<List<game1>> = gameDao.searchId()


    fun getAll(): LiveData<List<game1>> = gameDao.getGames()


}