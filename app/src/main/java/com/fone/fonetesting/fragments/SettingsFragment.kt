package com.fone.fonetesting.fragments


import android.app.Activity
import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.fone.fonetesting.R
import com.fone.fonetesting.activities.AccesibilityActivity
import com.google.firebase.auth.FirebaseAuth
import kotlinx.android.synthetic.main.settings_fragment.view.*

class SettingsFragment : Fragment() {

    private var mAuth: FirebaseAuth? = null

    private var listener: OnFragmentInteractionListener? = null

    override fun onCreateView(
            inflater: LayoutInflater, container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        val view: View = inflater!!.inflate(R.layout.settings_fragment, container, false)
        view.sign_out_btn.setOnClickListener {

            listener?.logOutF()

        }

        view.Accesibilidad.setOnClickListener {

            startActivityForResult(Intent(activity, AccesibilityActivity::class.java), AccesibilityActivity.codigoResultadoSettings)
        }
        return view
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        if (resultCode == Activity.RESULT_OK && requestCode == AccesibilityActivity.codigoResultadoSettings) {

            data?.extras?.let {
                listener?.setSettings(it.getFloat(AccesibilityActivity.speed),it.getFloat(AccesibilityActivity.pitch))
            }
        }
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        if (context is OnFragmentInteractionListener) {
            listener = context
        } else {
            throw RuntimeException(context.toString() + " must implement OnFragmentInteractionListener")
        }
    }

    interface OnFragmentInteractionListener {
        fun setSettings(speed: Float, pitch: Float)

        fun logOutF()
    }
}
