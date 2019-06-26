package com.fone.fonetesting.activities

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.ScrollView
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.fone.fonetesting.R
import com.google.android.material.button.MaterialButton
import com.google.firebase.auth.FirebaseAuth
import kotlinx.android.synthetic.main.login_screen.*

class LoginActivity: AppCompatActivity() {

    private lateinit var registerBtn : MaterialButton
    private lateinit var loginBtn : MaterialButton
    private lateinit var nestedScrollView: ScrollView
    private var mAuth: FirebaseAuth? = null
    private lateinit var forgotPw: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.login_screen)
        initAll()
    }

    //checkear si esta logeado o no
    override fun onStart() {
        super.onStart()
        val user = FirebaseAuth.getInstance().currentUser
        if(user != null){
            val intent = Intent(baseContext, MainActivity::class.java)
            startActivity(intent)
            finish()
        }
    }

    private fun initAll(){
        loginBtn = findViewById<View>(R.id.login_btn) as MaterialButton

        registerBtn = findViewById<View>(R.id.register_btn_main) as MaterialButton

        nestedScrollView = findViewById<View>(R.id.lolazo) as ScrollView

        forgotPw = findViewById<View>(R.id.forgot_pw) as TextView

        mAuth = FirebaseAuth.getInstance()

        loginBtn.setOnClickListener{
            performLogin()
        }

        registerBtn.setOnClickListener{
            val intent = Intent(baseContext, RegisterActivity::class.java)
            startActivity(intent)
        }

        forgotPw.setOnClickListener{
            val intent = Intent(baseContext, ForgotPasswordActivity::class.java)
            startActivity(intent)
        }
    }

    private fun performLogin(){
        val email = login_email.text.toString()
        val password = login_password.text.toString()

        if (email.isEmpty() || password.isEmpty()){
            Toast.makeText(this, "Please enter all fields", Toast.LENGTH_SHORT).show()
            return
        }

        Log.d("Login", "Attemp to login with email: $email")

        mAuth!!.signInWithEmailAndPassword(email, password)
            .addOnCompleteListener{
                if(!it.isSuccessful) return@addOnCompleteListener
                Log.d("Main", "Log in successful with uid: ${it.result?.user?.uid}")
                val intent = Intent(this, MainActivity::class.java)

                startActivity(intent)
                finish()
            }
            .addOnFailureListener{
                Toast.makeText(this, "Failed sign in user: ${it.message}", Toast.LENGTH_SHORT).show()
            }
    }
}