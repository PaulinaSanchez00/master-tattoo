package com.example.paulina.database.Entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.Index
import androidx.room.PrimaryKey

@Entity(tableName = "Register_users_table",indices = [Index(
    value = ["user_name"],
    unique = true
)])
data class RegisterEntity(
    @PrimaryKey(autoGenerate = true)
    var userId: Int = 0,

    @ColumnInfo(name = "user_name")
    var userName:String,

    @ColumnInfo(name = "password_text")
    var passwrd: String
)