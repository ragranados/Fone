package com.fone.fonetesting.levelsdata

import androidx.annotation.WorkerThread
import androidx.lifecycle.LiveData
import com.fone.fonetesting.architecture_components.MatchWordGame
import com.fone.fonetesting.architecture_components.MatchWordGameDao

class MatchWordsLevelsData(private val matchWordGameDao: MatchWordGameDao) {

    var levels_data = ArrayList<ArrayList<String>>()
    val level_completed : LiveData<List<Boolean>> = matchWordGameDao.getAllLevels()

    var nivel = ArrayList<String>()


    init {
        nivel.add("pa")
        nivel.add("ta")
        nivel.add("ap")
        nivel.add("la")

        addLevel()

        nivel.add("pra")
        nivel.add("tla")
        nivel.add("apa")
        nivel.add("lalo")

        addLevel()

        nivel.add("Jitete")
        nivel.add("Florero")
        nivel.add("Flomero")
        nivel.add("Jinete")

        addLevel()

        nivel.add("plancha")
        nivel.add("tlancha")
        nivel.add("Sandia")
        nivel.add("Pandia")

        addLevel()

        nivel.add("prosa")
        nivel.add("porsa")
        nivel.add("lata")
        nivel.add("lala")

        addLevel()

        nivel.add("raton")
        nivel.add("gaton")
        nivel.add("carton")
        nivel.add("tarcon")

        addLevel()

        nivel.add("cisco")
        nivel.add("disco")
        nivel.add("lisco")
        nivel.add("visco")

        addLevel()

        nivel.add("debo")
        nivel.add("bebo")
        nivel.add("dedo")
        nivel.add("dado")

        addLevel()


    }

    /*suspend fun levelCompleted(): List<Boolean>{
        return matchWordGameDao.getAllLevels()
    }*/

    fun getLevelInfo(level: Int): ArrayList<String> {
        return levels_data[level]
    }

    fun addLevel() {
        levels_data.add(nivel.clone() as ArrayList<String>)
        //level_completed.add(false)

        nivel.clear()
    }

    @WorkerThread
    suspend fun insert(game: MatchWordGame){
        matchWordGameDao.insert(game)
    }

    @WorkerThread
    suspend fun nukeTable(){
        matchWordGameDao.nukeTable()
    }

    /*companion object {


        var instance: MatchWordsLevelsData? = null

        fun newInstance(matchWordGameDao: MatchWordGameDao): MatchWordsLevelsData? {
            if (instance != null) {
                return instance
            } else {

                instance = MatchWordsLevelsData(matchWordGameDao)
                return instance
            }
        }
    }*/
}