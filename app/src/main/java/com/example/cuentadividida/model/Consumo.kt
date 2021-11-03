package com.example.cuentadividida.model


import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity()
data class Consumo(

    val nombre: String,
    val cantidad: Int,
    val precio: Int,
    val total: Int = cantidad * precio,
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,


    )