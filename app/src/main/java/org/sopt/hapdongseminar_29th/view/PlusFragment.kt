package org.sopt.hapdongseminar_29th.view

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import org.sopt.hapdongseminar_29th.adapter.PlusFilterRVAdapter
import org.sopt.hapdongseminar_29th.databinding.FragmentPlusBinding

class PlusFragment : Fragment() {
    private lateinit var binding: FragmentPlusBinding
    private lateinit var plusFilterRVAdapter: PlusFilterRVAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        binding = FragmentPlusBinding.inflate(inflater, container, false)

        init()
        return binding.root
    }

    private fun init() {
        initAdapter()
        initBtn()
    }

    private fun initAdapter() {
        plusFilterRVAdapter = PlusFilterRVAdapter()
        binding.rvFilterLabel.adapter = plusFilterRVAdapter
        plusFilterRVAdapter.filterList.addAll(
            listOf("전체", "의류", "리빙", "침구", "신발", "가죽", "수선")
        )
    }

    private fun initBtn() {

    }
}