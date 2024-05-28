package com.fourprograms.safeguardpro.view.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.fourprograms.safeguardpro.databinding.ListItemEpiBinding
import com.fourprograms.safeguardpro.service.model.Epi

class EpiAdapter(
    epis: List<Epi>?,
    private val clickListListener: (Epi) -> Unit
) : RecyclerView.Adapter<EpiAdapter.EpiViewHolder>() {

    private var epiList: List<Epi> = arrayListOf()

    class EpiViewHolder(private val binding: ListItemEpiBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(
            epi: Epi,
            clickListListener: (Epi) -> Unit
        ) {
            binding.root.setOnClickListener {
                clickListListener(epi)
            }
        }
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): EpiViewHolder {
        val listItemEpiBinding = ListItemEpiBinding.inflate(
            LayoutInflater.from(parent
            .context), parent, false)
        return EpiViewHolder(listItemEpiBinding)
    }

    override fun getItemCount(): Int {
        return epiList.count()
    }

    override fun onBindViewHolder(
        holder: EpiViewHolder,
        position: Int
    ) {
        holder.bind(epiList[position], clickListListener)
    }

    fun updateEpis(list: List<Epi>){
        epiList = list
        notifyDataSetChanged()
    }
}