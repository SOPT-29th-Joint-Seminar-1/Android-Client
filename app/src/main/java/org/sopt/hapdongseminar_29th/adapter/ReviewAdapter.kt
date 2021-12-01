package org.sopt.hapdongseminar_29th.adapter

import android.view.View
import android.widget.AdapterView
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter
import androidx.viewpager2.adapter.FragmentViewHolder
import org.sopt.hapdongseminar_29th.View_Review.ReviewFragment1
import org.sopt.hapdongseminar_29th.data.ResponseReviewGetData

class ReviewAdapter(fragmentActivity: FragmentActivity) : FragmentStateAdapter(fragmentActivity) {
    private lateinit var itemClickListener: ItemClickListener
    val greatsList = mutableListOf<ResponseReviewGetData>()

    val fragments = mutableListOf<Fragment>()
    override fun getItemCount(): Int = fragments.size

    override fun createFragment(position: Int): Fragment {
        return fragments[position]
    }

    //1
    interface ItemClickListener {
        fun onClick(view: View, position: Int)
    }

    //2
    fun setItemClickListener(itemClickListener: ItemClickListener) {
        this.itemClickListener = itemClickListener
    }

//    class ReviewAdapter(private val binding : )

    //3
//    override fun onBindViewHolder(
//        holder: FragmentViewHolder,
//        position: Int,
//        payloads: MutableList<Any>
//    ) {
//        holder.itemView.setOnClickListener {
//            itemClickListener.onClick(it, position)
//        }
//    }
}