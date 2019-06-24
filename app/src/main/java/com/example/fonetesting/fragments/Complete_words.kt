package com.example.fonetesting.fragments


import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView

import com.example.fonetesting.R
import kotlinx.android.synthetic.main.fragment_complete_words.view.*

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 *
 */
class Complete_words : Fragment() {

    var listenerTool :  SearchNewMovieListener? = null

    interface SearchNewMovieListener{

        fun nextWord()
        fun option1()
        fun option2()
        fun option3()
        fun option4()
        fun option5()
        fun option6()
        fun option7()
        fun option8()




    }


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view= inflater.inflate(R.layout.fragment_complete_words, container, false).apply {

            findViewById<TextView>(R.id.tv_cont).text = arguments?.getString("key_level")
            /* findViewById<TextView>(R.id.tv_word).text = arguments?.getString("palabra")
             findViewById<TextView>(R.id.tv_cont).text = arguments?.getString("cont")*/
        }
        initSearchButton(view)
        initOption1(view)
        initOption2(view)
        initOption3(view)
        initOption4(view)
        initOption5(view)
        initOption6(view)
        initOption7(view)
        initOption8(view)


        return view

    }

    fun initSearchButton(container:View) = container.btn_verification.setOnClickListener {
        listenerTool?.nextWord()
    }

    fun initOption1(container:View) = container.opc1.setOnClickListener {
        listenerTool?.option1()
    }
    fun initOption2(container:View) = container.opc2.setOnClickListener {
        listenerTool?.option2()
    }
    fun initOption3(container:View) = container.opc3.setOnClickListener {
        listenerTool?.option3()
    }
    fun initOption4(container:View) = container.opc4.setOnClickListener {
        listenerTool?.option4()
    }
    fun initOption5(container:View) = container.opc5.setOnClickListener {
        listenerTool?.option5()
    }
    fun initOption6(container:View) = container.opc6.setOnClickListener {
        listenerTool?.option6()
    }
    fun initOption7(container:View) = container.opc7.setOnClickListener {
        listenerTool?.option7()
    }
    fun initOption8(container:View) = container.opc8.setOnClickListener {
        listenerTool?.option8()
    }
    override fun onAttach(context: Context) {
        super.onAttach(context)
        if (context is SearchNewMovieListener) {
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
