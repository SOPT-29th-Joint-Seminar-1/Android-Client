package org.sopt.hapdongseminar_29th.view

import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import org.sopt.hapdongseminar_29th.Adapter.SmartFactoryAdapter
import org.sopt.hapdongseminar_29th.Product
import org.sopt.hapdongseminar_29th.R
import org.sopt.hapdongseminar_29th.View_Factory.SmartFactoryFragment1
import org.sopt.hapdongseminar_29th.View_Factory.SmartFactoryFragment2
import org.sopt.hapdongseminar_29th.View_Factory.SmartFactoryFragment3
import org.sopt.hapdongseminar_29th.View_Factory.SmartFactoryFragment4
import org.sopt.hapdongseminar_29th.Adapter.PlusPriceListRVAdapter
import org.sopt.hapdongseminar_29th.databinding.FragmentPlusBinding

class PlusFragment : Fragment() {
    private lateinit var smartFactoryAdapter: SmartFactoryAdapter
    private lateinit var plusPriceListRVAdapter: PlusPriceListRVAdapter

    private var pagerHandler = Handler(Looper.getMainLooper())
    private var fragmentList = listOf<Fragment>()

    private lateinit var binding: FragmentPlusBinding
    private var cautionPressed = false

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        binding = FragmentPlusBinding.inflate(inflater, container, false)
        init()
        val swipe = AutoSwipe()
        swipe.start()
        return binding.root
    }

    private fun init() {
        binding.etSearch.setOnFocusChangeListener { view, b ->
            binding.ivSearchBtn.setImageResource(R.drawable.ic_plus_search_focused)
        }
        initAdapter()
        initBtn()
        initProcessAdapter()

    }

    private fun initAdapter() {
        plusPriceListRVAdapter = PlusPriceListRVAdapter()
        plusPriceListRVAdapter.priceList.addAll(
            listOf(
                Product("와이셔츠", 1800),
                Product("교복셔츠", 1800),
                Product("일반셔츠, 블라우스", 3000),
                Product("티셔츠", 3000),
                Product("맨투맨, 후드티", 4000),
                Product("니트 스웨터, 가디건", 3500),
                Product("바지, 스커트", 6000),
                Product("원피스, 점프수트", 6000),
                Product("스키/보드바지, 패딩바지", 10900),
                Product("인조가죽 하의", 10900)
            )
        )
        binding.rvPriceList.adapter = plusPriceListRVAdapter
    }
    private fun initProcessAdapter() {
        fragmentList = listOf(
            SmartFactoryFragment1(),
            SmartFactoryFragment2(),
            SmartFactoryFragment3(),
            SmartFactoryFragment4()
        )
        smartFactoryAdapter = SmartFactoryAdapter(requireActivity())
        smartFactoryAdapter.fragments.addAll(fragmentList)

        // 인디케이터 연결
        val dotsIndicator = binding.dotsIndicator
        val viewPager = binding.vp2ProcessPage
        viewPager.adapter = smartFactoryAdapter

        // 미리보기
        val dpValue = 48;
        val d = resources.displayMetrics.density
        val margin = (dpValue * d).toInt()
        viewPager.clipToPadding = false
        viewPager.offscreenPageLimit = margin / 2
        viewPager.setPadding(0, 0, margin, 0)
        dotsIndicator.setViewPager2(viewPager)
    }
    private fun initBtn() {
        binding.tvTest.setOnClickListener {
            cautionPressed = !cautionPressed

            if (cautionPressed) {
                binding.tvTestContent.visibility = View.VISIBLE
                binding.ivCautionDown.setImageResource(R.drawable.ic_icon_arrow_up)
            } else {
                binding.tvTestContent.visibility = View.INVISIBLE
                binding.ivCautionDown.setImageResource(R.drawable.ic_icon_down_red)
            }
        }
    }

    // Viewpager2 auto position
    inner class AutoSwipe : Thread() {
        override fun run() {
            try {
                while (true) {
                    sleep(2000)
                    pagerHandler.post {
                        var position = binding.vp2ProcessPage.currentItem
                        if (position == fragmentList.size - 1) {
                            position = 0
                            binding.vp2ProcessPage.currentItem = position
                        } else {
                            position++
                            binding.vp2ProcessPage.currentItem = position
                        }
                    }
                }
            } catch (e: InterruptedException) {
                Log.d("interrupt", "쓰레드 종료")
            }
        }
    }
}