package org.sopt.hapdongseminar_29th.View_Review

import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Adapter
import android.widget.Toast
import org.sopt.hapdongseminar_29th.R
import org.sopt.hapdongseminar_29th.adapter.ReviewAdapter
import org.sopt.hapdongseminar_29th.data.ResponseReviewGetData
import org.sopt.hapdongseminar_29th.databinding.FragmentHomeBinding
import org.sopt.hapdongseminar_29th.databinding.FragmentReviewBinding
import org.sopt.hapdongseminar_29th.util.ReviewCreator
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class ReviewFragment : Fragment() {
    private var _binding: FragmentReviewBinding? = null
    private val binding get() = _binding!!
    private lateinit var reviewAdapter: ReviewAdapter
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentReviewBinding.inflate(layoutInflater, container, false)
        initAdapter()
        return binding.root
    }

    private fun initAdapter() {
        reviewAdapter = ReviewAdapter()
        binding.rvContainer.adapter = reviewAdapter
        initReviewNetwork()
        reviewAdapter.notifyDataSetChanged()
    }

    private fun initReviewNetwork() {
        val call: Call<ResponseReviewGetData> = ReviewCreator.reviewInterface.getReview()
        call.enqueue(object : Callback<ResponseReviewGetData> {
            override fun onResponse(
                call: Call<ResponseReviewGetData>,
                response: Response<ResponseReviewGetData>
            ) {
                if (response.isSuccessful) {
                    val data = response.body()?.data
                    if (data != null) {
                        reviewAdapter.reviewList = data
                    }
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

/*
var likeCount: Int = data?.likecount!!
                    binding.tvTitle.text = data?.name.toString()
                    binding.tvComment.text = data?.content

                    binding.rbPickupStar.rating = data.pickupStar.toFloat()
                    binding.rbDeliveryStar.rating = data.deliveryStar.toFloat()
                    binding.rbLaundryStar.rating = data.laundryStar.toFloat()

                    binding.tvCleanCount.text = "세특 ${data?.usingcount}회차"

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
* */