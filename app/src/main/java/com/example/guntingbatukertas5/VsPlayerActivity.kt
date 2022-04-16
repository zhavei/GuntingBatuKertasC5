package com.example.guntingbatukertas5

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.guntingbatukertas5.databinding.ActivityVsPlayerBinding
import com.example.guntingbatukertas5.fragment.DialogFragmentCostum

class VsPlayerActivity : AppCompatActivity() {
    lateinit var binding: ActivityVsPlayerBinding

    private var statusRock1: Boolean = false
    private var statusPaper1: Boolean = false
    private var statusScissor1: Boolean = false
    private var statusRock2: Boolean = false
    private var statusPaper2: Boolean = false
    private var statusScissor2: Boolean = false
    private var optionP1 = 0
    private var optionP2 = 0
    private var finalResult = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityVsPlayerBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val bundle = intent.extras
        val name = bundle?.getString(AppToIntro.USER_NAME)
        supportActionBar?.title = "$name Vs Player 2"

        playerOne()
        playerTwo()

        val dialogCostum = DialogFragmentCostum()
        dialogCostum.isCancelable = false

        binding.apply {
            //get bundle from mainactivity
            val bundle = intent.extras
            val name = bundle?.getString(AppToIntro.USER_NAME)
            include.tvPlayerVsCom.text = name
            include2.tvPlayerVsComIsCom.text = "Player 2"

            ivMulaiPlayervsplayer.setOnClickListener {
                result()
                clearOption()
            }

        }

    }

    private fun clearOption() {
        val playerOptionTwo = binding.include2
        val playerOptionOne = binding.include
        binding.apply {
            playerOptionOne.playerOneBatu.setImageResource(R.drawable.ic_batu)
            playerOptionOne.playerOneKertas.setImageResource(R.drawable.ic_kertas)
            playerOptionOne.playerOneGunting.setImageResource(R.drawable.ic_gunting)
            playerOptionTwo.playerTwoBatu.setImageResource(R.drawable.ic_batu)
            playerOptionTwo.playerTwoKertas.setImageResource(R.drawable.ic_kertas)
            playerOptionTwo.playerTwoGunting.setImageResource(R.drawable.ic_gunting)
            statusRock1 = false
            statusPaper1 = false
            statusScissor1 = false
            statusRock2 = false
            statusPaper2 = false
            statusScissor2 = false
            optionP1 = 0
            optionP2 = 0
        }
    }

    private fun result() {
        if (optionP1 == 0 && optionP2 == 0) {
            finalResult = "Pilih dulu"
        } else if (optionP2 == 0) {
            finalResult = "Pilih dulu"
        } else if (optionP1 == 0) {
            finalResult = "Pilih dulu"
        } else if (optionP1 == 1 && optionP2 == 1) {
            finalResult = "Seri"
            dialogCostum()
        } else if (optionP1 == 2 && optionP2 == 2) {
            finalResult = "Seri"
            dialogCostum()
        } else if (optionP1 == 3 && optionP2 == 3) {
            finalResult = "Seri"
            dialogCostum()
        } else if (optionP1 == 1 && optionP2 == 3) {
            finalResult = "Player 1 Menang!"
            dialogCostum()
        } else if (optionP1 == 2 && optionP2 == 1) {
            finalResult = "Player 1 Menang!!"
            dialogCostum()
        } else if (optionP1 == 3 && optionP2 == 2) {
            finalResult = "Player 1 Menang!!"
            dialogCostum()
        } else if (optionP1 == 1 && optionP2 == 2) {
            finalResult = "Player 2 Menang!!"
            dialogCostum()
        } else if (optionP1 == 3 && optionP2 == 1) {
            finalResult = "Player 2 Menang!!"
            dialogCostum()
        } else if (optionP1 == 2 && optionP2 == 3) {
            finalResult = "Player 2 Menang!!"
            dialogCostum()
        }
        Toast.makeText(this, finalResult, Toast.LENGTH_SHORT).show()
    }

    private fun dialogCostum() {
        //dialog costum
        val costumDialogFragment = DialogFragmentCostum()
        costumDialogFragment.show(supportFragmentManager, null)
    }

    private fun playerTwo() {
        val playerOptionTwo = binding.include2
        binding.apply {
            playerOptionTwo.playerTwoBatu.setOnClickListener {
                if (statusRock2) {
                    playerOptionTwo.playerTwoBatu.setImageResource(R.drawable.ic_batu)
                    playerOptionTwo.playerTwoKertas.setImageResource(R.drawable.ic_kertas)
                    playerOptionTwo.playerTwoGunting.setImageResource(R.drawable.ic_gunting)
                    statusRock2 = false
                    statusPaper2 = false
                    statusScissor2 = false
                } else {
                    playerOptionTwo.playerTwoBatu.setImageResource(R.drawable.batu_selected)
                    playerOptionTwo.playerTwoKertas.setImageResource(R.drawable.ic_kertas)
                    playerOptionTwo.playerTwoGunting.setImageResource(R.drawable.ic_gunting)
                    statusRock2 = true
                    statusPaper2 = false
                    statusScissor2 = false
                    optionP2 = 1
                }
            }

            playerOptionTwo.playerTwoKertas.setOnClickListener {
                if (statusPaper2) {
                    playerOptionTwo.playerTwoBatu.setImageResource(R.drawable.ic_batu)
                    playerOptionTwo.playerTwoKertas.setImageResource(R.drawable.ic_kertas)
                    playerOptionTwo.playerTwoGunting.setImageResource(R.drawable.ic_gunting)
                    statusRock2 = false
                    statusPaper2 = false
                    statusScissor2 = false
                } else {
                    playerOptionTwo.playerTwoBatu.setImageResource(R.drawable.ic_batu)
                    playerOptionTwo.playerTwoKertas.setImageResource(R.drawable.kertas_selected)
                    playerOptionTwo.playerTwoGunting.setImageResource(R.drawable.ic_gunting)
                    statusPaper2 = true
                    statusRock2 = false
                    statusScissor2 = false
                    optionP2 = 2
                }
            }

            playerOptionTwo.playerTwoGunting.setOnClickListener {
                if (statusScissor2) {
                    playerOptionTwo.playerTwoBatu.setImageResource(R.drawable.ic_batu)
                    playerOptionTwo.playerTwoKertas.setImageResource(R.drawable.ic_kertas)
                    playerOptionTwo.playerTwoGunting.setImageResource(R.drawable.ic_gunting)
                    statusRock2 = false
                    statusPaper2 = false
                    statusScissor2 = false
                } else {
                    playerOptionTwo.playerTwoBatu.setImageResource(R.drawable.ic_batu)
                    playerOptionTwo.playerTwoKertas.setImageResource(R.drawable.ic_kertas)
                    playerOptionTwo.playerTwoGunting.setImageResource(R.drawable.gunting_selected)
                    statusPaper2 = false
                    statusRock2 = false
                    statusScissor2 = true
                    optionP2 = 3
                }
            }
        }

    }

    private fun playerOne() {
        binding.apply {
            val playerOptionOne = binding.include
            playerOptionOne.playerOneBatu.setOnClickListener {
                if (statusRock1) {
                    playerOptionOne.playerOneBatu.setImageResource(R.drawable.ic_batu)
                    playerOptionOne.playerOneKertas.setImageResource(R.drawable.ic_kertas)
                    playerOptionOne.playerOneGunting.setImageResource(R.drawable.ic_gunting)
                    statusRock1 = false
                    statusPaper1 = false
                    statusScissor1 = false
                } else {
                    playerOptionOne.playerOneBatu.setImageResource(R.drawable.batu_selected)
                    playerOptionOne.playerOneKertas.setImageResource(R.drawable.ic_kertas)
                    playerOptionOne.playerOneGunting.setImageResource(R.drawable.ic_gunting)
                    statusRock1 = true
                    statusPaper1 = false
                    statusScissor1 = false
                    optionP1 = 1
                }
            }

            playerOptionOne.playerOneKertas.setOnClickListener {
                if (statusPaper1) {
                    playerOptionOne.playerOneBatu.setImageResource(R.drawable.ic_batu)
                    playerOptionOne.playerOneKertas.setImageResource(R.drawable.ic_kertas)
                    playerOptionOne.playerOneGunting.setImageResource(R.drawable.ic_gunting)
                    statusRock1 = false
                    statusPaper1 = false
                    statusScissor1 = false
                } else {
                    playerOptionOne.playerOneBatu.setImageResource(R.drawable.ic_batu)
                    playerOptionOne.playerOneKertas.setImageResource(R.drawable.kertas_selected)
                    playerOptionOne.playerOneGunting.setImageResource(R.drawable.ic_gunting)
                    statusPaper1 = true
                    statusRock1 = false
                    statusScissor1 = false
                    optionP1 = 2
                }
            }

            playerOptionOne.playerOneGunting.setOnClickListener {
                if (statusScissor1) {
                    playerOptionOne.playerOneBatu.setImageResource(R.drawable.ic_batu)
                    playerOptionOne.playerOneKertas.setImageResource(R.drawable.ic_kertas)
                    playerOptionOne.playerOneGunting.setImageResource(R.drawable.ic_gunting)
                    statusRock1 = false
                    statusPaper1 = false
                    statusScissor1 = false
                } else {
                    playerOptionOne.playerOneBatu.setImageResource(R.drawable.ic_batu)
                    playerOptionOne.playerOneKertas.setImageResource(R.drawable.ic_kertas)
                    playerOptionOne.playerOneGunting.setImageResource(R.drawable.gunting_selected)
                    statusPaper1 = false
                    statusRock1 = false
                    statusScissor1 = true
                    optionP1 = 3
                }
            }
        }
    }
}