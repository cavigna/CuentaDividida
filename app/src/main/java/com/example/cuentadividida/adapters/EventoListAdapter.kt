package com.example.cuentadividida.adapters

import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import com.example.cuentadividida.model.Consumo
import com.example.cuentadividida.model.TotalEvento

class EventoListAdapter:ListAdapter<TotalEvento, ConsumoViewHolder>(ConsumoComparator()) {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ConsumoViewHolder {
        return ConsumoViewHolder.create(parent)
    }

    override fun onBindViewHolder(holder: ConsumoViewHolder, position: Int) {
        val totalEvento = getItem(position)
        holder.unirDatos(totalEvento)
    }


}

class ConsumoComparator : DiffUtil.ItemCallback<TotalEvento>(){
    override fun areItemsTheSame(oldItem: TotalEvento, newItem: TotalEvento): Boolean {
        return oldItem == newItem
    }

    override fun areContentsTheSame(oldItem: TotalEvento, newItem: TotalEvento): Boolean {
        return  oldItem.nombreEvento == newItem.nombreEvento
    }

}
