package com.fone.fonetesting.fragments


import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders

import com.fone.fonetesting.R
import com.fone.fonetesting.architecture_components.GameViewModel
import kotlinx.android.synthetic.main.activity_game_dislexia.*
import kotlinx.android.synthetic.main.fragment_complete_words.*
import kotlinx.android.synthetic.main.fragment_complete_words.view.*
import kotlinx.android.synthetic.main.fragment_dislexia_game.*
import kotlinx.android.synthetic.main.fragment_dislexia_game.view.*
import kotlinx.android.synthetic.main.fragment_dislexia_game.view.tv_palabra


class Dislexia_game : Fragment() {

    var listenerTool: SearchGameDislexiaListener? = null

    interface SearchGameDislexiaListener {

        fun speak()

        fun nextWord()

        fun option1()
        fun option2()
        fun option3()

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val viewModel = ViewModelProviders.of(this).get(GameViewModel::class.java)
        val view= inflater.inflate(R.layout.fragment_dislexia_game, container, false).apply {

        }

        viewModel.getLevel().observe(this, Observer { gam->
            gam?.let {
                tv_nivel.text=gam.nivel_juego2.toString()
            }

        })


        initNext(view)
        initOption1(view)
        initOption2(view)
        initOption3(view)

        view.tv_palabra.setOnClickListener {
            listenerTool?.speak()
        }

        return view
    }

    fun initNext(container:View) = container.btn_verificar.setOnClickListener {
        listenerTool?.nextWord()
    }
    fun initOption1(container:View) = container.tv_palabra1.setOnClickListener {
        listenerTool?.option1()
    }
    fun initOption2(container:View) = container.tv_palabra2.setOnClickListener {
        listenerTool?.option2()
    }
    fun initOption3(container:View) = container.tv_palabra3.setOnClickListener {
        listenerTool?.option3()
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
