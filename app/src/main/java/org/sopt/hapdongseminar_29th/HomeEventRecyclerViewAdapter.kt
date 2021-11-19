package org.sopt.hapdongseminar_29th

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import org.sopt.hapdongseminar_29th.databinding.ListItemBinding

class HomeEventRecyclerViewAdapter(): RecyclerView.Adapter<HomeEventRecyclerViewAdapter.ViewHolder>() {

    var datalist=mutableListOf<EventData>()

    inner class ViewHolder(private val binding: ListItemBinding):RecyclerView.ViewHolder(binding.root){

        fun bind(eventData: EventData){
            Glide.with(itemView).load(eventData.eventImg).into(binding.homeImg) //TODO 맞음?
            binding.homeExplain.text=eventData.eventExplain
            binding.homeTitle.text=eventData.eventTitle
        }
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): HomeEventRecyclerViewAdapter.ViewHolder {
        val binding=ListItemBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: HomeEventRecyclerViewAdapter.ViewHolder, position: Int) {
        holder.bind(datalist[position])
    }

    override fun getItemCount(): Int =datalist.size



}
