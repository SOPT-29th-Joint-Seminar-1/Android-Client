package org.sopt.hapdongseminar_29th.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import org.sopt.hapdongseminar_29th.databinding.ItemPlusFilterBinding

class PlusFilterRVAdapter : RecyclerView.Adapter<PlusFilterRVAdapter.PlusFilterViewHolder>() {
    val filterList = mutableListOf<String>()

    class PlusFilterViewHolder (private val binding : ItemPlusFilterBinding) : RecyclerView.ViewHolder(binding.root){
        fun onBind(data: String) {
            binding.tvFilterName.text = data
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PlusFilterViewHolder {
        val binding = ItemPlusFilterBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return PlusFilterViewHolder(binding)
    }

    override fun onBindViewHolder(holder: PlusFilterViewHolder, position: Int) {
        holder.onBind(filterList[position])
    }

    override fun getItemCount(): Int = filterList.size
}