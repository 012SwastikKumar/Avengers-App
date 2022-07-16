package com.swask.activitylifecycle

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Parcel
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast

class LoginActivity() : AppCompatActivity(), View.OnClickListener{

    override fun onClick(p0: View?) {
        val mobileNumber = etMobileNumber.text.toString()
        val password = etPassword.text.toString()
        var nameOfAvenger = "The Avenger"
        val intent = Intent(this@LoginActivity,AvengersActivity::class.java)
        if(validMobileNumber == mobileNumber){
            if(password == validPassword[0]){
                nameOfAvenger = "Iron Man"
                savePreferences(nameOfAvenger)
                intent.putExtra("Name",nameOfAvenger)
                startActivity(intent)
            }else if(password == validPassword[1]){
                nameOfAvenger = "Captain America"
                savePreferences(nameOfAvenger)
                intent.putExtra("Name",nameOfAvenger)
                startActivity(intent)
            }else if(password == validPassword[2]){
                nameOfAvenger = "Hulk"
                savePreferences(nameOfAvenger)
                intent.putExtra("Name",nameOfAvenger)
                startActivity(intent)
            }else{
                savePreferences(nameOfAvenger)
                intent.putExtra("Name",nameOfAvenger)
                startActivity(intent)
            }
        }else{
            Toast.makeText(this,"Incorrect Credentials",Toast.LENGTH_LONG).show()
        }
    }
    lateinit var etMobileNumber: EditText
    lateinit var etPassword: EditText
    lateinit var btnLogin: Button
    lateinit var txtForgotPassword: TextView
    lateinit var txtRegister: TextView
    val validMobileNumber = "0123456789"
    val validPassword = arrayOf("tony","steve","bruce","thanos")
    lateinit var sharedPreferences: SharedPreferences

    constructor(parcel: Parcel) : this() {

    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        sharedPreferences = getSharedPreferences(getString(R.string.preference_file_name),Context.MODE_PRIVATE)

        val isLoggedIn = sharedPreferences.getBoolean("isLoggedIn",false)
        setContentView(R.layout.activity_login)

        if(isLoggedIn){
            val intent = Intent(this,AvengersActivity::class.java)
            startActivity(intent)
            finish()
        }

        title = "Log In"

        etMobileNumber = findViewById(R.id.etMobileNumber)
        etPassword = findViewById(R.id.etPassword)
        btnLogin = findViewById(R.id.btnLogin)
        txtForgotPassword = findViewById(R.id.txtForgotPassword)
        txtRegister = findViewById(R.id.txtRegister)

        btnLogin.setOnClickListener(this)
//        btnLogin.setOnClickListener{
//            Toast.makeText(this,"We clicked on button to see tha toast",Toast.LENGTH_LONG).show()
//        }
    }

    override fun onPause() {
        super.onPause()
        finish()
    }

    fun savePreferences(title: String){
        sharedPreferences.edit().putBoolean("isLoggedIn",true).apply()
        sharedPreferences.edit().putString("Title",title).apply()
    }
}
