package com.example.diceroller

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*
import kotlin.random.Random

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        roll_button.setOnClickListener {
            rollDice()
        }
    }

    private fun rollDice() {
        val randomInt = Random.nextInt(6) + 1
        when(randomInt) {
            1-> iv_dice.setImageResource(R.drawable.dice_1)
            2-> iv_dice.setImageResource(R.drawable.dice_2)
            3-> iv_dice.setImageResource(R.drawable.dice_3)
            4-> iv_dice.setImageResource(R.drawable.dice_4)
            5-> iv_dice.setImageResource(R.drawable.dice_5)
            6-> iv_dice.setImageResource(R.drawable.dice_6)
        }
    }
}
