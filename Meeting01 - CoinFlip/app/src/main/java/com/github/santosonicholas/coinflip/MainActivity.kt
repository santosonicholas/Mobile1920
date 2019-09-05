package com.github.santosonicholas.coinflip

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.animation.RotateAnimation
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import java.util.*

class MainActivity : AppCompatActivity() {

    lateinit var iv_coin: ImageView
    lateinit var but_flip: Button
    lateinit var text_coin: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        but_flip = findViewById(R.id.but_flip) as Button
        iv_coin = findViewById(R.id.iv_coin) as ImageView
        text_coin = findViewById(R.id.result_coin) as TextView

        but_flip.setOnClickListener {
            rollFlip()
            Toast.makeText(this, "Button Clicked", Toast.LENGTH_SHORT).show()
        }
    }

    private fun rollFlip() {
        val coinSide = Random().nextInt(2) + 1
        if (coinSide == 1) {
            iv_coin.setImageResource(R.drawable.head)
            text_coin.setText("YOUR COIN IS HEAD")
        } else if (coinSide == 2) {
            iv_coin.setImageResource(R.drawable.tail)
            text_coin.setText("YOUR COIN IS TAIL")
        }

        val rotate = RotateAnimation(
            0F, 360F,
            RotateAnimation.RELATIVE_TO_SELF, 0.5f, RotateAnimation.RELATIVE_TO_SELF, 0.5f)
        rotate.setDuration(1000)
        iv_coin.startAnimation(rotate)

    }
}
