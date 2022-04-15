package com.example.guntingbatukertas5.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.guntingbatukertas5.abstract.FragmentListener
import com.example.guntingbatukertas5.databinding.UserInputFragmentBinding

class UserInputFragment : Fragment(), FragmentListener {

    private var binding: UserInputFragmentBinding? = null

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = UserInputFragmentBinding.inflate(inflater)
        return binding?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        println("layout fragment created")
    }

    override fun getTextValue(): String {
        val name = binding?.etInputName?.text.toString()
        return name
    }

}