package com.example.paulina.cotizar

import android.os.Bundle
import android.view.LayoutInflater
import androidx.fragment.app.Fragment
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.navigation.fragment.findNavController
import com.example.paulina.R

class Cot : Fragment(R.layout.fragment_cot) {
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        return inflater.inflate(R.layout.fragment_cot, container, false)
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val btnCot =requireView().findViewById<Button>(R.id.btn)

        btnCot.setOnClickListener{
            findNavController().navigate(R.id.action_cot_to_cot2)
        }
    }
}