package org.sopt.hapdongseminar_29th

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import org.sopt.hapdongseminar_29th.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityMainBinding.inflate(layoutInflater)

        supportFragmentManager.beginTransaction().replace(R.id.container_main,HomeFragment())
            .commitAllowingStateLoss()

        initBottomNavigation()

        setContentView(binding.root)
    }

    private fun initBottomNavigation(){
        binding.bnvMain.setOnItemSelectedListener {
            when(it.itemId) {
                R.id.menu_home -> {
                    supportFragmentManager.beginTransaction()
                        .replace(R.id.container_main, HomeFragment())
                        .commitAllowingStateLoss()
                    return@setOnItemSelectedListener true
                }
            } //TODO :다른 아이디 select 됐을때
                false
            }
        }
    }
