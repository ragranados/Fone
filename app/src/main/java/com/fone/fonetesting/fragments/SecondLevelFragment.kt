package com.fone.fonetesting.fragments


import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import com.fone.fonetesting.R
import kotlinx.android.synthetic.main.fragment_second_level.view.*

class SecondLevelFragment : Fragment() {

    var listenerTool: SearchNewGameListener? = null

    interface SearchNewGameListener {

        fun Game1()
        fun JuegoUnirPalabras()

    }

    override fun onCreateView(
            inflater: LayoutInflater, container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_second_level, container, false).apply {

        }
        initGame1(view)

        view.b_juego_unir_palabras.setOnClickListener { iniciarJuegoUnirPalabras() }

        return view
    }

    fun initGame1(container: View) = container.btn_play_game1.setOnClickListener {
        listenerTool?.Game1()
    }

    fun iniciarJuegoUnirPalabras(){
        listenerTool?.JuegoUnirPalabras()
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        if (context is SearchNewGameListener) {
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
