package org.sopt.hapdongseminar_29th

import android.os.Bundle
import android.util.EventLog
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import org.sopt.hapdongseminar_29th.databinding.FragmentHomeBinding

class HomeFragment : Fragment() {

    private var _binding: FragmentHomeBinding?=null
    private val binding get()=_binding!!
    private lateinit var adapter:HomeEventRecyclerViewAdapter

    val eventList= mutableListOf<EventData>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding= FragmentHomeBinding.inflate(layoutInflater,container,false)

        initList()
        initRecyclerView()

        binding.ivHomeComputer.clipToOutline=true //TODO : 이렇게하면 round corner되는지? 안되면 카드뷰

        return binding.root
    }

    private fun initRecyclerView(){
        val adapter=HomeEventRecyclerViewAdapter()
        adapter.datalist=eventList
        binding.recyclerHome.adapter=adapter
        binding.recyclerHome.layoutManager= LinearLayoutManager(requireContext())

    }

    private fun initList(){
        with(eventList){
            add(EventData(R.drawable.home_recyclerimg1,"세특이 처음이라면 무조건 반값!","신규회원 첫주문 이벤트"))
            add(EventData(R.drawable.home_recyclerimg2,"핑크색 머리 스티브잡스의 옷장","스타트업 영업이사˙뮤지션 이병현의 옷 이야기"))
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }


}