package com.example.fonetesting.fragments


import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import com.example.fonetesting.R
import com.example.fonetesting.activities.LoginActivity
import com.example.fonetesting.activities.SplashActivity
import com.google.android.material.button.MaterialButton
import com.google.firebase.auth.FirebaseAuth
import kotlinx.android.synthetic.main.settings_fragment.*
import kotlinx.android.synthetic.main.settings_fragment.view.*

class SettingsFragment : Fragment() {

    private var mAuth: FirebaseAuth? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view: View = inflater!!.inflate(R.layout.settings_fragment, container, false)
        view.sign_out_btn.setOnClickListener{
            mAuth?.signOut()
            Toast.makeText(activity, "Please enter all fields", Toast.LENGTH_SHORT).show()
            activity?.finish()
        }
        return view
    }
}
