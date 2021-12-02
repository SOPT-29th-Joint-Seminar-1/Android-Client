package org.sopt.hapdongseminar_29th

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import org.sopt.hapdongseminar_29th.adapter.EventAdapter
import org.sopt.hapdongseminar_29th.adapter.ReviewAdapter
import org.sopt.hapdongseminar_29th.Event.MainEvent1
import org.sopt.hapdongseminar_29th.Event.MainEvent2
import org.sopt.hapdongseminar_29th.Event.MainEvent3
import org.sopt.hapdongseminar_29th.data.ResponseReviewGetData
import org.sopt.hapdongseminar_29th.databinding.FragmentHomeBinding
import org.sopt.hapdongseminar_29th.util.ReviewCreator
import org.sopt.hapdongseminar_29th.view.PlusActivity
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class HomeFragment : Fragment() {
    private var fragmentEventList = listOf<Fragment>()
    private var fragmentReviewList = listOf<ResponseReviewGetData.Data>()
    private var pagerHandler = Handler(Looper.getMainLooper())
    private lateinit var thread: AutoSwipe
    private lateinit var eventAdapter: EventAdapter
    private lateinit var reviewAdapter: ReviewAdapter
    private val imageList = listOf<ImageView>()

    private var _binding: FragmentHomeBinding? = null
    private val binding get() = _binding!!
    private lateinit var adapter: HomeEventRecyclerViewAdapter

    val eventList = mutableListOf<EventData>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentHomeBinding.inflate(layoutInflater, container, false)
        initList()
        initAdapter()
        initRecyclerView()

        thread = AutoSwipe()
        thread.start()

        binding.ivHomeComputer.clipToOutline = true //TODO : 이렇게하면 round corner되는지? 안되면 카드뷰

        binding.ivQuestion.setOnClickListener {
            val intent = Intent(requireContext(), PopupActivity::class.java)
            startActivity(intent)

        }

        binding.btnHomeBlue.setOnClickListener {
            startActivity(Intent(requireContext(), PlusActivity::class.java))
        }

        return binding.root
    }

    private fun initRecyclerView() {
        val adapter = HomeEventRecyclerViewAdapter()
        adapter.datalist = eventList
        binding.recyclerHome.adapter = adapter
        binding.recyclerHome.layoutManager = LinearLayoutManager(requireContext())

    }

    private fun initList() {
        with(eventList) {
            add(EventData(R.drawable.home_recyclerimg1, "세특이 처음이라면 무조건 반값!", "신규회원 첫주문 이벤트"))
            add(
                EventData(
                    R.drawable.home_recyclerimg2,
                    "핑크색 머리 스티브잡스의 옷장",
                    "스타트업 영업이사˙뮤지션 이병현의 옷 이야기"
                )
            )
        }
    }

    private fun initAdapter() {
        fragmentEventList = listOf(MainEvent1(), MainEvent2(), MainEvent3())
//        fragmentReviewList = listOf(ReviewFragment1(), ReviewFragment2(), ReviewFragment3())

        eventAdapter = EventAdapter(requireActivity())
        eventAdapter.fragments.addAll(fragmentEventList)

        reviewAdapter = ReviewAdapter()
        binding.vpHome2.adapter = reviewAdapter

        initReviewNetwork()

        val dotsIndicatorEvent = binding.dotsIndicatorEvent
        val vpHome1 = binding.vpHome1
        vpHome1.adapter = eventAdapter

        val dotsIndicatorReview = binding.dotsIndicatorReview
        val vpHome2 = binding.vpHome2
        vpHome2.adapter = reviewAdapter

        dotsIndicatorEvent.setViewPager2(vpHome1)
        dotsIndicatorReview.setViewPager2(vpHome2)
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
                        reviewAdapter.notifyDataSetChanged()
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

    inner class AutoSwipe : Thread() {
        override fun run() {
            try {
                while (true) {
                    sleep(5000)
                    pagerHandler.post {
                        var position = binding.vpHome1.currentItem
                        if (position == fragmentEventList.size - 1) {
                            position = 0
                            binding.vpHome1.currentItem = position
                        } else {
                            position++
                            binding.vpHome1.currentItem = position
                        }
                        var position2 = binding.vpHome2.currentItem
                        if (position2 == fragmentReviewList.size - 1) {
                            position2 = 0
                            binding.vpHome2.currentItem = position2
                        } else {
                            position2++
                            binding.vpHome2.currentItem = position
                        }
                    }
                }
            } catch (e: InterruptedException) {
                Log.d("interrupt", "쓰레드 종료")
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        thread.interrupt()
        _binding = null
    }
}