package org.sopt.hapdongseminar_29th.View_Review

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import org.sopt.hapdongseminar_29th.R
import org.sopt.hapdongseminar_29th.databinding.FragmentReview2Binding

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