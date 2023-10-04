package com.example.paulina.database.Entity

import androidx.room.*
import com.example.paulina.database.Entity.RegisterEntity
import java.io.Serializable

@Entity(tableName = "IMG",foreignKeys = arrayOf(
    ForeignKey(entity = RegisterEntity::class,
        parentColumns =["userId"],
        childColumns = ["ID_USR"])
),indices = [Index(value = ["ID_USR"])])
data class IMG (
    @ColumnInfo(name = "ID_USR") val ID_USR: Int,
    @ColumnInfo(name = "DIR") val DIR: Int,
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "ID") var ID: Int=0
    ) : Serializable
