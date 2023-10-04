package com.example.paulina.database.Entity

import androidx.annotation.NonNull
import androidx.room.*

@Entity(tableName = "TATOOTIPE",indices = [Index(value = ["STYLE"], unique = true)])
data class TATOOTIPE(
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "ID")  val ID:Int=0,
    @ColumnInfo(name = "STYLE") val STYLE:String?,
    @ColumnInfo(name = "PRECIO") val PRECIO:Double?,
    @ColumnInfo(name = "EXISTE") val EXISTE:Int?,

)