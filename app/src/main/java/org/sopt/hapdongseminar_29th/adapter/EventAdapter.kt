package org.sopt.hapdongseminar_29th.adapter


import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import org.sopt.hapdongseminar_29th.databinding.ItemHomeEventBinding

class EventAdapter: RecyclerView.Adapter<EventAdapter.ViewHolder>(){

    val eventurlList=mutableListOf<String>()

    inner class ViewHolder(private val binding:ItemHomeEventBinding):RecyclerView.ViewHolder(binding.root) {
        fun bind(eventurl: String){
            Glide.with(itemView?.context)
                .load(eventurl)
                .into(binding.ivEvent)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): EventAdapter.ViewHolder {
        val binding=ItemHomeEventBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: EventAdapter.ViewHolder, position: Int) {
        holder.bind(eventurlList[position])
    }

    override fun getItemCount()=eventurlList.size
}