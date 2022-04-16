package com.example.guntingbatukertas5

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.widget.ImageView
import com.bumptech.glide.Glide

class SplashActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)
        supportActionBar?.hide()

        val imageView : ImageView = findViewById(R.id.splash_screen1)
        Glide.with(this).load("https://i.ibb.co/HC5ZPgD/splash-screen1.png").into(imageView)

        Handler().postDelayed({
            val mainIntent = Intent(this, AppToIntro::class.java)
            startActivity(mainIntent)
            finish()
        }, 1500)
    }
}