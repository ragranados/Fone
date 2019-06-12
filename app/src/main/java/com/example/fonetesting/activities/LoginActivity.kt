package com.example.fonetesting.activities

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.widget.NestedScrollView
import com.example.fonetesting.R
import com.google.android.material.button.MaterialButton
import com.google.firebase.auth.FirebaseAuth
import kotlinx.android.synthetic.main.login_screen.*

class LoginActivity: AppCompatActivity() {

    private lateinit var registerBtn : MaterialButton
    private lateinit var loginBtn : MaterialButton
    private lateinit var nestedScrollView: NestedScrollView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.login_screen)

        loginBtn = findViewById<View>(R.id.login_btn) as MaterialButton

        registerBtn = findViewById<View>(R.id.register_btn_main) as MaterialButton

        nestedScrollView = findViewById<View>(R.id.login_ll) as NestedScrollView

        loginBtn.setOnClickListener{
            performLogin()
        }

        registerBtn.setOnClickListener{
            val intent = Intent(baseContext, RegisterActivity::class.java)
            startActivity(intent)
        }
    }

    private fun performLogin(){
        val email = login_email.text.toString()
        val password = login_password.text.toString()

        Log.d("Login", "Attemp to login with email: $email")

        FirebaseAuth.getInstance().signInWithEmailAndPassword(email, password)
            .addOnCompleteListener{
                if(!it.isSuccessful) return@addOnCompleteListener
                Log.d("Main", "Log in successful with uid: ${it.result?.user?.uid}")
                val intent = Intent(this, MainActivity::class.java)
                startActivity(intent)
            }
            .addOnFailureListener{
                Toast.makeText(this, "Failed sign in user: ${it.message}", Toast.LENGTH_SHORT).show()
            }
    }
}