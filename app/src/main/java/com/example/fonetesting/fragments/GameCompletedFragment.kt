package com.example.fonetesting.fragments

import android.content.Context
import android.net.Uri
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import com.example.fonetesting.R
import kotlinx.android.synthetic.main.fragment_game_completed.view.*

class GameCompletedFragment : Fragment() {
    private var listener: OnFragmentInteractionListener? = null
    lateinit var fragmentView: View

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment

        val view = inflater.inflate(R.layout.fragment_game_completed, container, false)

        fragmentView = view

        fragmentView.b_regresar_pagina_principal.setOnClickListener { onButtonPressed() }

        return view
    }

    // TODO: Rename method, update argument and hook method into UI event
    fun onButtonPressed() {
        listener?.OnGameCompleted()
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        if (context is OnFragmentInteractionListener) {
            listener = context
        } else {
            throw RuntimeException(context.toString() + " must implement OnFragmentInteractionListener")
        }
    }

    override fun onDetach() {
        super.onDetach()
        listener = null
    }

    interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        fun OnGameCompleted()
    }

    companion object {

        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(): GameCompletedFragment {
            return GameCompletedFragment()
        }

    }
}