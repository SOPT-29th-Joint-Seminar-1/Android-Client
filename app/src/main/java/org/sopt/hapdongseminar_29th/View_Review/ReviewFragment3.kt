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
import org.sopt.hapdongseminar_29th.databinding.FragmentReview3Binding
import org.sopt.hapdongseminar_29th.util.ReviewCreator
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class ReviewFragment3 : Fragment() {
    private var isClick = false
    private var _binding: FragmentReview3Binding? = null
    private val binding get() = _binding ?: error("ReviewFragment1 error")

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = FragmentReview3Binding.inflate(layoutInflater, container, false)
        getValues()
        return binding.root
    }

    //좋아요 리뷰수 가져오기
    private fun onClick(count: String): String {
        var likecount: Int = count.toInt()
        binding.llRecommend.setOnClickListener {
            if (!isClick) {
                isClick = true
                binding.llRecommend.isSelected = isClick
                likecount.plus(1)

            } else {
                isClick = false
                binding.llRecommend.isSelected = isClick
                likecount.minus(1)
            }
        }
        return likecount.toString()
    }

    private fun getValues() {
        val call: Call<ResponseReviewGetData> = ReviewCreator.reviewInterface.getReview()
        call.enqueue(object : Callback<ResponseReviewGetData> {
            override fun onResponse(
                call: Call<ResponseReviewGetData>,
                response: Response<ResponseReviewGetData>
            ) {
                if (response.isSuccessful) {
                    val data = response.body()?.data?.get(2)
                    val beforeCount: String = data?.likecount.toString()
                    binding.tvTitle.text = data?.name.toString()
                    binding.tvComment.text = data?.content

                    binding.rbPickupStar.rating = data?.pickupStar?.toFloat()!!
                    binding.rbDeliveryStar.rating = data.deliveryStar.toFloat()
                    binding.rbLaundryStar.rating = data.laundryStar.toFloat()

                    binding.tvCleanCount.text = "세특 ${data?.usingcount}회차"

                    var afterCount: String = onClick(beforeCount).toString()
                    Toast.makeText(requireActivity(), beforeCount, Toast.LENGTH_SHORT).show()
                    if (afterCount.toInt() < 99)
                        afterCount = data?.likecount.toString()
                    else
                        afterCount = "99+"
                    binding.tvRecommendCount.text = afterCount
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