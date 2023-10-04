package com.example.paulina.database.EntityDao


import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.example.paulina.database.Entity.INFO


@Dao
interface INFODao {
    @Insert
    fun insert(INFOs: INFO)

    @Query("SELECT * FROM INFO WHERE EXISTE=1")
    fun Vista():List<INFO>

    @Query("UPDATE INFO SET CONTACTO=:CONTACTO WHERE ID_USR = :ID_USR AND CONTACTO=:CONTACTOANTE AND ID=:ID")
    fun Update_contact(CONTACTO:String,ID_USR:Int,CONTACTOANTE:String, ID:Int):Int

    @Query("SELECT CONTACTO FROM INFO WHERE ID=:ID")
    fun getContacto(ID: Int):String

    @Query("UPDATE INFO SET CONTACTO=:CONTACTO WHERE ID=:ID")
    fun updateContacto(CONTACTO:String,ID:Int):Int


}