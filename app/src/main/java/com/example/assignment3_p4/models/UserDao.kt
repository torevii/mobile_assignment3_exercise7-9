package com.example.assignment3_p4.dao

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.example.assignment3_p4.models.User

@Dao
interface UserDao {
    @Query("SELECT * FROM User")
    fun getAllUsers(): LiveData<List<User>>

    @Insert
    suspend fun insert(user: User)
}
