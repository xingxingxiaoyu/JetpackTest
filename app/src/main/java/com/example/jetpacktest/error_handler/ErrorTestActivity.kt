package com.example.jetpacktest.error_handler

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Debug
import android.view.View
import com.example.jetpacktest.R
import java.io.File

class ErrorTestActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_error_test)
        findViewById<View>(R.id.button_main).setOnClickListener { throw RuntimeException() }
        findViewById<View>(R.id.button_child).setOnClickListener {
            Thread {
                Debug.dumpHprofData(cacheDir.absolutePath + File.separator + "a.log")
                throw RuntimeException()
            }.start()
        }


    }
}