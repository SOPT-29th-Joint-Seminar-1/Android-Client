package org.sopt.hapdongseminar_29th.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import org.sopt.hapdongseminar_29th.R
import org.sopt.hapdongseminar_29th.databinding.ActivityPlusBinding

class PlusActivity : AppCompatActivity() {

    private lateinit var binding : ActivityPlusBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityPlusBinding.inflate(layoutInflater)
        setContentView(binding.root)

        init()
    }

    private fun init() {
        initToolBar()
        initBtn()
        initFragment()
    }

    private fun initToolBar() {
        setSupportActionBar(binding.tbPlus)
        supportActionBar?.setDisplayShowTitleEnabled(false)
    }

    private fun initFragment() {
        // 추가
        val transaction = supportFragmentManager.beginTransaction()
        val plusFragment = PlusFragment()
        transaction.replace(R.id.fc_plus, plusFragment).commit()
    }

    private fun initBtn() {
        binding.tbPlus.setOnClickListener {
            // 추가
        }

        binding.clApplyBtn.setOnClickListener {
            // 추가
        }

        binding.rbPrice.setOnClickListener {
            binding.svPlus.scrollTo(0,350)
        }

        binding.rbUse.setOnClickListener {
            binding.svPlus.scrollTo(0,1700)
        }

        binding.rbProcess.setOnClickListener {
            binding.svPlus.scrollTo(0,4000)
        }

    }


}