package com.ankurtambe.instagramclone.activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import com.ankurtambe.instagramclone.R
import com.ankurtambe.instagramclone.fragment.HomeFragment
import com.ankurtambe.instagramclone.fragment.ProfileFragment
import kotlinx.android.synthetic.main.activity_edit_profile.*

class EditProfileActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_edit_profile)

        iv_cancel_ep.setOnClickListener {
            val i = Intent(this, MainActivity::class.java)
            i.putExtra("frag", "e")
            startActivity(i)
            finish()
            overridePendingTransition(0, R.anim.slide_down_out)
        }

        iv_check_ep.setOnClickListener {
            var i = Intent(this, MainActivity::class.java)
            i.putExtra("frag", "e")
            startActivity(i)
            finish()
            overridePendingTransition(0, R.anim.slide_down_out)
        }
    }

    override fun onBackPressed() {
        var i = Intent(this, MainActivity::class.java)
        i.putExtra("frag", "e")
        startActivity(i)
        finish()
        overridePendingTransition(0, R.anim.slide_down_out)
    }
}