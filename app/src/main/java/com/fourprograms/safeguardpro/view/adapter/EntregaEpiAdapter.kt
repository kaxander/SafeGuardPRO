package com.fourprograms.safeguardpro.view.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.fourprograms.safeguardpro.databinding.ListItemEntregaEpiBinding
import com.fourprograms.safeguardpro.service.model.EntregaEpi


class EntregaEpiAdapter(
    entregaEpis: List<EntregaEpi>?,
    private val clickListListener: (EntregaEpi) -> Unit
) : RecyclerView.Adapter<EntregaEpiAdapter.EntregaEpiViewHolder>() {

    private var entregaEntregaEpiList: List<EntregaEpi> = arrayListOf()

    class EntregaEpiViewHolder(private val binding: ListItemEntregaEpiBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(
            entregaEntregaEpi: EntregaEpi,
            clickListListener: (EntregaEpi) -> Unit
        ) {
            binding.root.setOnClickListener {
                clickListListener(entregaEntregaEpi)
            }
        }
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): EntregaEpiViewHolder {
        val listItemEntregaEpiBinding = ListItemEntregaEpiBinding.inflate(
            LayoutInflater.from(parent
                .context), parent, false)
        return EntregaEpiViewHolder(listItemEntregaEpiBinding)
    }

    override fun getItemCount(): Int {
        return entregaEntregaEpiList.count()
    }

    override fun onBindViewHolder(
        holder: EntregaEpiViewHolder,
        position: Int
    ) {
        holder.bind(entregaEntregaEpiList[position], clickListListener)
    }

    fun updateEntregaEpis(list: List<EntregaEpi>){
        entregaEntregaEpiList = list
        notifyDataSetChanged()
    }
}