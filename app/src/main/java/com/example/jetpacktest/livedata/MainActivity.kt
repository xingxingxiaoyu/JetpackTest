package com.example.jetpacktest.livedata

import android.annotation.SuppressLint
import android.content.Context
import android.content.res.Configuration
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.lifecycle.*
import androidx.lifecycle.ViewModelProvider.*
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.Adapter
import androidx.room.Room
import com.example.jetpacktest.R
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import java.lang.Exception
import java.util.*
import kotlin.collections.ArrayList


class MainActivity : AppCompatActivity() {
    val TAG = "MainActivity"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        Log.d(TAG, "onCreate: " + this)

        val db = Room.databaseBuilder(applicationContext, AppDatabase::class.java, "database-name")
            .build()
        var random = Random()

        var users = ArrayList<User?>()
        val testAdapter = TestAdapter(users, this)
        recycler_view.adapter = testAdapter
        recycler_view.layoutManager = LinearLayoutManager(this)
        button_add.setOnClickListener {
            GlobalScope.launch {
                db.userDao().insertAll(User("lihua", random.nextInt().toString()))
            }
        }

        val userViewModel = ViewModelProvider(this).get(UserViewModel::class.java)
        AndroidViewModelFactory.getInstance(application).create(UserViewModel::class.java)
        userViewModel.getUsers()
            ?.observe(this@MainActivity, androidx.lifecycle.Observer<List<User?>> { userList ->
                users.clear()
                users.addAll(userList)
                Log.d(TAG, "onCreate: " + users)
                testAdapter.notifyDataSetChanged()
            })

        Log.e(TAG, "onCreate: " + userViewModel.javaClass.name)
        button_refresh.setOnClickListener {
            userViewModel.refreshUser()
        }
//        getLifecycle().addObserver(object : LifecycleEventObserver {
//            override fun onStateChanged(source: LifecycleOwner, event: Lifecycle.Event) {
//                Log.d(TAG, "onStateChanged: " + event)
//                Exception().printStackTrace()
//
//            }
//
//        })

//        (getLifecycle() as LifecycleRegistry).handleLifecycleEvent(Lifecycle.Event.ON_ANY)


        supportFragmentManager.beginTransaction().add(MyFragment(), "test").commit()

    }


    override fun onResume() {
        super.onResume()
        Log.d(TAG, "onResume: " + this)
    }

    class TestAdapter(val users: List<User?>, var context: Context) :
        Adapter<TestAdapter.TestViewHolder>() {
        val TAG = "TestAdapter"
        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TestViewHolder {
            return TestViewHolder(
                LayoutInflater.from(context).inflate(
                    R.layout.item,
                    parent,
                    false
                )
            )
        }

        override fun getItemCount(): Int {
            return users.size
        }

        @SuppressLint("SetTextI18n")
        override fun onBindViewHolder(holder: TestViewHolder, position: Int) {
            holder.tv.text = users[position]?.firstName + " " + users[position]?.lastName
        }

        class TestViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
            var tv: TextView

            init {
                tv = itemView.findViewById(R.id.textView)
            }

        }
    }

    override fun onConfigurationChanged(newConfig: Configuration) {
        super.onConfigurationChanged(newConfig)
        Log.d(TAG, "onConfigurationChanged: ")
    }


}
