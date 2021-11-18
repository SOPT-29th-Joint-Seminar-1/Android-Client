package org.sopt.hapdongseminar_29th.Event

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import org.sopt.hapdongseminar_29th.databinding.FragmentMainEvent1Binding

class MainEvent1 : Fragment() {
    private var _binding: FragmentMainEvent1Binding? = null
    private val binding get() = _binding ?: error("FollowersBinding error")
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = FragmentMainEvent1Binding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}