package com.example.guntingbatukertas5

import android.content.Intent
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import androidx.fragment.app.Fragment
import com.example.guntingbatukertas5.abstract.FragmentListener
import com.example.guntingbatukertas5.fragment.UserInputFragment
import com.github.appintro.AppIntro
import com.github.appintro.AppIntroCustomLayoutFragment.Companion.newInstance
import com.github.appintro.AppIntroFragment

class AppToIntro : AppIntro() {


    companion object {
        const val USER_NAME = "user_name"

        private val userInputFragment: UserInputFragment by lazy {
            UserInputFragment()
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        window.setBackgroundDrawable(ColorDrawable(Color.DKGRAY))
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

        addSlide(userInputFragment)

        //showStatusBar(true)
        setProgressIndicator()

    }

    override fun onSkipPressed(currentFragment: Fragment?) {
        super.onSkipPressed(currentFragment)
        ifUserSkiped()
    }

    //coba di bikin activityny buat holder editext usernamenya

    override fun onDonePressed(currentFragment: Fragment?) {
        super.onDonePressed(currentFragment)
        toMainActivty()
        finish()
    }

    //masih beloman cara pindah ke fragment
    private fun ifUserSkiped() {
        val fragmentUserInput = UserInputFragment()
        //fragmentManager.beginTransaction().replace(R.id.user_input_fragment, )
    }

    private fun toMainActivty() {
        val fragmentListener = userInputFragment as FragmentListener
        val name = fragmentListener.getTextValue()

        val intent = Intent(this, MainActivity::class.java)
        intent.putExtra(USER_NAME, name)
        startActivity(intent)
    }
}