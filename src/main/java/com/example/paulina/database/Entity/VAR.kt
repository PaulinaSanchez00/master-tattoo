package com.example.paulina.database.Entity

import androidx.room.*


@Entity(tableName = "VAR", foreignKeys = arrayOf(
    ForeignKey(entity = TATOOTIPE::class,
    parentColumns =["ID"],
    childColumns = ["ID_TATOO"]))
,indices = [Index(value=["ID_TATOO"])])
data class VAR(
        @PrimaryKey(autoGenerate = true)
        @ColumnInfo(name = "ID")  val ID:Int=0,

        @ColumnInfo(name = "ID_TATOO") val ID_TATOO:Int?,

        @ColumnInfo(name = "CM") val CM:Double?,

        @ColumnInfo(name = "CM_COLOR") val CM_COLOR:Double?,
        @ColumnInfo(name = "CM_NEGRO") val CM_NEGRO:Double?,
        @ColumnInfo(name = "CM_ESTILO") val CM_ESTILO:Double?,

)
