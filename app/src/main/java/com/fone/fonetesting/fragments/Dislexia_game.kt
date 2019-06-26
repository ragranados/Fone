package com.fone.fonetesting.fragments


import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import com.fone.fonetesting.R
import kotlinx.android.synthetic.main.activity_game_dislexia.*
import kotlinx.android.synthetic.main.fragment_complete_words.view.*
import kotlinx.android.synthetic.main.fragment_dislexia_game.view.*


class Dislexia_game : Fragment() {

    var listenerTool: SearchGameDislexiaListener? = null

    interface SearchGameDislexiaListener {

        fun nextWord()

        fun option1()
        fun option2()
        fun option3()

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view= inflater.inflate(R.layout.fragment_dislexia_game, container, false).apply {

        }
        initNext(view)
        initOption1(view)
        initOption2(view)
        initOption3(view)
        return view
    }

    fun initNext(container:View) = container_game_dislexia.btn_verificar.setOnClickListener {
        listenerTool?.nextWord()
    }
    fun initOption1(container:View) = container_game_dislexia.tv_palabra1.setOnClickListener {
        listenerTool?.nextWord()
    }
    fun initOption2(container:View) = container_game_dislexia.tv_palabra2.setOnClickListener {
        listenerTool?.nextWord()
    }
    fun initOption3(container:View) = container_game_dislexia.tv_palabra3.setOnClickListener {
        listenerTool?.nextWord()
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        if (context is SearchGameDislexiaListener) {
            listenerTool = context
        } else {
            throw RuntimeException("Se necesita una implementación de  la interfaz")
        }
    }

    override fun onDetach() {
        super.onDetach()
        listenerTool = null
    }



}
