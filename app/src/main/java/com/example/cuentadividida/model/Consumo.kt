package com.example.cuentadividida.model


import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey

@Entity(foreignKeys = [ForeignKey(
    entity = Evento::class,
    parentColumns = ["nombre_evento"],
    childColumns =  ["nombre_evento"],
    onDelete = ForeignKey.CASCADE
)])
data class Consumo(

    @ColumnInfo(name = "nombre_evento")
    var nombreEvento:String = "",
    val nombre: String,
    val cantidad: Int,
    val precio: Int,
    val totalItem: Int = cantidad * precio,
    val totales: Int =0,
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,


    )