package com.example.paulina.database.EntityDao


import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.example.paulina.database.Entity.VAR


@Dao
interface VARDao {
    @Insert
    fun Insert(VAR: VAR)
    @Query("SELECT * FROM VAR WHERE ID_TATOO=:ID_TATOO")
    fun getVariables(ID_TATOO:Int):List<VAR>
    @Query("SELECT CM FROM VAR WHERE ID_TATOO=:ID_TATOO")
    fun getCM(ID_TATOO:Int):Double
    @Query("SELECT CM_COLOR FROM VAR WHERE ID_TATOO=:ID_TATOO")
    fun getCM_COlOR(ID_TATOO:Int):Double
    @Query("SELECT CM_NEGRO FROM VAR WHERE ID_TATOO=:ID_TATOO")
    fun getCM_NEGRO(ID_TATOO:Int):Double
    @Query("SELECT CM_ESTILO FROM VAR WHERE ID_TATOO=:ID_TATOO")
    fun getCM_ESTILO(ID_TATOO:Int):Double
}