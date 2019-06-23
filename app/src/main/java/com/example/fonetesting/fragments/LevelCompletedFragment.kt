package com.example.fonetesting.fragments

import android.content.Context
import android.net.Uri
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import com.example.fonetesting.R
import kotlinx.android.synthetic.main.fragment_level_completed.view.*

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Activities that contain this fragment must implement the
 * [LevelCompletedFragment.OnFragmentInteractionListener] interface
 * to handle interaction events.
 * Use the [LevelCompletedFragment.newInstance] factory method to
 * create an instance of this fragment.
 *
 */
class LevelCompletedFragment : Fragment() {

    lateinit var fragmentView: View
    private var listener: OnFragmentInteractionListener? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_level_completed, container, false)
        fragmentView = view

        fragmentView.b_siguiente_nivel.setOnClickListener { onButtonPressed() }

        return view
    }

    // TODO: Rename method, update argument and hook method into UI event
    fun onButtonPressed() {
        listener?.getNextLevel()
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
        fun getNextLevel()
    }

    companion object {

        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(): LevelCompletedFragment {
            return LevelCompletedFragment()
        }
    }
}
