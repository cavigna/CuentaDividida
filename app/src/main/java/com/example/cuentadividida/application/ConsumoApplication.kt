package com.example.cuentadividida.application

import android.app.Application
import com.example.cuentadividida.db.BaseDeDatos
import com.example.cuentadividida.repository.RepositoryConsumo
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.SupervisorJob

class ConsumoApplication: Application() {

    val applicationScope = CoroutineScope(SupervisorJob())
    private val database by lazy { BaseDeDatos.getDataBase(this,applicationScope) }
    val repository by lazy{RepositoryConsumo(database.dao())}
}