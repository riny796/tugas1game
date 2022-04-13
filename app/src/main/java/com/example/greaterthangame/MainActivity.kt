package com.example.greaterthangame

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.View
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import kotlin.random.Random

class MainActivity : AppCompatActivity() {

    lateinit var kartu1: ImageView
    lateinit var kartu2: ImageView
    lateinit var skorKiri: TextView
    lateinit var skorKanan: TextView
    lateinit var b_start: Button
    lateinit var random: Random

    var tv_skorKanan = 0
    var tv_skorKiri = 0

    val kartuImg = intArrayOf(
        R.drawable.kartu1,
        R.drawable.kartu2,
        R.drawable.kartu3,
        R.drawable.kartu4,
        R.drawable.kartu5,
        R.drawable.kartu6,
        R.drawable.kartu7,
        R.drawable.kartu8,
        R.drawable.kartu9,
        R.drawable.kartu10,
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        random = Random

        kartu1 = findViewById(R.id.imageView)
        kartu2 = findViewById(R.id.imageView2)

        skorKiri = findViewById(R.id.textView)
        skorKanan = findViewById(R.id.textView3)

        b_start = findViewById(R.id.button)
        b_start.setOnClickListener{

            val iv_kartu1 = random.nextInt(kartuImg.size)
            val iv_kartu2 = random.nextInt(kartuImg.size)

            setCardImage(iv_kartu1, kartu1)
            setCardImage(iv_kartu2, kartu2)

            if (iv_kartu1 > iv_kartu2) {
                tv_skorKiri++
                skorKiri.text = "$tv_skorKiri"
            } else if (iv_kartu1 < iv_kartu2) {
                tv_skorKanan++
                skorKanan.text = "$tv_skorKanan"
            }

        }
    }
    private fun setCardImage(number: Int, image: ImageView) {
        image.setImageResource(kartuImg[number])
    }
}

