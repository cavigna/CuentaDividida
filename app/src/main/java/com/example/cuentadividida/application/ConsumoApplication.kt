package com.example.cuentadividida.application

import android.app.Application
import com.example.cuentadividida.db.BaseDeDatos
import com.example.cuentadividida.repository.RepositoryConsumo

class ConsumoApplication: Application() {

    val database by lazy { BaseDeDatos.getDataBase(this) }
    val repository by lazy{RepositoryConsumo(database.dao())}
}