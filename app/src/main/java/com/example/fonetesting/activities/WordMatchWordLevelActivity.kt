package com.example.fonetesting.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.speech.tts.TextToSpeech
import android.util.Log
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.LiveData
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.example.fonetesting.R
import com.example.fonetesting.architecture_components.MatchWordGame
import com.example.fonetesting.architecture_components.WordMatchWordViewModel
import com.example.fonetesting.fragments.GameCompletedFragment
import com.example.fonetesting.fragments.LevelCompletedFragment
import com.example.fonetesting.fragments.WordMatchWordLevelFragment
import com.example.fonetesting.levelsdata.MatchWordsLevelsData
import java.util.*
import kotlin.collections.ArrayList
import kotlin.collections.HashMap

class WordMatchWordLevelActivity : AppCompatActivity(), LevelCompletedFragment.OnFragmentInteractionListener,
    WordMatchWordLevelFragment.OnFragmentInteractionListener,
    GameCompletedFragment.OnFragmentInteractionListener {

    lateinit var data_niveles: WordMatchWordViewModel
    var level_completed = ArrayList<Boolean>()

    //lateinit var data_niveles: MatchWordsLevelsData
    lateinit var data_nivel: HashMap<Int, String>

    var currentLevel: Int = 0

    lateinit var mTTs: TextToSpeech


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_word_match_word_level)
        Log.d("datos", "datos creados")

        data_niveles = ViewModelProviders.of(this).get(WordMatchWordViewModel::class.java)

        val leveeeels: LiveData<List<Boolean>> = data_niveles.level_completed


        var observador = Observer<List<Boolean>> { datos ->
            level_completed = getArrayListBoolean(data_niveles?.level_completed?.value)

            //data_niveles.nukeTable()

            if (level_completed.size == 0) {
                data_niveles.allLevels.forEachIndexed { index, i ->
                    data_niveles.insert(MatchWordGame(index, false))
                }
            }

            currentLevel = getLevel(level_completed)

            setLevelFragment(currentLevel, level_completed.size)
        }
        leveeeels.observeForever(observador)

        mTTs = TextToSpeech(this, TextToSpeech.OnInitListener { status ->
            if (status == TextToSpeech.SUCCESS) {
                val spanish = Locale("es", "ES")
                var result = mTTs.setLanguage(spanish)
            }
        })

        //currentLevel = getLevel()


    }

    override fun onResume() {
        super.onResume()

        Log.d("arreglo", level_completed.toString() + "start")
    }

    override fun onDestroy() {
        if (mTTs != null) {
            mTTs.stop()
            mTTs.shutdown()
        }



        super.onDestroy()

        Log.d("arreglo", level_completed.toString() + "start")
    }

    fun getArrayListBoolean(lista: List<Boolean>?): ArrayList<Boolean> {
        var array = ArrayList<Boolean>()
        //Log.d("size", lista?.size.toString())
        if (lista != null) {
            for (i in lista) {
                array.add(i)
                //Log.d("arreglo", lista.size.toString())
            }
        }

        return array
    }

    override fun getNextLevel() {
        data_niveles.insert(MatchWordGame(currentLevel, true))
        //setLevelFragment()
    }

    override fun onLevelPassed() {

        //data_niveles.insert(MatchWordGame(currentLevel,true))
        //currentLevel++

        val newFragment: Fragment

        if (currentLevel == 2) {
            newFragment = GameCompletedFragment.newInstance()
        } else {
            newFragment = LevelCompletedFragment.newInstance()
        }

        changeFragment(R.id.content, newFragment)
    }

    override fun speak(view: TextView) {
        var text = view.text.toString()
        mTTs.setPitch(1.0f)
        mTTs.setSpeechRate(1.0f)

        mTTs.speak(text, TextToSpeech.QUEUE_FLUSH, null)
        //mTTs.speak(text, TextToSpeech.QUEUE_FLUSH, null,null)

    }

    override fun OnGameCompleted() {
        data_niveles.insert(MatchWordGame(currentLevel, true))
        finish()
    }

    fun getLevel(nivel: ArrayList<Boolean>): Int {
        var level = 0


        for (i in nivel) {
            if (!i) {
                //currentLevel = level
                return level
            }
            level++
        }

        //currentLevel = level

        return level
    }

    fun setLevelFragment(level: Int, size: Int) {
        var newFragment: Fragment

        if (level == size) {
            newFragment = GameCompletedFragment.newInstance()
        } else {
            newFragment = WordMatchWordLevelFragment.newInstance(level)
        }

        currentLevel = level

        changeFragment(R.id.content, newFragment)
    }

    private fun changeFragment(id: Int, frag: Fragment) {
        supportFragmentManager.beginTransaction().replace(id, frag).commitAllowingStateLoss()
    }

}
