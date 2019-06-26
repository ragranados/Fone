package com.fone.fonetesting.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.fone.fonetesting.R

import com.fone.fonetesting.fragments.Information

class Information : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_information)

        val fDetalles= Information()
        fDetalles.arguments= intent.extras
        supportFragmentManager.beginTransaction().replace(R.id.container_information,fDetalles).commit()
    }
}
