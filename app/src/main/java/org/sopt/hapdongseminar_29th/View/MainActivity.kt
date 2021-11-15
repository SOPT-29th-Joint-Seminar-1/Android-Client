package org.sopt.hapdongseminar_29th.View

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.viewpager.widget.ViewPager
import androidx.viewpager2.widget.ViewPager2
import com.tbuonomo.viewpagerdotsindicator.WormDotsIndicator
import org.sopt.hapdongseminar_29th.R
import org.sopt.hapdongseminar_29th.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private var position = FIRST_POSITION
    private lateinit var binding: ActivityMainBinding
    private lateinit var fragmentAdapter: FragmentAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root


        initAdapter()



        setContentView(view)
    }

    private fun initAdapter() {
        val fragmentList = listOf(MainEvent(), MainReview(), TestFragment())
        fragmentAdapter = FragmentAdapter(this)
        fragmentAdapter.fragments.addAll(fragmentList)

        val dotsIndicator = binding.dotsIndicator
        val viewPager = binding.vp2Page
        viewPager.adapter = fragmentAdapter

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

        dotsIndicator.setViewPager2(viewPager)
    }
    companion object {
        const val FIRST_POSITION = 1
        const val SECOND_POSITION = 2
    }
}
