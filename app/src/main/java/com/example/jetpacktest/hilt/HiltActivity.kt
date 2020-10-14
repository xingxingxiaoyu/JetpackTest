package com.example.jetpacktest.hilt

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.example.jetpacktest.R
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject
import kotlin.reflect.KClass

//@AndroidEntryPoint
class HiltActivity : AppCompatActivity() {

    @Inject
    lateinit var name: String

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_hilt)

    }

}

val TAG = "HiltActivity"

fun String.logI() {
    Log.d(TAG, "logI: " + this)
}

fun <T : Any> KClass<T>.get(owner: String? = null, fieldName: String): Object {
    var declaredField = java.getDeclaredField(fieldName)
    return declaredField.get(owner) as Object
}