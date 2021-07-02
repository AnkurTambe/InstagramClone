package com.ankurtambe.instagramclone.fragment

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.ankurtambe.instagramclone.R
import com.ankurtambe.instagramclone.activity.EditProfileActivity
import com.ankurtambe.instagramclone.activity.LogInActivity
import com.ankurtambe.instagramclone.activity.MainActivity
import com.google.android.material.bottomsheet.BottomSheetDialog
import com.google.firebase.auth.FirebaseAuth
import kotlinx.android.synthetic.main.dialog_menu.*
import kotlinx.android.synthetic.main.dialog_menu.view.*
import kotlinx.android.synthetic.main.fragment_profile.view.*

class ProfileFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val root = inflater.inflate(R.layout.fragment_profile, container, false) as ViewGroup

        root.iv_menu_pro.setOnClickListener {
            val bottomSheetDialog =
                BottomSheetDialog(container!!.context, R.style.BottomSheetDialogTheme)

            var bottomSheetView = LayoutInflater.from(container.context)
                .inflate(R.layout.dialog_menu, menu_dialog_container)

            bottomSheetView.rl_log_out.setOnClickListener {
                FirebaseAuth.getInstance().signOut()

                Toast.makeText(container.context, "Logged Out!", Toast.LENGTH_SHORT).show()

                val intent = Intent(container.context, LogInActivity::class.java)
                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK or Intent.FLAG_ACTIVITY_NEW_TASK)
                startActivity(intent)
                activity?.finish()
            }

            bottomSheetView.rl_delete_account.setOnClickListener {

            }

            bottomSheetDialog.setContentView(bottomSheetView)
            bottomSheetDialog.show()
        }

        root.btn_edit_pro.setOnClickListener {
            var i = Intent(container!!.context, EditProfileActivity::class.java)
            startActivity(i)
            activity?.finish()
            activity?.overridePendingTransition(R.anim.slide_up_in, R.anim.no_anim)
        }

        return root
    }
}