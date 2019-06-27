package com.fone.fonetesting.architecture_components

import androidx.annotation.WorkerThread
import androidx.lifecycle.LiveData

class game1Repository(private val gameDao: game1Dao) {

    val allGames: LiveData<List<game1>> = gameDao.getGames()

    @WorkerThread
    suspend fun insert(game: game1){
        gameDao.insert(game)
    }
    @WorkerThread
    suspend fun updateLevel(level: Int){
        gameDao.updateLevel(level)
    }
    @WorkerThread
    suspend fun updateLevel2(level: Int){
        gameDao.updateLevel2(level)
    }


    fun getLevel(): LiveData<game1> = gameDao.searchId()


    fun getAll(): LiveData<List<game1>> = gameDao.getGames()


}