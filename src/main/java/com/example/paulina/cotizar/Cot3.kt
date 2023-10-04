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

class Cot3 : Fragment(R.layout.fragment_cot3) {
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        return inflater.inflate(R.layout.fragment_cot3, container, false)
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val btnReg = requireView().findViewById<ImageButton>(R.id.btnReg)
        val btnDedos = requireView().findViewById<Button>(R.id.btnDedos)
        val btnMuneca = requireView().findViewById<Button>(R.id.btnMuñeca)
        val btnAntebrazo = requireView().findViewById<Button>(R.id.btnAntebrazo)
        val btnCodo = requireView().findViewById<Button>(R.id.btnCodo)
        val btnBicep = requireView().findViewById<Button>(R.id.btnBicep)
        val btnHombro = requireView().findViewById<Button>(R.id.btnHombro)
        val btnMano = requireView().findViewById<Button>(R.id.btnMano)

        btnReg.setOnClickListener{
            findNavController().navigate(R.id.action_cot3_to_cot2)
        }
        btnDedos.setOnClickListener{
            sendNudes("Dedos")
        }
        btnMuneca.setOnClickListener{
            sendNudes("Muñeca")
        }
        btnAntebrazo.setOnClickListener{
            sendNudes("Antebrazo")
        }
        btnCodo.setOnClickListener{
            sendNudes("Codo")
        }
        btnBicep.setOnClickListener{
            sendNudes("Bicep")
        }
        btnHombro.setOnClickListener{
            sendNudes("Hombro")
        }
        btnMano.setOnClickListener{
            sendNudes("Mano")
        }
    }
    fun sendNudes(name:String){
        kotlin.run {
            CitaX.zona1 = name
            findNavController().navigate(R.id.action_cot3_to_cot10)
        }
    }
}