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


class Cot7 : Fragment(R.layout.fragment_cot7) {
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        return inflater.inflate(R.layout.fragment_cot7, container, false)
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val btnReg = requireView().findViewById<ImageButton>(R.id.btnReg)
        val btnClavicula = requireView().findViewById<Button>(R.id.btnClavicula)
        val btnCostilla= requireView().findViewById<Button>(R.id.btnCostilla)
        val btnPecho= requireView().findViewById<Button>(R.id.btnPecho)
        val btnAbdomen = requireView().findViewById<Button>(R.id.btnAbdomen)

        btnReg.setOnClickListener{
        }
        btnClavicula.setOnClickListener{
            sendNudes("Clavicula")
        }
        btnCostilla.setOnClickListener{
            sendNudes("Costillas")
        }
        btnPecho.setOnClickListener{
            sendNudes("Pecho")
        }
        btnAbdomen.setOnClickListener{
            sendNudes("Abdomen")

        }
    }
    fun sendNudes(name:String){
        kotlin.run {
            CitaX.zona1 = name
            findNavController().navigate(R.id.action_cot7_to_cot10)
        }
    }
}