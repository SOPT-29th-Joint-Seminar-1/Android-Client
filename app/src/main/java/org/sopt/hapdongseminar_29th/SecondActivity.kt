package org.sopt.hapdongseminar_29th

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import org.sopt.hapdongseminar_29th.databinding.ActivityMainBinding
import org.sopt.hapdongseminar_29th.databinding.ActivitySecondBinding

class SecondActivity : AppCompatActivity() {

    private lateinit var binding:ActivitySecondBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivitySecondBinding.inflate(layoutInflater)


        setContentView(binding.root)
    }
}