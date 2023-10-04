package com.example.paulina.database.repositoryes

import android.util.Log
import androidx.lifecycle.LiveData
import com.example.paulina.database.Entity.RegisterEntity
import com.example.paulina.database.EntityDao.RegisterDatabaseDao

class RegisterRepository(private val dao: RegisterDatabaseDao) {

    val users = dao.getAllUsers()
    suspend fun insert(user: RegisterEntity) {
        return dao.insert(user)
    }

    suspend fun getUserName(userName: String): RegisterEntity?{
        Log.i("MYTAG", "inside Repository Getusers fun ")
        return dao.getUsername(userName)
    }

    fun getNumFiles(): LiveData<Int?>? {
        return dao.getCount()
    }

    /*suspend fun Existe(us|erId: Int): Int {
        return dao.Existe(userId)
    }*/
    //suspend fun deleteAll(): Int {
    //    return dao.deleteAll()
    //}

}