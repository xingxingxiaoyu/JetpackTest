package com.example.jetpacktest.livedata

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.jetpacktest.BaseApplication
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

/**
 * 描述信息：
 *
 * @author xuyu
 * @date 2020/2/27
 */
class UserViewModel : ViewModel() {


    val TAG = "UserViewModel"
    private var users: LiveData<List<User>>? = null

    fun getUsers(): LiveData<List<User>>? {
        users = BaseApplication.getDataBase().userDao().all
        return users
    }

    fun refreshUser() {
        Log.d(TAG, "refreshUser: " + BaseApplication.getDataBase().userDao().all)
        //就是说，我想在这里吧查出来的数据，放到users里，那样就可以直接在界面上看到了
//        users.value=xxx
    }


}