package org.sopt.hapdongseminar_29th.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import org.sopt.hapdongseminar_29th.databinding.ItemPlusPriceListBinding

class PlusPriceListRVAdapter : RecyclerView.Adapter<PlusPriceListRVAdapter.PlusPriceListViewHolder>() {
    val priceList = mutableListOf<String>()

    class PlusPriceListViewHolder (private val binding : ItemPlusPriceListBinding) : RecyclerView.ViewHolder(binding.root){
        fun onBind(data: String) {
//            binding.tvFilterName.text = data
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PlusPriceListViewHolder {
        val binding = ItemPlusPriceListBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return PlusPriceListViewHolder(binding)
    }

    override fun onBindViewHolder(holder: PlusPriceListViewHolder, position: Int) {
        holder.onBind(priceList[position])
    }

    override fun getItemCount(): Int = priceList.size
}