package org.sopt.hapdongseminar_29th

import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.Window
import org.sopt.hapdongseminar_29th.databinding.ActivityPopupBinding

class PopupActivity : AppCompatActivity() {

    private lateinit var binding: ActivityPopupBinding
    var isRunning:Boolean=true

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        requestWindowFeature(Window.FEATURE_NO_TITLE)
        binding= ActivityPopupBinding.inflate(layoutInflater)


        window!!.setBackgroundDrawable(
            ColorDrawable(Color.TRANSPARENT))

        supportActionBar?.hide()

        val autoclose=AutoClose()
        autoclose.start()


        setContentView(binding.root)

    }

    override fun onDestroy() {
        super.onDestroy()

        isRunning=false
    }

    inner class AutoClose : Thread(){
        override fun run() {
            try{
                while(isRunning) {
                    sleep(3000)
                    isRunning=false
                    finish()
                }
            }catch (e:InterruptedException){
                Log.d("interrupt","스레드 종료")
            }
        }
    }
}