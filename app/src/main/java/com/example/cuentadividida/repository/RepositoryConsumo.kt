package com.example.cuentadividida.repository

import com.example.cuentadividida.dao.ConsumoDao
import com.example.cuentadividida.model.Consumo
import kotlinx.coroutines.flow.Flow

class RepositoryConsumo( private val dao: ConsumoDao) {

    val listar: Flow<List<Consumo>> = dao.listarTodos()

    fun agregar(consumo: Consumo){
        dao.agregarConsumo(consumo)
    }
}