package com.example.paulina.menuadmi

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.View
import android.widget.Button
import androidx.navigation.fragment.findNavController
import com.example.paulina.R

class ContenedorMenuAdm: Fragment(R.layout.fragment_menu2) {
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val btnCliente =requireView().findViewById<Button>(R.id.btnCliente)

        btnCliente.setOnClickListener{
            findNavController().navigate(R.id.action_nav_menu_to_login22)
        }
    }
}