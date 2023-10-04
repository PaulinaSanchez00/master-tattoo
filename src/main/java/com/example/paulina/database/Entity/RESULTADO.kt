package com.example.paulina.database.Entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "RESULTADO")
data class RESULTADO(
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "ID") val ID:Int=0,
    @ColumnInfo(name="RESUL") val RESUL:Double?
)
