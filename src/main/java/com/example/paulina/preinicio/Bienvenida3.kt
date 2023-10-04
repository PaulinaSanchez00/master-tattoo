package com.example.paulina.preinicio

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.View
import android.widget.Button
import androidx.navigation.fragment.findNavController
import com.example.paulina.R
import com.example.paulina.database.BD.RegisterDatabase

class Bienvenida3 : Fragment(R.layout.fragment_bienvenida3) {

    private lateinit var appDb: RegisterDatabase

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        appDb = RegisterDatabase.getInstance(requireContext())

        val btnCot = requireView().findViewById<Button>(R.id.btnContinuar)
        btnCot.setOnClickListener {
            @Suppress("UNUSED VARIABLE")
            findNavController().navigate(R.id.action_bienvenida32_to_registerFragment)
        }
    }
}