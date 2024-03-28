package com.example.signinactivity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import java.lang.StringBuilder
import java.util.Random

class HomeActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        val random = Random()
        val num = random.nextInt(5)
        val iv_img = findViewById<ImageView>(R.id.iv_img)

        when (num) {
            0 -> iv_img.setImageResource(R.drawable.img1)
            1 -> iv_img.setImageResource(R.drawable.img2)
            2 -> iv_img.setImageResource(R.drawable.img3)
            3 -> iv_img.setImageResource(R.drawable.img4)
            4 -> iv_img.setImageResource(R.drawable.img5)
        }

        val strId = intent.getStringExtra("idFromSignInActivity")
        val tv_id = findViewById<TextView>(R.id.tv_id)
        tv_id.setText(strId)


        val btn_close = findViewById<Button>(R.id.btn_close)
        btn_close.setOnClickListener {
            finish()
        }
    }
}