package com.example.cuentadividida.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.ViewParent
import androidx.recyclerview.widget.RecyclerView
import com.example.cuentadividida.databinding.ItemRowBinding
import com.example.cuentadividida.model.Consumo
import com.example.cuentadividida.model.TotalEvento

class ConsumoViewHolder(itemView:View):RecyclerView.ViewHolder(itemView) {

    val binding: ItemRowBinding = ItemRowBinding.bind(itemView)

    companion object{
        fun create(parent: ViewGroup):ConsumoViewHolder{
            val layoutInflaterB = LayoutInflater.from(parent.context)
            val binding =ItemRowBinding.inflate(layoutInflaterB, parent, false)
            return ConsumoViewHolder(binding.root)

        }
    }
    fun unirDatos(totalEvento: TotalEvento){
        with(binding){
            tvRowNombreEvento.text = totalEvento.nombreEvento
            tvRowNombreItem.text= totalEvento.total.toString()
            //tvRowTotal.text = con
        }

    }

}
