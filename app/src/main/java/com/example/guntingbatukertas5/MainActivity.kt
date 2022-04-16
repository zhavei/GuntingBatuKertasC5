package com.example.guntingbatukertas5

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.example.guntingbatukertas5.databinding.ActivityMainBinding
import com.google.android.material.snackbar.Snackbar

class MainActivity : AppCompatActivity() {

    companion object {
        const val KEY = AppToIntro.USER_NAME
    }

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        supportActionBar?.hide()

        snackbarOnAboard()
        //vsComSelect()

        //get kiriman dari App Intro
        val bundle = intent.extras
        val name = bundle?.getString(AppToIntro.USER_NAME)
        binding.tvNamePlayerVsPlyaer.text = name + " vs Pemain"
        binding.tvNamePlayerVsCpu.text = name + " vs CPU"

        binding.apply {
            binding.imageViewCpu.setOnClickListener {
                val intent = Intent(applicationContext, VsComActivity::class.java)
                bundle?.let { intent.putExtras(it) }
                startActivity(intent)
            }
            binding.imageViewVsPalyer.setOnClickListener {
                val intent = Intent(applicationContext, VsPlayerActivity::class.java)
                bundle?.let { intent.putExtras(it) }
                startActivity(intent)
            }
        }
    }

    //show snackbar on mainactivity started
    private fun snackbarOnAboard() {
        val nameIntro = intent.getStringExtra(AppToIntro.USER_NAME)
        val contextView = findViewById<View>(R.id.main_activity)
        val snackbar = Snackbar.make(contextView, "hello $nameIntro ", Snackbar.LENGTH_INDEFINITE)
        snackbar.setAction("tutup") {
            onBackPressedDispatcher
        }.show()
    }
}