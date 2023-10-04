package com.example.paulina.cotizar

import android.os.Bundle
import android.view.LayoutInflater
import androidx.fragment.app.Fragment
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageButton
import androidx.navigation.fragment.findNavController
import com.example.paulina.R
import com.example.paulina.cotizar.citax.CitaX

class Cot8 : Fragment(R.layout.fragment_cot8) {
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        return inflater.inflate(R.layout.fragment_cot8, container, false)
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val btnReg = requireView().findViewById<ImageButton>(R.id.btnReg)
        val btnOreja= requireView().findViewById<Button>(R.id.btnOreja)
        val btnCaraC8= requireView().findViewById<Button>(R.id.btnCaraC8)
        val btnCuello = requireView().findViewById<Button>(R.id.btnCuello)


        btnReg.setOnClickListener{
            findNavController().navigate(R.id.action_cot8_to_cot2)
        }
        btnOreja.setOnClickListener { sendNudes("Oreja") }
        btnCaraC8.setOnClickListener{ sendNudes("Cara") }
        btnCuello.setOnClickListener{ sendNudes("Cuello") }
    }
    fun sendNudes(name:String){
        kotlin.run {
            CitaX.zona1 = name
            findNavController().navigate(R.id.action_cot8_to_cot10)
        }
    }
}