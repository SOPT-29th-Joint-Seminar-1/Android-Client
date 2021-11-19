//package org.sopt.hapdongseminar_29th.Event
//
//import androidx.appcompat.app.AppCompatActivity
//import android.os.Bundle
//import android.os.Handler
//import android.os.Looper
//import android.util.Log
//import androidx.fragment.app.Fragment
//import org.sopt.hapdongseminar_29th.Adapter.EventAdapter
//import org.sopt.hapdongseminar_29th.databinding.ActivityMainBinding
//
//class MainActivity : AppCompatActivity() {
//    private lateinit var binding: ActivityMainBinding
//    private var fragmentList = listOf<Fragment>()
//    private var pagerHandler = Handler(Looper.getMainLooper())
//    private lateinit var eventAdapter: EventAdapter
//
//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//        binding = ActivityMainBinding.inflate(layoutInflater)
//        initAdapter()
//        val swipe = AutoSwipe()
//        swipe.start()
//        setContentView(binding.root)
//    }
//
//    private fun initAdapter() {
//        fragmentList = listOf(MainEvent1(), MainEvent2(), MainEvent3())
//        eventAdapter = EventAdapter(this)
//        eventAdapter.fragments.addAll(fragmentList)
//
//        val dotsIndicator = binding.dotsIndicator
//        val viewPager = binding.vp2Page
//        viewPager.adapter = eventAdapter
//
//        dotsIndicator.setViewPager2(viewPager)
//    }
//
//    inner class AutoSwipe : Thread() {
//        override fun run() {
//            try {
//                while (true) {
//                    sleep(2000)
//                    pagerHandler.post {
//                        var position = binding.vp2Page.currentItem
//                        if (position == fragmentList.size-1) {
//                            position = 0
//                            binding.vp2Page.currentItem = position
//                        } else {
//                            position++
//                            binding.vp2Page.currentItem = position
//                        }
//                    }
//                }
//            } catch (e: InterruptedException) {
//                Log.d("interrupt", "쓰레드 종료")
//            }
//        }
//    }
//}