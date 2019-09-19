package com.github.santosonicholas.labweek4

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import com.github.santosonicholas.labweek4.databinding.ActivityMainBinding
import kotlinx.android.synthetic.main.activity_main.*
import kotlin.random.Random

class MainActivity : AppCompatActivity() {


    private lateinit var binding: ActivityMainBinding
    private lateinit var selectedView: View
    private var selectedId = 1;

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        val boxId: List<Int> = listOf(
            binding.boxOneText.id,
            binding.boxTwoText.id,
            binding.boxThreeText.id,
            binding.boxFourText.id,
            binding.boxFiveText.id
        )
        selectedId = boxId[Random.nextInt(0, 5)]
        setListener()
    }
/*
    private fun makeColored(view: View){
        when(view.id){
            R.id.box_one_text -> view.setBackgroundColor(Color.DKGRAY)
            R.id.box_two_text -> view.setBackgroundColor(Color.GRAY)
            R.id.box_three_text -> view.setBackgroundColor(Color.BLUE)
            R.id.box_four_text -> view.setBackgroundColor(Color.MAGENTA)
            R.id.box_five_text -> view.setBackgroundColor(Color.RED)

            R.id.button_red ->box_three_text.setBackgroundResource(R.color.button_red)
            R.id.button_yellow ->box_four_text.setBackgroundResource(R.color.button_yellow)
            R.id.button_green ->box_five_text.setBackgroundResource(R.color.button_green)


            else -> view.setBackgroundColor(Color.LTGRAY)
        }
    }*/

    private fun setPicture(view: View) {
        if (view.id == selectedId) {
            setTextBackground(view, android.R.drawable.btn_star_big_on)
            selectedView = view
            foundStar()

        } else setTextBackground(view, android.R.drawable.btn_star_big_off)

    }

    private fun setTextBackground(view: View, buttonIcon: Int) {
        view.setBackgroundResource(buttonIcon)
    }

    private fun foundStar() {
        Toast.makeText(
            this,
            "You've found the colored star, TAP THE COLORED STAR if you want to restart the game",
            Toast.LENGTH_LONG
        ).show()
        selectedView.setOnClickListener {
            clearAll()
        }
    }

    private fun clearAll() {
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        val boxId: List<Int> = listOf(
            binding.boxOneText.id,
            binding.boxTwoText.id,
            binding.boxThreeText.id,
            binding.boxFourText.id,
            binding.boxFiveText.id
        )
        selectedId = boxId[Random.nextInt(0, 5)]
        binding.apply {
            val boxOneText = boxOneText
            val boxTwoText = boxTwoText
            val boxThreeText = boxThreeText
            val boxFourText = boxFourText
            val boxFiveText = boxFiveText

            val clickableViews: List<View> =
                listOf(boxOneText, boxTwoText, boxThreeText, boxFourText, boxFiveText)
            for (item in clickableViews) {
                item.setOnClickListener {
                    setPicture(it)
                }
                item.setBackgroundColor(Color.WHITE)
            }
        }
    }

    private fun setListener() {
        /*val boxOneText = findViewById<TextView>(R.id.box_one_text)
        val boxTwoText = findViewById<TextView>(R.id.box_two_text)
        val boxThreeText = findViewById<TextView>(R.id.box_three_text)
        val boxFourText = findViewById<TextView>(R.id.box_four_text)
        val boxFiveText = findViewById<TextView>(R.id.box_five_text)

        val buttonRed =findViewById<Button>(R.id.button_red)
        val buttonYellow =findViewById<Button>(R.id.button_yellow)
        val buttonGreen =findViewById<Button>(R.id.button_green)

        val rootConstraintLayout = findViewById<View>(R.id.constraint_layout)


        val clickableView: List<View> =
            listOf(boxOneText,boxTwoText,boxThreeText,boxFourText,boxFiveText,rootConstraintLayout,
                buttonRed,buttonYellow,buttonGreen)


        for (item in clickableView){
            item.setOnClickListener {
                makeColored(it)
            }
        } */
        binding.apply {
            val boxOneText = boxOneText
            val boxTwoText = boxTwoText
            val boxThreeText = boxThreeText
            val boxFourText = boxFourText
            val boxFiveText = boxFiveText

            val clickableViews: List<View> =
                listOf(boxOneText, boxTwoText, boxThreeText, boxFourText, boxFiveText)

            for (item in clickableViews) {
                item.setOnClickListener {
                    setPicture(it)
                }
            }
        }
    }


}
