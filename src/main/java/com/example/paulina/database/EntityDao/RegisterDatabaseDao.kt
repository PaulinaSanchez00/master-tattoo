package com.example.paulina.database.EntityDao

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.example.paulina.database.Entity.RegisterEntity

@Dao
interface RegisterDatabaseDao {

    @Insert
    suspend fun insert(register: RegisterEntity)

    //@Delete
    //suspend  fun deleteSubscriber(register: RegisterEntity):Int

    @Query("SELECT * FROM Register_users_table ORDER BY userId DESC")
    fun getAllUsers(): LiveData<List<RegisterEntity>>

    @Query("SELECT * FROM Register_users_table WHERE user_name LIKE :userName")
    suspend fun getUsername(userName: String): RegisterEntity?

    @Query("SELECT count(userId) FROM Register_users_table")
    open fun getCount(): LiveData<Int?>?

}