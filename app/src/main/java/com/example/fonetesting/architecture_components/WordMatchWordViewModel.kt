package com.example.fonetesting.architecture_components

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import com.example.fonetesting.levelsdata.MatchWordsLevelsData
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class WordMatchWordViewModel(application: Application) : AndroidViewModel(application) {


    private val levels_data: MatchWordsLevelsData
    private val database: GameRoomDatabase

    val allLevels : ArrayList<ArrayList<String>>

    val level_completed: LiveData<List<Boolean>>

    init {
        database = GameRoomDatabase.getDatabase(application, viewModelScope)

        levels_data = MatchWordsLevelsData(database.MatchWordGameDao())

        allLevels = levels_data.levels_data

        level_completed = levels_data.level_completed
    }

    fun insert(game: MatchWordGame) = viewModelScope.launch(Dispatchers.IO) {
        levels_data.insert(game)
    }

    fun getLevelInfo(nivel: Int): ArrayList<String>{
        return levels_data.getLevelInfo(nivel)
    }

    fun nukeTable() = viewModelScope.launch(Dispatchers.IO) {
        levels_data.nukeTable()
    }


    /*fun getLevelCompleted():ArrayList<Boolean>{
        return levels_data.
    }*/
}