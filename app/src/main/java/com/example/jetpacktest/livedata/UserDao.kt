package com.example.jetpacktest.livedata

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query

/**
 * 描述信息：
 *
 * @author xuyu
 * @date 2020/2/27
 */
@Dao
interface UserDao {
    @get:Query("SELECT * FROM user")
    val all: LiveData<List<User>>

    @Query("SELECT * FROM user WHERE uid IN (:userIds)")
    fun loadAllByIds(userIds: IntArray?): LiveData<List<User?>>

    @Query(
        "SELECT * FROM user WHERE first_name LIKE :first AND " +
                "last_name LIKE :last LIMIT 1"
    )
    suspend fun findByName(
        first: String?,
        last: String?
    ): User?

    @Insert
    fun insertAll(vararg users: User?)

    @Delete
    fun delete(user: User?)
}