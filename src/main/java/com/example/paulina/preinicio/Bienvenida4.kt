package com.example.paulina.preinicio

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.View
import android.widget.Button
import androidx.navigation.fragment.findNavController
import com.example.paulina.R

class Bienvenida4 : Fragment(R.layout.fragment_bienvenida4) {
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val btnCot = requireView().findViewById<Button>(R.id.btnContinuar)

        btnCot.setOnClickListener {
            findNavController().navigate(R.id.action_bienvenida4_to_bienvenida5)
        }
    }
}