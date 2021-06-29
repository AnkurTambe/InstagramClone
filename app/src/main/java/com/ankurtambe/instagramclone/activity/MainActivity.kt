package com.ankurtambe.instagramclone.activity

import android.os.Bundle
import com.google.android.material.bottomnavigation.BottomNavigationView
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.ankurtambe.instagramclone.R
import com.ankurtambe.instagramclone.fragment.*

class MainActivity : AppCompatActivity() {

    private lateinit var navView: BottomNavigationView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var f: String? = intent.getStringExtra("frag")

        navView = findViewById(R.id.bv_main)

        navView.setOnNavigationItemSelectedListener(onNavigationItemSelectedListener)

        if (f == "e") {
            moveToFragment(ProfileFragment())
            navView.selectedItemId = R.id.nav_profile
        } else {
            moveToFragment(HomeFragment())
            navView.selectedItemId = R.id.nav_home
        }
    }

    private val onNavigationItemSelectedListener =
        BottomNavigationView.OnNavigationItemSelectedListener { item ->
            when (item.itemId) {
                R.id.nav_home -> {
                    moveToFragment(HomeFragment())
                    return@OnNavigationItemSelectedListener true
                }
                R.id.nav_search -> {
                    moveToFragment(SearchFragment())
                    return@OnNavigationItemSelectedListener true
                }
                R.id.nav_reel -> {
                    moveToFragment(ReelFragment())
                    return@OnNavigationItemSelectedListener true
                }
                R.id.nav_notifications -> {
                    moveToFragment(NotificationsFragment())
                    return@OnNavigationItemSelectedListener true
                }
                R.id.nav_profile -> {
                    moveToFragment(ProfileFragment())
                    return@OnNavigationItemSelectedListener true
                }
            }

            false
        }

    private fun moveToFragment(fragment: Fragment) {
        val fragmentTrans = supportFragmentManager.beginTransaction()
        fragmentTrans.replace(R.id.fl_main, fragment)
        fragmentTrans.commit()
    }

    override fun onBackPressed() {
        navView = findViewById(R.id.bv_main)

        if (supportFragmentManager.findFragmentById(R.id.fl_main) == HomeFragment()) {
            super.onBackPressed()
        } else {
            moveToFragment(HomeFragment())
            navView.selectedItemId = R.id.nav_home
        }
    }
}
