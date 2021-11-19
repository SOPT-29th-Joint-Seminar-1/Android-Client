package org.sopt.hapdongseminar_29th.View_Factory

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import org.sopt.hapdongseminar_29th.R
import org.sopt.hapdongseminar_29th.databinding.FragmentSmartFactory2Binding
import org.sopt.hapdongseminar_29th.databinding.FragmentSmartFactory3Binding

class SmartFactoryFragment3 : Fragment() {
    private var _binding: FragmentSmartFactory3Binding? = null
    private val binding get() = _binding?: error("SmartFactory3 error")
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentSmartFactory3Binding.inflate(layoutInflater, container, false)
        return binding.root
    }


}