package com.swask.activitylifecycle

import android.content.Context
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class AvengersActivity : AppCompatActivity() {
    var titleName: String? = "Avengers"
    lateinit var sharedPreferences: SharedPreferences

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        sharedPreferences = getSharedPreferences(getString(R.string.preference_file_name),Context.MODE_PRIVATE)

        setContentView(R.layout.scrollview_example)
        titleName = sharedPreferences.getString("Title","The Avengers")
        title = titleName
//        println("On Create called")
    }

//    override fun onStart() {
//        super.onStart()
//        println("On Start called")
//    }
//
//    override fun onRestart() {
//        super.onRestart()
//        println("On Restart called")
//    }
//
//    override fun onResume() {
//        super.onResume()
//        println("On Resume called")
//    }
//
//    override fun onPause() {
//        super.onPause()
//        println("On Paus called")
//    }
//
//    override fun onStop() {
//        super.onStop()
//        println("On Stop called")
//    }
//
//    override fun onDestroy() {
//        super.onDestroy()
//        println("On Destroy called")
//    }
}