package com.example.fonetesting.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.speech.tts.TextToSpeech
import android.util.Log
import android.widget.TextView
import androidx.fragment.app.Fragment
import com.example.fonetesting.R
import com.example.fonetesting.fragments.GameCompletedFragment
import com.example.fonetesting.fragments.LevelCompletedFragment
import com.example.fonetesting.fragments.WordMatchWordLevelFragment
import com.example.fonetesting.levelsdata.MatchWordsLevelsData
import java.util.*
import kotlin.collections.HashMap

class WordMatchWordLevelActivity : AppCompatActivity(), LevelCompletedFragment.OnFragmentInteractionListener,
        WordMatchWordLevelFragment.OnFragmentInteractionListener,
        GameCompletedFragment.OnFragmentInteractionListener {

    lateinit var data_niveles: MatchWordsLevelsData
    lateinit var data_nivel: HashMap<Int, String>

    var currentLevel: Int = 0

    lateinit var mTTs: TextToSpeech

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_word_match_word_level)
        Log.d("datos", "datos creados")
        data_niveles = MatchWordsLevelsData.newInstance()!!

        mTTs = TextToSpeech(this, TextToSpeech.OnInitListener { status ->
            if (status == TextToSpeech.SUCCESS) {
                val spanish = Locale("es", "ES")
                var result = mTTs.setLanguage(spanish)

            }
        })

        currentLevel = getLevel()

        setLevelFragment()
    }

    override fun onDestroy() {

        if (mTTs != null) {
            mTTs.stop()
            mTTs.shutdown()
        }

        super.onDestroy()
    }

    /*override fun onSaveInstanceState(outState: Bundle?, outPersistentState: PersistableBundle?) {
        super.onSaveInstanceState(outState, outPersistentState)
        outState?.putInt("currentLevel",currentLevel)
    }

    override fun onRestoreInstanceState(savedInstanceState: Bundle?) {
        super.onRestoreInstanceState(savedInstanceState)

        currentLevel = savedInstanceState?.getInt("currentLevel")!!
    }*/

    override fun getNextLevel() {
        setLevelFragment()
    }

    override fun onLevelPassed() {
        data_niveles.level_completed[currentLevel] = true
        currentLevel++

        val newFragment: Fragment

        if (currentLevel == data_niveles.level_completed.size) {
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
    }

    override fun OnGameCompleted() {
        finish()
    }

    fun getLevel(): Int {
        var level = 0


        for (i in data_niveles?.level_completed!!) {
            if (!i) {
                //currentLevel = level
                return level
            }
            level++
        }

        return level
    }

    fun setLevelFragment() {
        var newFragment = WordMatchWordLevelFragment.newInstance(currentLevel)


        changeFragment(R.id.content, newFragment)
    }

    private fun changeFragment(id: Int, frag: Fragment) {
        supportFragmentManager.beginTransaction().replace(id, frag).commit()
    }

}
