package com.example.fonetesting.fragments

import android.content.ClipData
import android.content.Context
import android.net.Uri
import android.os.Bundle
import android.util.Log
import android.view.DragEvent
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.lifecycle.ViewModelProviders

import com.example.fonetesting.R
import com.example.fonetesting.architecture_components.WordMatchWordViewModel
import com.example.fonetesting.levelsdata.MatchWordsLevelsData
import kotlinx.android.synthetic.main.fragment_word_match_word_level.view.*

class WordMatchWordLevelFragment : Fragment() {
    lateinit var data_nivel: ArrayList<String>
    var level: Int = 0
    lateinit var fragmentView: View
    private var listener: OnFragmentInteractionListener? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        data_nivel = activity!!.run {
            ViewModelProviders.of(this).get(WordMatchWordViewModel::class.java).getLevelInfo(level)
        }

        //data_nivel = MatchWordsLevelsData().getLevelInfo(level)
    }


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_word_match_word_level, container, false)
        fragmentView = view
        fragmentView.titulo_nivel.text = "nivel " + (level + 1).toString()

        fragmentView.titulo_nivel.setOnClickListener { view ->
            listener?.speak((view as TextView).text.toString())
        }

        fragmentView.indicaciones.setOnClickListener {
            listener?.speak("Arrastra las palabras de la derecha y ordénalas de manera que sean como las de la izquierda")
        }

        if (level != 0) {
            fragmentView.indicaciones.visibility = View.GONE
        }

        initListeners()
        setImages()
        return view
    }

    // TODO: Rename method, update argument and hook method into UI event
    fun onButtonPressed() {
        listener?.onLevelPassed()
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
        fun onLevelPassed()

        fun speak(text: String)
    }

    fun initListeners() {

        var longClickListener = View.OnLongClickListener {

            var data: ClipData = ClipData.newPlainText("", "")
            var shadowBuilder = View.DragShadowBuilder(it)
            it.startDrag(data, shadowBuilder, it, 0)

            true
        }

        /*var longClickListener = View.OnClickListener {
            var data: ClipData = ClipData.newPlainText("", "")
            var shadowBuilder = View.DragShadowBuilder(it)
            it.startDrag(data, shadowBuilder, it, 0)

            true
        }*/


        var dragListenerPalabra1 = View.OnDragListener(fun(v: View, event: DragEvent): Boolean {

            var dragEvent: Int = event.action

            var aux: String
            when (dragEvent) {
                DragEvent.ACTION_DROP -> {
                    var view: View = event.localState as View
                    if (view.id == fragmentView.txt2.id) {
                        aux = fragmentView.txt1.text.toString()
                        fragmentView.txt1.text = fragmentView.txt2.text.toString()
                        fragmentView.txt2.text = aux
                    } else if (view.id == fragmentView.txt3.id) {
                        aux = fragmentView.txt1.text.toString()
                        fragmentView.txt1.text = fragmentView.txt3.text.toString()
                        fragmentView.txt3.text = aux
                    } else if (view.id == fragmentView.txt4.id) {
                        aux = fragmentView.txt1.text.toString()
                        fragmentView.txt1.text = fragmentView.txt4.text.toString()
                        fragmentView.txt4.text = aux
                    }
                }
                DragEvent.ACTION_DRAG_ENTERED -> {


                }
            }
            return true
        })

        var dragListenerPalabra2 = View.OnDragListener(fun(v: View, event: DragEvent): Boolean {

            var dragEvent: Int = event.action

            var aux: String
            when (dragEvent) {
                DragEvent.ACTION_DROP -> {
                    var view: View = event.localState as View
                    if (view.id == fragmentView.txt1.id) {
                        aux = fragmentView.txt2.text.toString()
                        fragmentView.txt2.text = fragmentView.txt1.text.toString()
                        fragmentView.txt1.text = aux
                    } else if (view.id == fragmentView.txt3.id) {
                        aux = fragmentView.txt2.text.toString()
                        fragmentView.txt2.text = fragmentView.txt3.text.toString()
                        fragmentView.txt3.text = aux
                    } else if (view.id == fragmentView.txt4.id) {
                        aux = fragmentView.txt2.text.toString()
                        fragmentView.txt2.text = fragmentView.txt4.text.toString()
                        fragmentView.txt4.text = aux
                    }
                }
                DragEvent.ACTION_DRAG_ENTERED -> {



                }
            }
            return true
        })

        var dragListenerPalabra3 = View.OnDragListener(fun(v: View, event: DragEvent): Boolean {

            var dragEvent: Int = event.action

            var aux: String
            when (dragEvent) {
                DragEvent.ACTION_DROP -> {
                    var view: View = event.localState as View
                    if (view.id == fragmentView.txt1.id) {
                        aux = fragmentView.txt1.text.toString()
                        fragmentView.txt1.text = fragmentView.txt3.text.toString()
                        fragmentView.txt3.text = aux
                    } else if (view.id == fragmentView.txt2.id) {
                        aux = fragmentView.txt2.text.toString()
                        fragmentView.txt2.text = fragmentView.txt3.text.toString()
                        fragmentView.txt3.text = aux
                    } else if (view.id == fragmentView.txt4.id) {
                        aux = fragmentView.txt4.text.toString()
                        fragmentView.txt4.text = fragmentView.txt3.text.toString()
                        fragmentView.txt3.text = aux
                    }
                }
                DragEvent.ACTION_DRAG_ENTERED -> {


                }
            }
            return true
        })

        var dragListenerPalabra4 = View.OnDragListener(fun(v: View, event: DragEvent): Boolean {

            var dragEvent: Int = event.action

            var aux: String
            when (dragEvent) {
                DragEvent.ACTION_DROP -> {
                    var view: View = event.localState as View
                    if (view.id == fragmentView.txt1.id) {
                        aux = fragmentView.txt4.text.toString()
                        fragmentView.txt4.text = fragmentView.txt1.text.toString()
                        fragmentView.txt1.text = aux
                    } else if (view.id == fragmentView.txt2.id) {
                        aux = fragmentView.txt2.text.toString()
                        fragmentView.txt2.text = fragmentView.txt4.text.toString()
                        fragmentView.txt4.text = aux
                    } else if (view.id == fragmentView.txt3.id) {
                        aux = fragmentView.txt3.text.toString()
                        fragmentView.txt3.text = fragmentView.txt4.text.toString()
                        fragmentView.txt4.text = aux
                    }
                }
                DragEvent.ACTION_DRAG_ENTERED -> {


                }
            }
            return true
        })

        fragmentView.txt1.setOnLongClickListener(longClickListener)
        fragmentView.txt2.setOnLongClickListener(longClickListener)
        fragmentView.txt3.setOnLongClickListener(longClickListener)
        fragmentView.txt4.setOnLongClickListener(longClickListener)

        fragmentView.txt1.setOnDragListener(dragListenerPalabra1)
        fragmentView.txt2.setOnDragListener(dragListenerPalabra2)
        fragmentView.txt3.setOnDragListener(dragListenerPalabra3)
        fragmentView.txt4.setOnDragListener(dragListenerPalabra4)

        fragmentView.evaluar.setOnClickListener { evaluar() }

    }

    fun setImages() {
        fragmentView.txt5.text = data_nivel[0]
        fragmentView.txt6.text = data_nivel[1]
        fragmentView.txt7.text = data_nivel[2]
        fragmentView.txt8.text = data_nivel[3]

        fragmentView.txt1.text = data_nivel[3]
        fragmentView.txt2.text = data_nivel[0]
        fragmentView.txt3.text = data_nivel[1]
        fragmentView.txt4.text = data_nivel[2]

        //3 0 1 2
    }

    fun verificarGane(): Boolean {

        return data_nivel[0] == fragmentView.txt1.text && data_nivel[1] == fragmentView.txt2.text && data_nivel[2] == fragmentView.txt3.text && data_nivel[3] == fragmentView.txt4.text
    }

    fun evaluar() {
        if (verificarGane()) {
            onButtonPressed()
            fragmentView.titulo_nivel.text = "Lo has logrado!"
        } else {
            fragmentView.titulo_nivel.text = "Sigue intentando..."
        }
    }


    companion object {
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(nivel: Int): WordMatchWordLevelFragment {
            val newFragment = WordMatchWordLevelFragment()
            newFragment.level = nivel
            return newFragment
        }

    }
}
