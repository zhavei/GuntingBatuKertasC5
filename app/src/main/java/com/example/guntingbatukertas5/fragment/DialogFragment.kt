package com.example.guntingbatukertas5.fragment

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.DialogFragment
import androidx.fragment.app.Fragment
import com.example.guntingbatukertas5.AppToIntro
import com.example.guntingbatukertas5.MainActivity
import com.example.guntingbatukertas5.databinding.DialogCostumDialogBinding

class DialogFragment : DialogFragment() {

    private var binding : DialogCostumDialogBinding? = null

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DialogCostumDialogBinding.inflate(inflater)
        return binding?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        binding?.apply {

            mainLagi.setOnClickListener {
                dismiss()
            }
            kembaliKeMenu.setOnClickListener {
                val intent = Intent(context, MainActivity::class.java)
                startActivity(intent)
            }

            tvResultWhosPlayerWin.text = "Hebat"
        }
    }

}