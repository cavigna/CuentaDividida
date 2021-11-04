package com.example.cuentadividida.dao

import androidx.lifecycle.MutableLiveData
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import com.example.cuentadividida.model.Consumo
import com.example.cuentadividida.model.Evento
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.selects.select


@Dao
interface ConsumoDao {

    @Insert
    suspend fun agregarConsumo(consumo: Consumo)

    @Delete
    suspend fun borrarConsumo(consumo: Consumo)

    @Query("DELETE FROM consumo")
    suspend fun deleteAll()

    @Query("select * from consumo")
    fun listarTodos(): Flow<List<Consumo>>

    @Query("select * from consumo where nombre_evento =:nombreEvento")
    fun listadoPorEvento(nombreEvento:String): Flow<List<Consumo>>

    @Query("select nombre_evento from consumo")
    fun listadoNombreDeEventos():Flow<List<String>>


    /*=================== EVENTOS ======================================*/

    @Insert
    suspend fun agregarEvento(evento: Evento)

    @Delete
    suspend fun borrarEvento(evento: Evento)



    @Query("select nombre_evento from evento")
    fun listadoEventos(): Flow<List<String>>


}