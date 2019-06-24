package com.example.fonetesting.activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProviders
import com.example.fonetesting.R
import com.example.fonetesting.adapters.PageAdapter
import com.example.fonetesting.architecture_components.GameViewModel
import com.example.fonetesting.architecture_components.game1
import com.example.fonetesting.architecture_components.game1Dao
import com.example.fonetesting.architecture_components.game1Repository
import com.example.fonetesting.fragments.FirstLevelFragment
import com.example.fonetesting.fragments.SecondLevelFragment
import com.example.fonetesting.fragments.SettingsFragment
import com.google.android.material.bottomnavigation.BottomNavigationMenu
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.google.android.material.button.MaterialButton
import com.google.firebase.auth.FirebaseAuth
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), SecondLevelFragment.SearchNewGameListener {
    override fun JuegoUnirPalabras() {
        startActivity(Intent(this, WordMatchWordLevelActivity::class.java))
    }

    override fun Game1() {
        var mIntent = Intent(this, Game1::class.java)
        val viewModel = ViewModelProviders.of(this).get(GameViewModel::class.java)
        var level=viewModel.getLevel()
        Log.d("HG", level.value?.get(0)?.nivel.toString())
//        Log.d("HG", (level.value!![0].nivel).toString())




        //mIntent.putExtra("key_level", level.value?.get(0)?.nivel.toString())

        this.startActivity(mIntent)
    }

    private var mAuth: FirebaseAuth? = null


    //var pagerAdapter: PageAdapter?=null
    private val mOnNavigationItemSelectedListener = BottomNavigationView.OnNavigationItemSelectedListener { item ->
        when (item.itemId) {
            R.id.nav_home -> {
                replaceFragment(FirstLevelFragment())
                return@OnNavigationItemSelectedListener true
            }
            R.id.nav_play -> {
                replaceFragment(SecondLevelFragment())
                return@OnNavigationItemSelectedListener true
            }
            R.id.nav_settings -> {
                replaceFragment(SettingsFragment())
                return@OnNavigationItemSelectedListener true
            }
        }
        false

    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        mAuth = FirebaseAuth.getInstance()

        /*pagerAdapter = PageAdapter(supportFragmentManager)
        pagerAdapter!!.addFragments(FirstLevelFragment(), "First Level")
        pagerAdapter!!.addFragments(SecondLevelFragment(), "Second Level")

        vp_container.adapter = pagerAdapter*/

        bottom_navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener)
        if (savedInstanceState == null) {
            val fragment = FirstLevelFragment()
            supportFragmentManager.beginTransaction().replace(R.id.vp_container, fragment, fragment.javaClass.simpleName)
                    .commit()
        }

        var btnLogout = findViewById<View>(R.id.logout_test) as MaterialButton
        btnLogout.setOnClickListener {
            FirebaseAuth.getInstance().signOut()
            val intent = Intent(this, LoginActivity::class.java)
            startActivity(intent)
        }

    }

    private fun replaceFragment(fragment: Fragment) {
        val fragmentTransaction = supportFragmentManager.beginTransaction()
        fragmentTransaction.replace(R.id.vp_container, fragment)
        fragmentTransaction.commit()
    }
}
