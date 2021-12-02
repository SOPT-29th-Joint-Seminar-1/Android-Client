package org.sopt.hapdongseminar_29th.View_Review

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import org.sopt.hapdongseminar_29th.R
import org.sopt.hapdongseminar_29th.data.ResponseReviewGetData
import org.sopt.hapdongseminar_29th.databinding.FragmentReview2Binding
import org.sopt.hapdongseminar_29th.util.ReviewCreator
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class ReviewFragment2 : Fragment() {
    private var _binding: FragmentReview2Binding? = null
    private val binding get() = _binding ?: error("ReviewFragment1 error")
    private var isClick = false

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = FragmentReview2Binding.inflate(layoutInflater, container, false)
        getValues()
        return binding.root
    }

    //좋아요 리뷰수 가져오기
    private fun onClick(count: String): Int {
        var likecount: Int = count.toInt()
        binding.llRecommend.setOnClickListener {
            if (!isClick) {
                isClick = true
                binding.llRecommend.isSelected = isClick
                likecount += 1
            } else {
                isClick = false
                binding.llRecommend.isSelected = isClick
                likecount -= 1
            }
        }
        return likecount
    }

    private fun getValues() {
        val call: Call<ResponseReviewGetData> = ReviewCreator.reviewInterface.getReview()
        call.enqueue(object : Callback<ResponseReviewGetData> {
            override fun onResponse(
                call: Call<ResponseReviewGetData>,
                response: Response<ResponseReviewGetData>
            ) {
                if (response.isSuccessful) {
                    val data = response.body()?.data?.get(1)
                    var likeCount: Int = data?.likecount!!
                    binding.tvTitle.text = data?.name.toString()
                    binding.tvComment.text = data?.content
                    binding.rbPickupStar.rating = data.pickupStar.toFloat()
                    binding.rbDeliveryStar.rating = data.deliveryStar.toFloat()
                    binding.rbLaundryStar.rating = data.laundryStar.toFloat()

                    binding.tvCleanCount.text = "세특 ${data?.usingcount}회차"
                    binding.tvRecommendCount.text = likeCount.toString()

                    binding.llRecommend.setOnClickListener {
                        if (!isClick) {
                            isClick = true
                            binding.llRecommend.isSelected = isClick
                            likeCount += 1
                        } else {
                            isClick = false
                            binding.llRecommend.isSelected = isClick
                            likeCount -= 1
                        }
                    }
                    if (likeCount < 99)
                        binding.tvRecommendCount.text = likeCount.toString()
                    else
                        binding.tvRecommendCount.text = "99+"
                } else {
                    Toast.makeText(activity, "error", Toast.LENGTH_SHORT).show()
                }
            }

            override fun onFailure(call: Call<ResponseReviewGetData>, t: Throwable) {
                Log.e("error", "$t")
            }
        })
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}