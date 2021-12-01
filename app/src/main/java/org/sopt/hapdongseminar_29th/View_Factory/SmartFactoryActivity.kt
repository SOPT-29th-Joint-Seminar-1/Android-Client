package org.sopt.hapdongseminar_29th.View_Factory

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.util.Log
import androidx.fragment.app.Fragment
import org.sopt.hapdongseminar_29th.adapter.SmartFactoryAdapter
import org.sopt.hapdongseminar_29th.databinding.ActivitySmartFactoryBinding

class SmartFactoryActivity : AppCompatActivity() {
    private var fragmentList = listOf<Fragment>()
    private lateinit var binding: ActivitySmartFactoryBinding
    private lateinit var thread: AutoSwipe
    private lateinit var smartFactoryAdatper: SmartFactoryAdapter
    private var pagerHandler = Handler(Looper.getMainLooper())
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySmartFactoryBinding.inflate(layoutInflater)
        initAdapter()
        setContentView(binding.root)
        val swipe = AutoSwipe()
        swipe.start()
    }

    private fun initAdapter() {
        fragmentList = listOf(
            SmartFactoryFragment1(),
            SmartFactoryFragment2(),
            SmartFactoryFragment3(),
            SmartFactoryFragment4()
        )
        smartFactoryAdatper = SmartFactoryAdapter(this)
        smartFactoryAdatper.fragments.addAll(fragmentList)

        // 인디케이터 연결
        val dotsIndicator = binding.dotsIndicator
        val viewPager = binding.vp2Page
        viewPager.adapter = smartFactoryAdatper

        // 미리보기
        val dpValue = 48;
        val d = resources.displayMetrics.density
        val margin = (dpValue * d).toInt()
        viewPager.clipToPadding = false
        viewPager.offscreenPageLimit = margin / 2
        viewPager.setPadding(0, 0, margin, 0)
        dotsIndicator.setViewPager2(viewPager)
    }

    // Viewpager2 auto position
    inner class AutoSwipe : Thread() {
        override fun run() {
            try {
                while (true) {
                    sleep(2000)
                    pagerHandler.post {
                        var position = binding.vp2Page.currentItem
                        if (position == fragmentList.size - 1) {
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

    override fun onDestroy() {
        super.onDestroy()
        thread.interrupt()
    }
}