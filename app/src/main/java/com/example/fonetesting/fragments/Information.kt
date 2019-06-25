package com.example.fonetesting.fragments


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView

import com.example.fonetesting.R

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 *
 */
class Information : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view=inflater.inflate(R.layout.fragment_information, container, false).apply {
            findViewById<TextView>(R.id.text1).text = arguments?.getString("key_texto1")
            findViewById<TextView>(R.id.text2).text = arguments?.getString("key_texto2")
            findViewById<TextView>(R.id.text3).text = arguments?.getString("key_texto3")
            findViewById<TextView>(R.id.text4).text = arguments?.getString("key_texto4")

        }
        return view
    }


}
