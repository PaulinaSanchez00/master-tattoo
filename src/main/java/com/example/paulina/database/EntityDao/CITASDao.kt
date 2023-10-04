package com.example.paulina.database.EntityDao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.example.paulina.database.Entity.CITAS


@Dao
interface CITASDao {
    @Insert
    fun insert(CITAS: CITAS)

    @Query("SELECT * FROM CITAS WHERE ID_USR=:ID_USR AND ESTATUS=0")
    fun viewCita(ID_USR:Int):List<CITAS>

    @Query("UPDATE CITAS SET ESTATUS=:ESTATUS WHERE TELEFONO=:TELEFONO")
    fun cambiarEstatus(ESTATUS:Int,TELEFONO:Int)

    @Query("SELECT ESTATUS FROM CITAS WHERE TELEFONO=:TELEFONO")
    fun getEstatus(TELEFONO:Int):Int


}