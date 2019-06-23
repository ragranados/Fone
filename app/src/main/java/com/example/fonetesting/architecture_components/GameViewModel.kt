package com.example.fonetesting.architecture_components

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch

class GameViewModel(application: Application): AndroidViewModel(application) {

    private val repository: game1Repository

    val allGames: LiveData<List<game1>>

    init{
        val GamesDao = GameRoomDatabase.getDatabase(application, viewModelScope).gameDao()
        repository= game1Repository(GamesDao)
        allGames=repository.allGames
    }

    fun insert(game: game1)= viewModelScope.launch{
        repository.insert(game)

    }
    fun getAll(): LiveData<List<game1>> = repository.getAll()
}