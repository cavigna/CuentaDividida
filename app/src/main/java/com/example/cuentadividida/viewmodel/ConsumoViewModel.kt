package com.example.cuentadividida.viewmodel

import androidx.lifecycle.*
import com.example.cuentadividida.model.Consumo
import com.example.cuentadividida.repository.RepositoryConsumo

import kotlinx.coroutines.launch


class ConsumoViewModel(private val repository: RepositoryConsumo) : ViewModel(){

    val listado : LiveData<List<Consumo>> = repository.listar.asLiveData()

    fun agregar(consumo: Consumo){
        viewModelScope.launch {
            repository.agregar(consumo)
        }
    }
}

class ConsumoViewModelFactory(private val repository: RepositoryConsumo): ViewModelProvider.Factory{
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if(modelClass.isAssignableFrom((ConsumoViewModel::class.java))){
            return  ConsumoViewModel(repository) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }


}


/*
class WordViewModelFactory(private val repository: WordRepository) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(WordViewModel::class.java)) {
            @Suppress("UNCHECKED_CAST")
            return WordViewModel(repository) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}
 */