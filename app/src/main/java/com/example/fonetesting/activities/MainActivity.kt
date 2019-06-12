package com.example.fonetesting.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.fonetesting.R
import com.example.fonetesting.adapters.PageAdapter
import com.example.fonetesting.fragments.FirstLevelFragment
import com.example.fonetesting.fragments.SecondLevelFragment
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    var pagerAdapter: PageAdapter?=null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        pagerAdapter = PageAdapter(supportFragmentManager)
        pagerAdapter!!.addFragments(FirstLevelFragment(), "First Level")
        pagerAdapter!!.addFragments(SecondLevelFragment(), "Second Level")

        vp_container.adapter = pagerAdapter


    }
}
