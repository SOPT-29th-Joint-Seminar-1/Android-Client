package org.sopt.hapdongseminar_29th.View_Review

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.util.Log
import androidx.fragment.app.Fragment
import org.sopt.hapdongseminar_29th.Adapter.ReviewAdapter
import org.sopt.hapdongseminar_29th.databinding.ActivityReviewBinding

class ReviewActivity : AppCompatActivity() {
    private var fragmentList = listOf<Fragment>()
    private lateinit var binding: ActivityReviewBinding
    private lateinit var reviewAdapter: ReviewAdapter
    private var pagerHandler = Handler(Looper.getMainLooper())
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityReviewBinding.inflate(layoutInflater)
        initAdapter()
        val swipe = AutoSwipe()
        swipe.start()
        setContentView(binding.root)
    }

    private fun initAdapter() {
        fragmentList = listOf(ReviewFragment1(), ReviewFragment2(), ReviewFragment3())
        reviewAdapter = ReviewAdapter(this)
        reviewAdapter.fragments.addAll(fragmentList)

        val dotsIndicator = binding.dotsIndicator
        val viewPager = binding.vp2Page
        viewPager.adapter = reviewAdapter

        dotsIndicator.setViewPager2(viewPager)
    }

    inner class AutoSwipe : Thread() {
        override fun run() {
            try {
                while (true) {
                    sleep(4000)
                    pagerHandler.post {
                        var position = binding.vp2Page.currentItem
                        if (position == fragmentList.size-1) {
                            position = 0
                            binding.vp2Page.currentItem = position
                        } else {
                            position++
                            binding.vp2Page.currentItem = position
                        }
                    }
                }
            } catch (e: InterruptedException) {
                Log.d("interrupt", "쓰레드 종료")
            }
        }
    }

}