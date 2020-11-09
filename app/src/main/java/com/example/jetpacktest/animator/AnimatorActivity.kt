package com.example.jetpacktest.animator

import android.animation.ValueAnimator
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.os.Message
import android.util.Log
import android.view.View
import android.view.WindowManager
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.jetpacktest.R


class AnimatorActivity : AppCompatActivity() {
    val TAG = "AnimatorActivity"
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

        val toast = Toast.makeText(this, "测试的", Toast.LENGTH_LONG)
        var mTN = getField(Toast::class.java, "mTN", toast)
        var mPresenter = getField("android.widget.Toast.TN", "mPresenter", mTN)
        var mParams = getField("android.widget.ToastPresenter", "mParams", mPresenter)

        setField("android.view.WindowManager.LayoutParams", "hideTimeoutMilliseconds", mParams, 100000)

        toast.show()

    }

    fun getField(clazz: Class<*>?, fieldName: String, obj: Any?): Any? {
        return clazz?.getDeclaredField(fieldName)?.get(obj)
    }

    fun getField(className: String, fieldName: String, obj: Any?): Any? {
        return getField(Class.forName(className), fieldName, obj)
    }

    fun setField(className: String, fieldName: String, obj: Any?, value: Any): Any? {
        return Class.forName(className).getDeclaredField(fieldName).set(obj, value)
    }


}