package org.sopt.hapdongseminar_29th.Adapter

import android.os.Handler
import android.os.Looper
import android.util.Log
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter

class SmartFactoryAdapter(fragmentActivity: FragmentActivity) : FragmentStateAdapter(fragmentActivity) {
    val fragments = mutableListOf<Fragment>()
    override fun getItemCount(): Int = fragments.size

    override fun createFragment(position: Int): Fragment =
        fragments[position]

}