package com.ankurtambe.instagramclone.activity

import android.os.Bundle
import android.widget.ImageView
import com.google.android.material.bottomnavigation.BottomNavigationView
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.ankurtambe.instagramclone.R
import com.ankurtambe.instagramclone.fragment.*
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.activity_main.*
import java.security.AccessController.getContext
import kotlin.system.exitProcess

class MainActivity : AppCompatActivity() {

    private lateinit var navView: BottomNavigationView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

//        Picasso.get().load(R.drawable.home_fill).into(iv_home_main)
//        Picasso.get().load(R.drawable.search_fill).into(iv_search_main)
//        Picasso.get().load(R.drawable.reel_fill).into(iv_reel_main)
//        Picasso.get().load(R.drawable.heart_fill).into(iv_notifications_main)
//        Picasso.get().load(R.drawable.profile_fill).into(iv_profile_main)
//
//        Picasso.get().load(R.drawable.home).into(iv_home_main)
//        Picasso.get().load(R.drawable.search).into(iv_search_main)
//        Picasso.get().load(R.drawable.reel).into(iv_reel_main)
//        Picasso.get().load(R.drawable.heart).into(iv_notifications_main)
//        Picasso.get().load(R.drawable.profile).into(iv_profile_main)

        var f: String? = intent.getStringExtra("frag")

//        iv_home_main.setOnClickListener {
//            Picasso.get().load(R.drawable.home_fill).into(iv_home_main)
//            Picasso.get().load(R.drawable.search).into(iv_search_main)
//            Picasso.get().load(R.drawable.reel).into(iv_reel_main)
//            Picasso.get().load(R.drawable.heart).into(iv_notifications_main)
//            Picasso.get().load(R.drawable.profile).into(iv_profile_main)
//            moveToFragment(HomeFragment())
//        }
//
//        iv_search_main.setOnClickListener {
//            Picasso.get().load(R.drawable.search_fill).into(iv_search_main)
//            Picasso.get().load(R.drawable.home).into(iv_home_main)
//            Picasso.get().load(R.drawable.reel).into(iv_reel_main)
//            Picasso.get().load(R.drawable.heart).into(iv_notifications_main)
//            Picasso.get().load(R.drawable.profile).into(iv_profile_main)
//            moveToFragment(SearchFragment())
//        }
//
//        iv_reel_main.setOnClickListener {
//            Picasso.get().load(R.drawable.reel_fill).into(iv_reel_main)
//            Picasso.get().load(R.drawable.home).into(iv_home_main)
//            Picasso.get().load(R.drawable.search).into(iv_search_main)
//            Picasso.get().load(R.drawable.heart).into(iv_notifications_main)
//            Picasso.get().load(R.drawable.profile).into(iv_profile_main)
//            moveToFragment(ReelFragment())
//        }
//
//        iv_notifications_main.setOnClickListener {
//            Picasso.get().load(R.drawable.heart_fill).into(iv_notifications_main)
//            Picasso.get().load(R.drawable.home).into(iv_home_main)
//            Picasso.get().load(R.drawable.search).into(iv_search_main)
//            Picasso.get().load(R.drawable.reel).into(iv_reel_main)
//            Picasso.get().load(R.drawable.profile).into(iv_profile_main)
//            moveToFragment(NotificationsFragment())
//        }
//
//        iv_profile_main.setOnClickListener {
//            Picasso.get().load(R.drawable.profile_fill).into(iv_profile_main)
//            Picasso.get().load(R.drawable.home).into(iv_home_main)
//            Picasso.get().load(R.drawable.search).into(iv_search_main)
//            Picasso.get().load(R.drawable.reel).into(iv_reel_main)
//            Picasso.get().load(R.drawable.heart).into(iv_notifications_main)
//            moveToFragment(ProfileFragment())
//        }

        navView = findViewById(R.id.btm_nav_layout)

        navView.setOnNavigationItemSelectedListener(onNavigationItemSelectedListener)

        if (f == "e") {
//            Picasso.get().load(R.drawable.home).into(iv_home_main)
//            Picasso.get().load(R.drawable.search).into(iv_search_main)
//            Picasso.get().load(R.drawable.reel).into(iv_reel_main)
//            Picasso.get().load(R.drawable.heart).into(iv_notifications_main)
//            Picasso.get().load(R.drawable.profile_fill).into(iv_profile_main)
            moveToFragment(ProfileFragment())
            navView.selectedItemId = R.id.nav_profile
        } else {
            goToHome()
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

//    override fun onBackPressed() {
//        when (supportFragmentManager.findFragmentById(R.id.fl_main)) {
//            !is HomeFragment -> gotoHome()
//
//            else -> super.onBackPressed()
//        }
//    }
//
//    private fun goToHome() {
//        Picasso.get().load(R.drawable.home_fill).into(iv_home_main)
//        Picasso.get().load(R.drawable.search).into(iv_search_main)
//        Picasso.get().load(R.drawable.reel).into(iv_reel_main)
//        Picasso.get().load(R.drawable.heart).into(iv_notifications_main)
//        Picasso.get().load(R.drawable.profile).into(iv_profile_main)
//        moveToFragment(HomeFragment())
//    }


    override fun onBackPressed() {
        when (supportFragmentManager.findFragmentById(R.id.fl_main)) {
            !is HomeFragment -> goToHome()

            else -> super.onBackPressed()
        }
    }

    private fun goToHome() {
        navView = findViewById(R.id.btm_nav_layout)
        moveToFragment(HomeFragment())
        navView.selectedItemId = R.id.nav_home
    }
}
