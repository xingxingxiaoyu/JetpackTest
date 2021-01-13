package com.example.jetpacktest.SingleTask

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import com.example.jetpacktest.R

class EmptyActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_empty)

        Handler(Looper.getMainLooper()).postDelayed({
            val intent = Intent(this, SingleTaskActivity::class.java)
            intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
            startActivity(intent)
            finish()

        }, 1000)
    }

    var func: (( String, String, String, String, String, String, String, String, String, String, String, String, String, String, String, String, String, String, String, String, String, String, String, String, String, String, String) -> Unit) =
        { s: String, s1: String, s2: String, s3: String, s4: String, s5: String, s6: String, s7: String, s8: String, s9: String, s10: String, s11: String, s12: String, s13: String, s14: String, s15: String, s16: String, s17: String, s18: String, s19: String, s20: String, s21: String, s22: String, s23: String, s24: String, s25: String, s26: String ->

        }
}