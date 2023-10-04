package com.example.paulina.database.EntityDao


import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import com.example.paulina.database.Entity.IMG
import com.example.paulina.database.Entity.RESULTADO


@Dao
interface RESULTADODao {
    @Insert
    fun insert(RESULTADO: RESULTADO)

    @Query("SELECT RESUL FROM RESULTADO")
    fun getResul():Double

    @Query("DELETE FROM RESULTADO")
    fun deleteAll()

}