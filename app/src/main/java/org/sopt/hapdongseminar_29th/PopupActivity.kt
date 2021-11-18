package org.sopt.hapdongseminar_29th

import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Window
import org.sopt.hapdongseminar_29th.databinding.ActivityPopupBinding

class PopupActivity : AppCompatActivity() {

    private lateinit var binding: ActivityPopupBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        requestWindowFeature(Window.FEATURE_NO_TITLE)
        binding= ActivityPopupBinding.inflate(layoutInflater)


        window!!.setBackgroundDrawable(
            ColorDrawable(Color.TRANSPARENT))

        supportActionBar?.hide()


        setContentView(binding.root)

    }
}