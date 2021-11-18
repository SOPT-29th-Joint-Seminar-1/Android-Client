package org.sopt.hapdongseminar_29th.View

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import org.sopt.hapdongseminar_29th.Adapter.EventAdapter
import org.sopt.hapdongseminar_29th.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private var position = FIRST_POSITION
    private lateinit var binding: ActivityMainBinding
    private lateinit var eventAdapter: EventAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        initAdapter()
        setContentView(binding.root)
    }

    private fun initAdapter() {
        val fragmentList = listOf(MainEvent1(), MainEvent2(), MainEvent3())
        eventAdapter = EventAdapter(this)
        eventAdapter.fragments.addAll(fragmentList)

        val dotsIndicator = binding.dotsIndicator
        val viewPager = binding.vp2Page
        viewPager.adapter = eventAdapter

        dotsIndicator.setViewPager2(viewPager)
    }

    companion object {
        const val FIRST_POSITION = 1
        const val SECOND_POSITION = 2
    }
}
//        viewPager.apply {
//            registerOnPageChangeCallback(object : ViewPager2.OnPageChangeCallback() {
//                override fun onPageScrollStateChanged(state: Int) {
//                    super.onPageScrollStateChanged(state)
//                    when (state) {
//                        ViewPager2.SCROLL_STATE_DRAGGING -> autoScrollStop()
//                        ViewPager2.SCROLL_STATE_IDLE -> autoScrollStart()
//                    }
//                }
//            })
//        }