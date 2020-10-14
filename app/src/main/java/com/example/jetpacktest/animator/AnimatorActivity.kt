package com.example.jetpacktest.animator

import android.animation.ValueAnimator
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.example.jetpacktest.R


class AnimatorActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_animator)
        val tv: MyTextView = findViewById(R.id.tv_name)
        tv.setOnClickListener(object : View.OnClickListener {
            override fun onClick(v: View) {
                val valueAnimator = ValueAnimator.ofInt(0, 300).setDuration(2000)
                valueAnimator.addUpdateListener { animation -> v.setTranslationY((animation.animatedValue as Int).toFloat()) }
                valueAnimator.start()
            }
        })
    }
}