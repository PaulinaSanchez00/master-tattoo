package com.example.paulina.database.EntityDao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.example.paulina.database.Entity.TATOOTIPE

@Dao
interface TATOOTIPEDao {
    @Insert
    fun insert(TATOO: TATOOTIPE)

    @Query("SELECT * FROM TATOOTIPE WHERE EXISTE= :EXISTE ORDER BY STYLE ASC")
    fun vista(EXISTE:Int):List<TATOOTIPE>
    @Query("SELECT PRECIO FROM TATOOTIPE WHERE STYLE=:STYLE")
    fun getPrecio(STYLE: String):Double

    @Query("UPDATE TATOOTIPE SET EXISTE = 0 WHERE STYLE=:STYLE")
    fun ocultar(STYLE:String):Int

    @Query("UPDATE TATOOTIPE SET EXISTE = 1 WHERE STYLE=:STYLE")
    fun mostrar(STYLE:String):Int

    @Query("SELECT ID FROM TATOOTIPE WHERE STYLE=:STYLE")
    fun getID(STYLE:String):Int

    @Query("UPDATE TATOOTIPE SET PRECIO=:PRECIO WHERE STYLE=:STYLE")
    fun getupdatePrecio(PRECIO: Double,STYLE: String):Int
}