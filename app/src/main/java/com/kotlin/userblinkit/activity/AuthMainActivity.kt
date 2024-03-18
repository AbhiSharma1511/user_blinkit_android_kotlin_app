package com.kotlin.userblinkit.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.kotlin.userblinkit.R

class AuthMainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
//        changeStatusBarColor()
    }
//    fun changeStatusBarColor() {
//        activity?.window?.apply {
//            val statusBarColors = ContextCompat.getColor(requireContext(), R.color.yellow)
//            statusBarColor = statusBarColors
//        }
//    }
}