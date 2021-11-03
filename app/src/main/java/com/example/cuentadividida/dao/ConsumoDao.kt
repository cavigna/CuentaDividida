package com.example.cuentadividida.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import com.example.cuentadividida.model.Consumo
import kotlinx.coroutines.flow.Flow

@Dao
interface ConsumoDao {

    @Insert
    fun agregarConsumo(consumo: Consumo)

    @Delete
    fun borrarConsumo(consumo: Consumo)

    @Query("DELETE FROM consumo")
    fun deleteAll()

    @Query("select * from consumo")
    fun listarTodos(): Flow<List<Consumo>>
}