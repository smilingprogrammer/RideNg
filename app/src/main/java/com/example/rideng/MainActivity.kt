package com.example.rideng

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.rideng.ui.activity.LoginActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

//        val sharedPref = this.getPreferences(Context.MODE_PRIVATE) ?: return
//        val appUseState = sharedPref.getBoolean(getString())
        moveToLoginActivity()
    }

    private fun moveToLoginActivity(){
        startActivity(Intent(this, LoginActivity::class.java))
        finish()
    }
}