package com.example.cuentadividida.adapters

import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import com.example.cuentadividida.model.Consumo

class EventoListAdapter:ListAdapter<Consumo, ConsumoViewHolder>(ConsumoComparator()) {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ConsumoViewHolder {
        return ConsumoViewHolder.create(parent)
    }

    override fun onBindViewHolder(holder: ConsumoViewHolder, position: Int) {
        val consumo = getItem(position)

        holder.unirDatos(consumo)
    }


}

class ConsumoComparator : DiffUtil.ItemCallback<Consumo>(){
    override fun areItemsTheSame(oldItem: Consumo, newItem: Consumo): Boolean {
        return oldItem == newItem
    }

    override fun areContentsTheSame(oldItem: Consumo, newItem: Consumo): Boolean {
        return  oldItem.id == newItem.id
    }

}
