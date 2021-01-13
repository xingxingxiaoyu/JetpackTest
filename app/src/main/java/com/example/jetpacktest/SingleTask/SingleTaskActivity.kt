package com.example.jetpacktest.SingleTask

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.jetpacktest.R
import kotlinx.android.synthetic.main.activity_single_task.*

class SingleTaskActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_single_task)
        button.setOnClickListener {
            val intent = Intent(this, EmptyActivity::class.java)
            intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
            startActivity(intent)
        }
    }

    override fun onResume() {
        super.onResume()
        Toast.makeText(this, "" + this.toString(), Toast.LENGTH_LONG).show()
    }

}