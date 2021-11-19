package org.sopt.hapdongseminar_29th.View_Factory

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import org.sopt.hapdongseminar_29th.R
import org.sopt.hapdongseminar_29th.databinding.FragmentSmartFactory1Binding

class SmartFactoryFragment1 : Fragment() {
    private var _binding: FragmentSmartFactory1Binding? = null
    private val binding get() = _binding?: error("SmartFactory1 error")
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = FragmentSmartFactory1Binding.inflate(layoutInflater,container,false)
        return binding.root
    }
}