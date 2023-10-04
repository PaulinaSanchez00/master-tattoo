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

class Cot4 : Fragment(R.layout.fragment_cot4) {
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        return inflater.inflate(R.layout.fragment_cot4, container, false)
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val btnReg = requireView().findViewById<ImageButton>(R.id.btnReg)
        val btnPaleta = requireView().findViewById<Button>(R.id.btnPaleta)
        val btnEspalda= requireView().findViewById<Button>(R.id.btnEspalda)
        val btnColumna = requireView().findViewById<Button>(R.id.btnColumna)


        btnReg.setOnClickListener{
            findNavController().navigate(R.id.action_cot4_to_cot2)
        }
        btnPaleta.setOnClickListener{
            sendNudes("Paleta")
        }
        btnEspalda.setOnClickListener{
            sendNudes("Espalda")
        }
        btnColumna.setOnClickListener{
            sendNudes("Columna")
        }

    }

    fun sendNudes(name:String){
        kotlin.run {
            CitaX.zona1 = name
            findNavController().navigate(R.id.action_cot4_to_cot10)
        }
    }
}