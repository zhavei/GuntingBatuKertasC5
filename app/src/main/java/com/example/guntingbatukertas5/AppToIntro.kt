package com.example.guntingbatukertas5

import android.content.Intent
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import androidx.fragment.app.Fragment
import com.github.appintro.AppIntro
import com.github.appintro.AppIntroCustomLayoutFragment.Companion.newInstance
import com.github.appintro.AppIntroFragment

class AppToIntro : AppIntro() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        window.setBackgroundDrawable(ColorDrawable(Color.BLUE))
        supportActionBar?.hide()
        //layout was handle by library
        addSlide(
            AppIntroFragment.createInstance(
                imageDrawable = R.drawable.ic_landing_page1,
                description = "Bermain Suit Melawan Sesama Pemain"
            )
        )
        addSlide(
            AppIntroFragment.createInstance(
                imageDrawable = R.drawable.ic_landing_page2,
                description = "Bermain Suit Melawan Komputer"
            )
        )

        ifUserSkiped()
        showStatusBar(true)
//        setStatusBarColorRes(R.color.orange)
//        setNavBarColorRes(R.color.orange)
        setProgressIndicator()

    }

//    override fun onSkipPressed(currentFragment: Fragment?) {
//        super.onSkipPressed(currentFragment)
//        onNextSlide()
//    }

    //coba di bikin activityny buat holder editext usernamenya

    override fun onDonePressed(currentFragment: Fragment?) {
        super.onDonePressed(currentFragment)
        toMainActivty()
    }

    private fun ifUserSkiped() {
        addSlide(newInstance(R.layout.intro_custom_layout1))
    }

    private fun toMainActivty() {
        val intent = Intent(this, MainActivity::class.java)
        startActivity(intent)
        finish()
    }
}