package com.example.android_nhom9_w5.presentation.Boarding

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.android_nhom9_w5.R
import kotlinx.android.synthetic.main.fragment_onboarding_three.*

class BoardingThreeFragment: Fragment(){
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_onboarding_three,container,false)
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        btn_next.setOnClickListener {
            findNavController().navigate(R.id.action_boardingThreeFragment_to_welcomeFragment)
        }
    }
}