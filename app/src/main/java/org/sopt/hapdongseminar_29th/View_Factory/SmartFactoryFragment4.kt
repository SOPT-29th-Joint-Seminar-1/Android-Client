package org.sopt.hapdongseminar_29th.View_Factory

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import org.sopt.hapdongseminar_29th.R
import org.sopt.hapdongseminar_29th.databinding.FragmentSmartFactory2Binding
import org.sopt.hapdongseminar_29th.databinding.FragmentSmartFactory3Binding
import org.sopt.hapdongseminar_29th.databinding.FragmentSmartFactory4Binding

class SmartFactoryFragment4 : Fragment() {
    private var _binding: FragmentSmartFactory4Binding? = null
    private val binding get() = _binding?: error("SmartFactory4 error")
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentSmartFactory4Binding.inflate(layoutInflater, container, false)
        return binding.root
    }

}