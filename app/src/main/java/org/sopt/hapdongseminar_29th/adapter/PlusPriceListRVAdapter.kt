package org.sopt.hapdongseminar_29th.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import org.sopt.hapdongseminar_29th.data.ResponseCategoryData
import org.sopt.hapdongseminar_29th.databinding.ItemPlusPriceListBinding

class PlusPriceListRVAdapter : RecyclerView.Adapter<PlusPriceListRVAdapter.PlusPriceListViewHolder>() {
    val priceList = mutableListOf<ResponseCategoryData.Data>()

    class PlusPriceListViewHolder (private val binding : ItemPlusPriceListBinding) : RecyclerView.ViewHolder(binding.root){
        fun onBind(data: ResponseCategoryData.Data) {
            binding.tvProductName.text = data.itemName
            binding.tvProductPrice.text = "${data.itemPrice.toString()}원"
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