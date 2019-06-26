package com.fone.fonetesting.fragments


import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import com.fone.fonetesting.R
import kotlinx.android.synthetic.main.fragment_first_level.view.*

class FirstLevelFragment : Fragment() {

    var listenerTool: SearchInformationListener? = null

    interface SearchInformationListener {

        fun dislexia()
        fun sintomas()
        fun causas()

    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        val view= inflater.inflate(R.layout.fragment_first_level, container, false).apply {

        }
        initInfo1(view)
        initInfo2(view)
        initInfo3(view)

        return view
    }
    fun initInfo1(container: View) = container.btn_dislexia.setOnClickListener {
        listenerTool?.dislexia()
    }
    fun initInfo2(container: View) = container.btn_sintomas.setOnClickListener {
        listenerTool?.sintomas()
    }
    fun initInfo3(container: View) = container.btn_motivos.setOnClickListener {
        listenerTool?.causas()
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        if (context is SearchInformationListener) {
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
