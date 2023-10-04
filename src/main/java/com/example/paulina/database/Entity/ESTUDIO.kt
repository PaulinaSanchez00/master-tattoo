package com.example.paulina.database.Entity
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "Estudio")
data class ESTUDIO(
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "ID") val ID:Int=0,
    @ColumnInfo(name="NOMBRE_ESTUDIO") val NOMBRE_ESTUDIO:String?,
    @ColumnInfo(name = "DIRECCION") val DIRECCION:String?,
    @ColumnInfo(name = "DESCRIPCION") val DESCRIPCION:String?,
    @ColumnInfo(name = "LINK") val LINK:String?,
    @ColumnInfo(name = "Logo")val Logo:String?,
)