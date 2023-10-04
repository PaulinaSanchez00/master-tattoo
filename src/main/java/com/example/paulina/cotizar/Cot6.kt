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

class Cot6 : Fragment(R.layout.fragment_cot6) {
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        return inflater.inflate(R.layout.fragment_cot6, container, false)
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val btnReg = requireView().findViewById<ImageButton>(R.id.btnReg)
        val btnRodilla = requireView().findViewById<Button>(R.id.btnRodilla)
        val btnPierna= requireView().findViewById<Button>(R.id.btnPierna)
        val btnPie = requireView().findViewById<Button>(R.id.btnPie)
        val btnMuslo = requireView().findViewById<Button>(R.id.btnMuslo)
        val btnPantorrilla= requireView().findViewById<Button>(R.id.btnPantorrilla)
        val btnTobillo = requireView().findViewById<Button>(R.id.btnTobillo)

        btnReg.setOnClickListener{
            findNavController().navigate(R.id.action_cot6_to_cot2)
        }
        btnRodilla.setOnClickListener{
            sendNudes("Rodilla")
        }
        btnPierna.setOnClickListener{
            sendNudes("Pierna")
        }
        btnPie.setOnClickListener{
            sendNudes("Pie")
        }
        btnMuslo.setOnClickListener{
            sendNudes("Muslo")
        }
        btnPantorrilla.setOnClickListener{
            sendNudes("Pantorrilla")
        }
        btnTobillo.setOnClickListener{
           sendNudes("Tobillo")

        }
    }
    fun sendNudes(name:String){
        kotlin.run {
            CitaX.zona1 = name
            findNavController().navigate(R.id.action_cot6_to_cot10)
        }
    }
}