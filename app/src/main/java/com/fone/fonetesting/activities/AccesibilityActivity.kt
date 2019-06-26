package com.fone.fonetesting.activities

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.fone.fonetesting.R
import kotlinx.android.synthetic.main.activity_accesibility.*

class AccesibilityActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_accesibility)

        settings_save.setOnClickListener {
            replyToIntent()
        }

    }

    fun replyToIntent() {
        val replyIntent = Intent()
        val reply = Bundle()

        reply.putFloat(speed, (velocidad_voz.progress  / 50f))
        reply.putFloat(pitch,(tono_voz.progress  / 50f)  )
        replyIntent.putExtras(reply)

        setResult(Activity.RESULT_OK, replyIntent)
        finish()

    }


    companion object {
        const val codigoResultadoSettings = 1
        const val speed = "speed"
        const val pitch = "pitch"
    }


}
