package com.example.translatorofunitsoflength

import android.annotation.SuppressLint
import android.graphics.Color
import android.os.Bundle
import android.view.MotionEvent
import android.view.View
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    var text: TextView? = null
    var image: ImageView? = null
    var kmText: TextView? = null
    var kmDouble: Double? = null
    var mText: TextView? = null
    var mDouble: Double? = null
    var dmText: TextView? = null
    var dmDouble: Double? = null
    var cmText: TextView? = null
    var cmDouble: Double? = null
    var mmText: TextView? = null
    var mmDouble: Double? = null

    @SuppressLint("ClickableViewAccessibility")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        text = findViewById(R.id.rezult)
        image = findViewById(R.id.answer)
        kmText = findViewById(R.id.km)
        mText = findViewById(R.id.m)
        dmText = findViewById(R.id.dm)
        cmText = findViewById(R.id.cm)
        mmText = findViewById(R.id.mm)

        image?.setOnTouchListener { view, motionEvent ->
            if(motionEvent.getAction()==MotionEvent.ACTION_DOWN)
                if (image!!.alpha <= 0.1f)
                    image!!.alpha = 1f
                else
                    image!!.alpha -= 0.1f
            true
        }
    }

    fun buttonClick(v: View) {

        val b: Button = findViewById(R.id.inspect)

        b.setOnClickListener {
            kmDouble = kmText?.text.toString().toDouble()
            mDouble = mText?.text.toString().toDouble()
            dmDouble = dmText?.text.toString().toDouble()
            cmDouble = cmText?.text.toString().toDouble()
            mmDouble = mmText?.text.toString().toDouble()

            if ((kmDouble!! * 1000 == mDouble) and (dmDouble!! / 10 == mDouble) and (cmDouble!! / 100 == mDouble) and (mmDouble!! / 1000 == mDouble)) {
                text?.text = "Отлично!"
                image?.setImageResource(R.drawable.good)
                text?.setTextColor(Color.parseColor("#0000FF"));
            } else {
                text?.text = "Повторите материал, ответ неверный!"
                image?.setImageResource(R.drawable.bad)
                text?.setTextColor(Color.parseColor("#FF0000"));
            }
        }
    }
}
