package org.sopt.hapdongseminar_29th.Adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import org.sopt.hapdongseminar_29th.Product
import org.sopt.hapdongseminar_29th.databinding.ItemPlusPriceListBinding

class PlusPriceListRVAdapter : RecyclerView.Adapter<PlusPriceListRVAdapter.PlusPriceListViewHolder>() {
    val priceList = mutableListOf<Product>()

    class PlusPriceListViewHolder (private val binding : ItemPlusPriceListBinding) : RecyclerView.ViewHolder(binding.root){
        fun onBind(data: Product) {
            binding.tvProductName.text = data.name
            binding.tvProductPrice.text = "${data.price.toString()}원"
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