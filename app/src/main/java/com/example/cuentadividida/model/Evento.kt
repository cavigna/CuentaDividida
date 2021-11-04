package com.example.cuentadividida.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Evento(
    @PrimaryKey
    @ColumnInfo(name = "nombre_evento")
    val nombreEvento: String
)
