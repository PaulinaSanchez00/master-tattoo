package com.example.paulina.database.EntityDao


import androidx.lifecycle.LiveData
import androidx.room.*
import com.example.paulina.database.Entity.IMG


@Dao
interface IMGDao {
    @Insert
    fun insert(vararg IMG: IMG): List<Long>

    @Query("DELETE FROM IMG WHERE DIR =:DIR AND ID_USR=:ID_USR")
    fun eliminarimg(DIR:Int,ID_USR:Int):Int

    @Query("UPDATE IMG SET DIR=:DIR WHERE DIR=:DIRANT")
    fun modificarimg(DIR:Int,DIRANT:Int):Int

    @Query("SELECT * FROM IMG")
    fun getAll():LiveData<List<IMG>>

    @Query("SELECT * FROM IMG WHERE ID =:ID")
    fun get(ID: Int):LiveData<IMG>

    @Update
    fun update(IMG: IMG)

    @Delete
    fun delete(IMG: IMG)

}
