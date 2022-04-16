package com.example.guntingbatukertas5

import android.content.ContentValues.TAG
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import com.example.guntingbatukertas5.databinding.ActivityVsComBinding
import com.example.guntingbatukertas5.fragment.DialogFragmentCostum
import com.example.guntingbatukertas5.vscomselection.Selection
import kotlin.random.Random

class VsComActivity : AppCompatActivity() {

    private var selected: Int? = null
    private var marker: Int? = -1

    private var playerOneSelect: Int? = null
    private var playerTwoSelect: Int? = null

    lateinit var binding: ActivityVsComBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityVsComBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val bundle = intent.extras
        val name = bundle?.getString(AppToIntro.USER_NAME)
        supportActionBar?.title = "$name Vs Computer"

        letsPlay()
        reset()

        val costumDialogFragment = DialogFragmentCostum()
        costumDialogFragment.isCancelable = false


        binding.apply {
            //get bundle from mainactivity
            val bundle = intent.extras
            val name = bundle?.getString(AppToIntro.USER_NAME)
            binding.include.tvPlayerVsCom.text = name
        }

    }

    private fun reset() {
        with(binding) {
            ivreset.setImageResource(R.drawable.ic_refresh)
            setBgUserSelection(-1)
            setBgComSelection(-1)
            playerOneSelect = null
            playerTwoSelect = null
        }
    }

    private fun letsPlay() {
        if (selected == 0) {
            marker = 0
            proccedPlayerOne()
            proccedPlayerTwo()
        } else {
            marker = 1
            proccedPlayerOne()
        }
    }

    private fun gameStart(playerOneSelected: Int, playerTwoSelected: Int) {
        if ((playerOneSelected.plus(1)).mod(3) == playerTwoSelected) {
            Log.d(TAG, "Computer won")
            binding.tvResultCenter.text = "Computer WON"

            dialogCostum()

        } else if (playerOneSelected.equals(playerTwoSelected)) {
            Log.d(TAG, " draw")
            binding.tvResultCenter.text = "draw"

            dialogCostum()

        } else {
            Log.d(TAG, "User won")
            binding.tvResultCenter.text = "YOU WIN!!"

            dialogCostum()
        }
    }

    private fun dialogCostum() {
        //dialog costum
        val costumDialogFragment = DialogFragmentCostum()
        costumDialogFragment.show(supportFragmentManager, null)
    }

    private fun proccedPlayerTwo() {
        binding.include2.playerTwoBatu.setOnClickListener {
            Log.e(TAG, "com playing batu")
            playerTwoSelect = 0
            playerOneSelect?.let { it1 -> gameStart(it1, playerTwoSelect!!) }
        }

        binding.include2.playerTwoKertas.setOnClickListener {
            Log.e(TAG, "com playing kertas")
            playerTwoSelect = 1
            playerOneSelect?.let { it1 -> gameStart(it1, playerTwoSelect!!) }
        }

        binding.include2.playerTwoGunting.setOnClickListener {
            Log.e(TAG, "com playing gunting")
            playerTwoSelect = 2
            playerOneSelect?.let { it1 -> gameStart(it1, playerTwoSelect!!) }
        }


    }

    private fun proccedPlayerOne() {
        var random = 0
        binding.include.playerOneBatu.setOnClickListener {
            Log.e(TAG, "player one has selected batu")
            playerOneSelect = 0
            setBgUserSelection(0)

            if (selected != 0) {
                random = Random.nextInt(0, 3)
                setBgComSelection(random)
                gameStart(playerOneSelect!!, random)
            }
            getBundleName("batu")
        }

        binding.include.playerOneKertas.setOnClickListener {
            Log.e(TAG, "player one has selected kertas")
            playerOneSelect = 1
            setBgUserSelection(1)

            if (selected != 0) {
                random = Random.nextInt(0, 3)
                setBgComSelection(random)
                gameStart(playerOneSelect!!, random)
            }
            getBundleName("kertas")
        }

        binding.include.playerOneGunting.setOnClickListener {
            Log.e(TAG, "player one has selected gunting")
            playerOneSelect = 2
            setBgUserSelection(2)

            if (selected != 0) {
                random = Random.nextInt(0, 3)
                setBgComSelection(random)
                gameStart(playerOneSelect!!, random)
            }
            getBundleName("Gunting")
        }
    }

    private fun setBgUserSelection(userSelectionBg: Int) {
        when (Selection.fromSelection(userSelectionBg)) {
            Selection.ROCK -> {
                binding.include.playerOneBatu.setBackgroundColor(
                    ContextCompat.getColor(this, R.color.teal_700)
                )
                binding.include.playerOneGunting.setBackgroundColor(0)
                binding.include.playerOneKertas.setBackgroundColor(0)
            }

            Selection.PAPER -> {
                binding.include.playerOneKertas.setBackgroundColor(
                    ContextCompat.getColor(this, R.color.teal_700)
                )
                binding.include.playerOneGunting.setBackgroundColor(0)
                binding.include.playerOneBatu.setBackgroundColor(2)
            }

            Selection.SCISSOR -> {
                binding.include.playerOneGunting.setBackgroundColor(
                    ContextCompat.getColor(this, R.color.teal_700)
                )
                binding.include.playerOneBatu.setBackgroundColor(0)
                binding.include.playerOneKertas.setBackgroundColor(0)
            }


            else -> {
                binding.include.playerOneBatu.setBackgroundColor(0)
                binding.include.playerOneKertas.setBackgroundColor(0)
                binding.include.playerOneGunting.setBackgroundColor(0)
            }

        }
    }

    private fun setBgComSelection(comRandom: Int) {
        when (Selection.fromSelection(comRandom)) {
            Selection.ROCK -> {
                binding.include2.playerTwoBatu.setBackgroundColor(
                    ContextCompat.getColor(this, R.color.teal_700)
                )
                binding.include2.playerTwoGunting.setBackgroundColor(0)
                binding.include2.playerTwoKertas.setBackgroundColor(0)
            }

            Selection.PAPER -> {
                binding.include2.playerTwoKertas.setBackgroundColor(
                    ContextCompat.getColor(this, R.color.teal_700)
                )
                binding.include2.playerTwoGunting.setBackgroundColor(0)
                binding.include2.playerTwoBatu.setBackgroundColor(2)
            }

            Selection.SCISSOR -> {
                binding.include2.playerTwoGunting.setBackgroundColor(
                    ContextCompat.getColor(this, R.color.teal_700)
                )
                binding.include2.playerTwoBatu.setBackgroundColor(0)
                binding.include2.playerTwoKertas.setBackgroundColor(0)
            }

            else -> {
                binding.include2.playerTwoBatu.setBackgroundColor(0)
                binding.include2.playerTwoKertas.setBackgroundColor(0)
                binding.include2.playerTwoGunting.setBackgroundColor(0)
            }

        }

    }

    private fun getBundleName(chosen: String) {
        val bundle = intent.extras
        val nameGetIntent = bundle?.getString(AppToIntro.USER_NAME)
        Toast.makeText(this, "$nameGetIntent memilih $chosen ", Toast.LENGTH_SHORT).show()
    }

    override fun onBackPressed() {
        finish()
    }


}