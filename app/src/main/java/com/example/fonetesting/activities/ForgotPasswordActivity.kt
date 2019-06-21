package com.example.fonetesting.activities

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.fonetesting.R
import com.google.android.material.button.MaterialButton
import com.google.firebase.auth.FirebaseAuth
import kotlinx.android.synthetic.main.forgot_pw_screen.*

class ForgotPasswordActivity: AppCompatActivity() {

    private var mAuth: FirebaseAuth? = null
    private lateinit var restBtn: MaterialButton

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.forgot_pw_screen)

        mAuth = FirebaseAuth.getInstance()

        restBtn = findViewById(R.id.restablecer_pw_btn)

        restBtn.setOnClickListener{
            forgotPassword()
        }

    }

    private fun forgotPassword(){
        val email = resetpw_txtedit.text.toString()
        if (email.isEmpty()){
            Toast.makeText(this, "Digite su correo electronico", Toast.LENGTH_SHORT).show()
            return
        }

        mAuth!!.sendPasswordResetEmail(email)
                .addOnCompleteListener{
                    if(it.isSuccessful){
                        Toast.makeText(this, "Check email to reset your password!", Toast.LENGTH_SHORT).show()
                    }
                }
                .addOnFailureListener{
                    Toast.makeText(this, "Fail to send reset password email!", Toast.LENGTH_SHORT).show()
                }
    }

}