package org.sopt.hapdongseminar_29th.view

import android.annotation.SuppressLint
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import org.sopt.hapdongseminar_29th.R
import org.sopt.hapdongseminar_29th.data.ResponseCategoryData
import org.sopt.hapdongseminar_29th.View_Factory.SmartFactoryFragment1
import org.sopt.hapdongseminar_29th.View_Factory.SmartFactoryFragment2
import org.sopt.hapdongseminar_29th.View_Factory.SmartFactoryFragment3
import org.sopt.hapdongseminar_29th.View_Factory.SmartFactoryFragment4
import org.sopt.hapdongseminar_29th.adapter.PlusPriceListRVAdapter
import org.sopt.hapdongseminar_29th.adapter.SmartFactoryAdapter
import org.sopt.hapdongseminar_29th.api.ServiceCreator
import org.sopt.hapdongseminar_29th.databinding.FragmentPlusBinding
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class PlusFragment : Fragment() {
    private lateinit var smartFactoryAdapter: SmartFactoryAdapter
    private lateinit var plusPriceListRVAdapter: PlusPriceListRVAdapter
    private lateinit var thread: AutoSwipe
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

        return binding.root
    }

    private fun init() {
        initSearch()
        initAdapter()
        initBtn()
        initRV()
        initProcessAdapter()

        thread = AutoSwipe()
        thread.start()
    }

    private fun initSearch() {
        binding.etSearch.setOnFocusChangeListener { view, b ->
            binding.ivSearchBtn.setImageResource(R.drawable.ic_plus_search_focused)
        }
    }

    @SuppressLint("ResourceAsColor")
    private fun initRV() {
        val customDecoration = VerticalItemDecoration(1f, 1f, 1, R.color.blue5)
        binding.rvPriceList.addItemDecoration(customDecoration)
    }

    private fun initAdapter() {
        plusPriceListRVAdapter = PlusPriceListRVAdapter()
        receiveAPI(0)
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
                binding.tvTestContent.visibility = View.GONE
                binding.ivCautionDown.setImageResource(R.drawable.ic_icon_down_red)
            }
        }

        binding.rgFilterLabel.setOnCheckedChangeListener { radioGroup, i ->
            binding.rvPriceList.smoothScrollToPosition(0)
            when(i){
                binding.rbAll.id -> {
//                    Toast.makeText(context, "all",Toast.LENGTH_SHORT).show()
                    receiveAPI(0)
                }
                binding.rbClothes.id -> {
//                    Toast.makeText(context, "clothes",Toast.LENGTH_SHORT).show()
                    receiveAPI(1)
                }
                binding.rbLiving.id -> {
//                    Toast.makeText(context, "living",Toast.LENGTH_SHORT).show()
                    receiveAPI(2)
                }
                binding.rbBedding.id -> {
//                    Toast.makeText(context, "bedding",Toast.LENGTH_SHORT).show()
                    receiveAPI(3)
                }
                binding.rbShoes.id -> {
//                    Toast.makeText(context, "shoes",Toast.LENGTH_SHORT).show()
                    receiveAPI(4)
                }
                binding.rbLeather.id -> {
//                    Toast.makeText(context, "leather",Toast.LENGTH_SHORT).show()
                    receiveAPI(5)
                }
                binding.rbRepair.id -> {
//                    Toast.makeText(context, "repair",Toast.LENGTH_SHORT).show()
                    receiveAPI(6)
                }
            }
        }
    }

    private fun receiveAPI(index : Int) {
        val call : Call<ResponseCategoryData>

        if(index == 0){
            call = ServiceCreator.categoryService.getCategoryList("")
        } else {
            call = ServiceCreator.categoryService.getCategoryList("$index")
        }

        call.enqueue(object : Callback<ResponseCategoryData> {
            override fun onResponse(
                call: Call<ResponseCategoryData>,
                response: Response<ResponseCategoryData>,
            ) {
                if (response.isSuccessful) {
                    val data = response.body()?.data
                    if (data != null) {
                        plusPriceListRVAdapter.priceList.clear()
                        plusPriceListRVAdapter.priceList.addAll(
                            data
                        )
                    }
                    plusPriceListRVAdapter.notifyDataSetChanged()
                } else {
                    Log.d("test", "data null")
                }
            }

            override fun onFailure(call: Call<ResponseCategoryData>, t: Throwable) {
                Log.e("NetworkTest", "error:$t")
            }
        })
    }

    // Viewpager2 auto position
    inner class AutoSwipe : Thread() {
        override fun run() {
            try {
                while (true) {
                    sleep(5000)
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
                e.printStackTrace()
            }
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        thread.interrupt()
    }
}