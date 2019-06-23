package com.example.fonetesting.levelsdata

class MatchWordsLevelsData {

    var levels_data = ArrayList<ArrayList<String>>()
    var level_completed = ArrayList<Boolean>()

    var nivel = ArrayList<String>()


    init {
        nivel.add("pa")
        nivel.add("ta")
        nivel.add("ap")
        nivel.add("la")
        level_completed.add(false)

        addLevel()

        nivel.add("pra")
        nivel.add("tla")
        nivel.add("apa")
        nivel.add("lalo")
        level_completed.add(false)

        addLevel()

        nivel.add("prosa")
        nivel.add("porsa")
        nivel.add("lata")
        nivel.add("lala")
        level_completed.add(false)

        addLevel()

        //Log.d("datos", "datos creados")

    }

    fun getLevelInfo(level: Int): ArrayList<String> {
        return levels_data[level]
    }

    fun addLevel() {
        levels_data.add(nivel.clone() as ArrayList<String>)
        //level_completed.add(false)

        nivel.clear()
    }

    companion object {


        var instance: MatchWordsLevelsData? = null

        fun newInstance(): MatchWordsLevelsData? {
            if (instance != null) {
                return instance
            } else {

                instance = MatchWordsLevelsData()
                return instance
            }
        }
    }
}