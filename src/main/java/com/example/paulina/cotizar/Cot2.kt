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

class Cot2 : Fragment(R.layout.fragment_cot2) {
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        return inflater.inflate(R.layout.fragment_cot2, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val btnReg = requireView().findViewById<ImageButton>(R.id.btnReg)
        val btnBrazo = requireView().findViewById<Button>(R.id.btnBrazo1)
        val btnEspalda = requireView().findViewById<Button>(R.id.btnEspalda1)
        val btnGluteo = requireView().findViewById<Button>(R.id.btnGluteo1)
        val btnPierna = requireView().findViewById<Button>(R.id.btnPierna1)
        val btnAbdomen = requireView().findViewById<Button>(R.id.btnAbdomen1)
        val btnCara1 = requireView().findViewById<Button>(R.id.btnCara1)

        btnReg.setOnClickListener{
            findNavController().navigate(R.id.action_cot2_to_cot)
        }
        btnBrazo.setOnClickListener{
            sendNudes("Brazo")
            findNavController().navigate(R.id.action_cot2_to_cot3)

        }
        btnEspalda.setOnClickListener{
            sendNudes("Espalda")
            findNavController().navigate(R.id.action_cot2_to_cot4)

        }
        btnGluteo.setOnClickListener{
            sendNudes("")
            findNavController().navigate(R.id.action_cot2_to_cot5)
        }
        btnPierna.setOnClickListener{
            sendNudes("Pierma")
            findNavController().navigate(R.id.action_cot2_to_cot6)
        }
        btnAbdomen.setOnClickListener{
            sendNudes("Abddomen")
            findNavController().navigate(R.id.action_cot2_to_cot7)
        }
        btnCara1.setOnClickListener{
            sendNudes("Cara")
            findNavController().navigate(R.id.action_cot2_to_cot8)
        }
    }
    private fun sendNudes(name:String){
        kotlin.run {
            CitaX.zona = name
        }
    }
}