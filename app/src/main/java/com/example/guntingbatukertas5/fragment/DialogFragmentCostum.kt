package com.example.guntingbatukertas5.fragment

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.DialogFragment
import com.example.guntingbatukertas5.MainActivity
import com.example.guntingbatukertas5.databinding.DialogCostumDialogBinding

class DialogFragmentCostum : DialogFragment() {

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

        val costumDialogFragment = com.example.guntingbatukertas5.fragment.DialogFragmentCostum()
        costumDialogFragment.isCancelable = false

        binding?.apply {

            mainLagi.setOnClickListener {
                dismiss()
            }
            kembaliKeMenu.setOnClickListener {
                val intent = Intent(context, MainActivity::class.java)
                startActivity(intent)
                activity?.fragmentManager?.popBackStack()
            }

            tvResultWhosPlayerWin.text = "Hebat"
        }
    }

}