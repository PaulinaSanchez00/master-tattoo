package com.example.paulina.preinicio

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.View
import android.widget.ProgressBar
import androidx.navigation.fragment.findNavController
import com.example.paulina.R
import java.util.concurrent.Executors
import java.util.concurrent.TimeUnit

class Bienvenida5 : Fragment(R.layout.fragment_bienvenida5) {
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val btnCot = requireView().findViewById<ProgressBar>(R.id.btnContinuar)

        Executors.newSingleThreadScheduledExecutor().schedule({
            findNavController().navigate(R.id.action_bienvenida5_to_loginFragment)
        }, 3, TimeUnit.SECONDS)
    }
}