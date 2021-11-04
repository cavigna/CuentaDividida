package com.example.cuentadividida.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.ViewParent
import androidx.recyclerview.widget.RecyclerView
import com.example.cuentadividida.databinding.ItemRowBinding
import com.example.cuentadividida.model.Consumo

class ConsumoViewHolder(itemView:View):RecyclerView.ViewHolder(itemView) {

    val binding: ItemRowBinding = ItemRowBinding.bind(itemView)

    companion object{
        fun create(parent: ViewGroup):ConsumoViewHolder{
            val layoutInflaterB = LayoutInflater.from(parent.context)
            val binding =ItemRowBinding.inflate(layoutInflaterB, parent, false)
            return ConsumoViewHolder(binding.root)

        }
    }
    fun unirDatos(consumo: Consumo){
        with(binding){
            tvRowNombreEvento.text = consumo.nombreEvento
            tvRowNombreItem.text= consumo.nombre
            //tvRowTotal.text = con
        }

    }

}
