package com.example.cuentadividida.repository

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.asLiveData
import com.example.cuentadividida.dao.ConsumoDao
import com.example.cuentadividida.model.Consumo
import com.example.cuentadividida.model.Evento
import kotlinx.coroutines.flow.Flow

class RepositoryConsumo(private val dao: ConsumoDao) {

    val listar: Flow<List<Consumo>> = dao.listarTodos()
    val listadoNombreEvento:Flow<List<String>> = dao.listadoNombreDeEventos()

    val listarEventos: Flow<List<String>> = dao.listadoEventos()


    suspend fun agregarConsumo(consumo: Consumo) {
        dao.agregarConsumo(consumo)
    }




    /*=================== EVENTOS ======================================*/


    fun listadoPorEvento(nombreEvento: String): Flow<List<Consumo>> {
        return dao.listadoPorEvento(nombreEvento)
    }
    suspend fun agregarEvento(evento: Evento) = dao.agregarEvento(evento)

    suspend fun borrarEvento(evento: Evento) = dao.borrarEvento(evento)

}