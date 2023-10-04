package com.example.paulina.database.Entity

import androidx.annotation.NonNull
import androidx.room.*
import org.jetbrains.annotations.NotNull

@Entity(tableName = "CITAS",
    foreignKeys = arrayOf(
    ForeignKey(entity = RegisterEntity::class,
    parentColumns =["userId"],
    childColumns = ["ID_USR"])), indices = [Index(value = ["ID_USR","TELEFONO"], unique = true)])
data class CITAS(
    @PrimaryKey(autoGenerate = true)

    @ColumnInfo(name = "ID") val ID:Int=0,

    @ColumnInfo(name = "ID_USR")val ID_USR:Int?,

    @ColumnInfo(name = "ZONA") val ZONA:String?,

    @ColumnInfo(name = "TAMANO")val TAMANO:String?,

    @ColumnInfo(name = "ESTILO") val ESTILO:String?,

    @ColumnInfo(name = "COLORES")val COLORES:String?,

    @ColumnInfo(name = "TONO_PIEL") val TONO_PIEL:String?,

    @ColumnInfo(name ="FECHA") val FECHA:String?,

    @ColumnInfo(name="HORA") val HORA:String?,
    @ColumnInfo(name = "COMENTARIO") val COMENTARIO:String?,

    @ColumnInfo(name = "TELEFONO") val TELEFONO:String?,

    @ColumnInfo(name = "ESTATUS") val ESTATUS:Int?
)
