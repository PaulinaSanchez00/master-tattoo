package com.example.paulina.database.Entity

import androidx.annotation.NonNull
import androidx.room.*
import org.jetbrains.annotations.NotNull

@Entity(tableName = "INFO",
    foreignKeys = arrayOf(
        ForeignKey(entity = RegisterEntity::class,
        parentColumns =["userId"],
        childColumns = ["ID_USR"])), indices = [Index(value=["ID_USR"])])
data class INFO(
    @PrimaryKey(autoGenerate = true)

    @ColumnInfo(name = "ID") val ID:Int=0,

    @ColumnInfo(name = "ID_USR") val ID_USR:Int?,

    @ColumnInfo(name = "CONTACTO") val CONTACTO:String?,

    @ColumnInfo(name = "EXISTE") val EXISTE:Int?
)