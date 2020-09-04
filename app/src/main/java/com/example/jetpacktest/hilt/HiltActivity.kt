package com.example.jetpacktest.hilt

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.example.jetpacktest.R
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

//@AndroidEntryPoint
class HiltActivity : AppCompatActivity() {

    @Inject
    lateinit var name: String

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_hilt)
        Glide.with(applicationContext).load("https://img03.sogoucdn.com/net/a/04/link?url=https%3A%2F%2Fi02piccdn.sogoucdn.com%2Fd6c350b879b1e013&appid=122")
            .apply(RequestOptions.errorOf(R.drawable.ic_launcher_background))
            .into(findViewById(R.id.imageView))

    }
}