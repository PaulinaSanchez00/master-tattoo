package com.example.paulina.database.EntityDao


import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.example.paulina.database.Entity.ESTUDIO


@Dao
interface ESTUDIODao {
    @Insert
    fun insert(ESTUDIO: ESTUDIO)
    @Query("SELECT*FROM ESTUDIO")
    fun getInfo():List<ESTUDIO>
    @Query("UPDATE ESTUDIO SET NOMBRE_ESTUDIO=:NOMBRE_ESTUDIO, DIRECCION=:DIRECCION, DESCRIPCION=:DESCRIPCION, LINK=:LINK WHERE ID=:ID")
    fun updateInfo(NOMBRE_ESTUDIO:String,DIRECCION:String,DESCRIPCION:String,LINK:String,ID: Int):Int

    @Query("UPDATE ESTUDIO SET LOGO=:LOGO WHERE ID=:ID")
    fun updateInfo2(LOGO: String, ID: Int):Int

    @Query("SELECT NOMBRE_ESTUDIO FROM ESTUDIO WHERE ID=:ID")
    fun getNombre(ID: Int):String
    @Query("SELECT DIRECCION FROM ESTUDIO WHERE ID=:ID")
    fun getDireccion(ID: Int):String
    @Query("SELECT LOGO FROM ESTUDIO WHERE ID=:ID")
    fun getLogo(ID: Int):String
    @Query("SELECT DESCRIPCION FROM ESTUDIO WHERE ID=:ID")
    fun getDescripcion(ID: Int):String
    @Query("SELECT LINK FROM ESTUDIO WHERE ID=:ID")
    fun getLink(ID: Int):String


}