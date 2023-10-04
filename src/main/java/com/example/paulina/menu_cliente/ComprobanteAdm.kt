package com.example.paulina.menu_cliente

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.View
import android.widget.Button
import androidx.navigation.fragment.findNavController
import com.example.paulina.R

class ComprobanteAdm : Fragment(R.layout.fragment_comprobante_adm) {
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val btnCot = requireView().findViewById<Button>(R.id.btnContinuar)

        btnCot.setOnClickListener {
            @Suppress("UNUSED VARIABLE")
            findNavController().navigate(R.id.action_comprobante_Adm_to_loginFragment2)
        }
    }
}