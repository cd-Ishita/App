package com.example.myapplication

import com.example.myapplication.R
import android.annotation.SuppressLint
import android.os.Bundle
import androidx.appcompat.app.ActionBar
import androidx.appcompat.app.ActionBar.DISPLAY_SHOW_CUSTOM
import androidx.appcompat.app.AppCompatActivity


class MainActivity : AppCompatActivity() {

//    @SuppressLint("WrongConstant")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

//        val mActionBar: ActionBar = actionBar
//        mActionBar.setDisplayShowHomeEnabled(false)
//        mActionBar.setDisplayShowTitleEnabled(false)
//
////Initializes the custom action bar layout
//
////Initializes the custom action bar layout
//        val mInflater = LayoutInflater.from(this)
//        val mCustomView: View = mInflater.inflate(R.layout.action_bar, null)
//        mActionBar.customView = mCustomView
//        mActionBar.setDisplayShowCustomEnabled(true)

//        val actionbar: ActionBar? = supportActionBar
//
//// Applies the custom action bar style
//
//// Applies the custom action bar style
//        supportActionBar!!.displayOptions = DISPLAY_SHOW_CUSTOM
//        supportActionBar!!.setCustomView(R.layout.action_bar)

    }
}
