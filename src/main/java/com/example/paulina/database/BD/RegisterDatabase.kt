package com.example.paulina.database.BD

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.paulina.database.Entity.IMG
import com.example.paulina.database.Entity.*
import com.example.paulina.database.EntityDao.*


@Database(entities = [
    RegisterEntity::class,
    CITAS::class,
    TATOOTIPE::class,
    VAR::class,
    IMG::class,
    RESULTADO::class,
    ESTUDIO::class,
    INFO::class], version = 2, exportSchema = false)
abstract class RegisterDatabase : RoomDatabase() {

    abstract fun IMG(): IMGDao

    abstract val registerDatabaseDao: RegisterDatabaseDao
    abstract val CITASDao: CITASDao
    abstract val TATOOTIPEDao:TATOOTIPEDao
    abstract val VARDao: VARDao
    abstract val ESTUDIODao: ESTUDIODao
    abstract val INFODao: INFODao
    abstract val RESULTADODao: RESULTADODao

    companion object {

        @Volatile
        private var INSTANCE: RegisterDatabase? = null


        fun getInstance(context: Context): RegisterDatabase {
            synchronized(this) {

                var instance = INSTANCE

                if (instance == null) {
                    instance = Room.databaseBuilder(
                        context.applicationContext,
                        RegisterDatabase::class.java,
                        "user_details_database"
                    )
                        .fallbackToDestructiveMigration()
                        .build()

                    INSTANCE = instance
                }
                return instance
            }
        }
    }
}

