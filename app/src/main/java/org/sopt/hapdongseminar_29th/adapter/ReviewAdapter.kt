package org.sopt.hapdongseminar_29th.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import org.sopt.hapdongseminar_29th.R
import org.sopt.hapdongseminar_29th.data.ResponseReviewGetData
import org.sopt.hapdongseminar_29th.databinding.ReviewItemBinding

//fragmentstate -> recyclerview
// fragment 3개를 지운다음
// itemlayout 하나 만들고 list 받기

class ReviewAdapter : RecyclerView.Adapter<ReviewAdapter.ReviewViewHolder>() {
    var reviewList = listOf<ResponseReviewGetData.Data>()

    class ReviewViewHolder(private val binding: ReviewItemBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun onBind(data: ResponseReviewGetData.Data) {
            binding.tvTitle1.text = data.name
            binding.rbPickupStar1.rating = data.pickupStar.toFloat()
            binding.rbDeliveryStar1.rating = data.deliveryStar.toFloat()
            binding.rbLaundryStar1.rating = data.laundryStar.toFloat()
            binding.tvCleanCount1.text = "세특 ${data.usingcount}회차"
            binding.tvComment1.text = data.content

            if (data.likecount > 99) {
                binding.tvRecommendCount1.text = "99+"
            } else {
                binding.tvRecommendCount1.text = data.likecount.toString()
            }
            binding.llRecommend1.setOnClickListener {
                if (!binding.llRecommend1.isSelected) {
                    binding.llRecommend1.isSelected = true
                    binding.tvRecommendCount1.text = data.likecount.plus(1).toString()
                } else {
                    binding.llRecommend1.isSelected = false
                    binding.tvRecommendCount1.text = data.likecount.toString()
                }
                if (binding.tvRecommendCount1.text.toString().toInt() > 99) {
                    binding.tvRecommendCount1.text = "99+"
                }
            }
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ReviewViewHolder {
        val binding = ReviewItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ReviewViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ReviewViewHolder, position: Int) {
        holder.onBind(reviewList[position])
    }

    override fun getItemCount(): Int = reviewList.size

}
