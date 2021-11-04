package com.example.cuentadividida.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.sqlite.db.SupportSQLiteDatabase
import com.example.cuentadividida.dao.ConsumoDao
import com.example.cuentadividida.model.Consumo
import com.example.cuentadividida.model.Evento
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch


@Database(entities = [Consumo::class, Evento::class], version = 1, exportSchema = false)
abstract class BaseDeDatos : RoomDatabase() {
    abstract fun dao(): ConsumoDao

    companion object {

        @Volatile
        private var INSTANCE: BaseDeDatos? = null

        fun getDataBase(context: Context, scope: CoroutineScope): BaseDeDatos {

            return INSTANCE ?: synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    BaseDeDatos::class.java,
                    "consumo_database"
                ).addCallback(ConsumoDbCallback(scope)).build()
                INSTANCE = instance

                instance
            }
        }
    }


    private class ConsumoDbCallback(
        private val scope: CoroutineScope
    ) : RoomDatabase.Callback() {

        override fun onCreate(db: SupportSQLiteDatabase) {
            super.onCreate(db)

            INSTANCE?.let { database ->
                scope.launch {
                    val dao = database.dao()

                    var evento = Evento("Evento 42")
                    var consumo = Consumo(evento.nombreEvento, "Toalla", 1, 10)
                    dao.agregarEvento(evento)
                    dao.agregarConsumo(consumo)

                    evento = Evento("Dia de la Toalla")
                    consumo = Consumo(evento.nombreEvento, "cerveza", 5, 20)
                    dao.agregarEvento(evento)
                    dao.agregarConsumo(consumo)


                }
            }
        }

    }
}

