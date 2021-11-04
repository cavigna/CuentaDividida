package com.example.cuentadividida.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.cuentadividida.dao.ConsumoDao
import com.example.cuentadividida.model.Consumo
import com.example.cuentadividida.model.Evento


@Database(entities = [Consumo::class, Evento::class], version = 1, exportSchema = false)
abstract class BaseDeDatos : RoomDatabase(){
    abstract fun dao() : ConsumoDao

    companion object{

        @Volatile
        private var INSTANCE : BaseDeDatos? = null

        fun getDataBase(context: Context) :BaseDeDatos {

            return INSTANCE ?: synchronized(this){
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    BaseDeDatos::class.java,
                    "consumo_database"
                ).build()
                INSTANCE = instance

                instance
            }
        }
    }

}