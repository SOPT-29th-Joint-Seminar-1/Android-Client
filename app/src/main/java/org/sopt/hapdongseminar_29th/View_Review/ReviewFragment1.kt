package org.sopt.hapdongseminar_29th.View_Review

import android.graphics.Color
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.MotionEvent
import android.view.View
import android.view.ViewGroup
import org.sopt.hapdongseminar_29th.R
import org.sopt.hapdongseminar_29th.databinding.FragmentMainEvent1Binding
import org.sopt.hapdongseminar_29th.databinding.FragmentReview1Binding

class ReviewFragment1 : Fragment() {
    private var isClick = false
    private var _binding: FragmentReview1Binding? = null
    private val binding get() = _binding ?: error("ReviewFragment1 error")

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = FragmentReview1Binding.inflate(layoutInflater, container, false)
        onClick()
        return binding.root
    }

    private fun onClick() {
        binding.llRecommend.setOnClickListener {
            var text = binding.tvRecommendCount.text.toString().toInt()
            if (!isClick) {
                isClick = true
                binding.llRecommend.isSelected = isClick
                text += 1
                if (text > 99) binding.tvRecommendCount.text = "99+"
                else binding.tvRecommendCount.text = text.toString()
            } else {
                isClick = false
                binding.llRecommend.isSelected = isClick
                text -= 1
                binding.tvRecommendCount.text = text.toString()
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}