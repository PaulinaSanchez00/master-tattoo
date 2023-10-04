package com.example.paulina.cotizar

import android.os.Bundle
import android.view.LayoutInflater
import androidx.fragment.app.Fragment
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import androidx.navigation.fragment.findNavController
import com.example.paulina.R
import com.example.paulina.cotizar.citax.CitaX

class Cot10 : Fragment(R.layout.fragment_cot10) {
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        return inflater.inflate(R.layout.fragment_cot10, container, false)
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val btnReg = requireView().findViewById<ImageButton>(R.id.btnReg)
        val btnT1 = requireView().findViewById<ImageButton>(R.id.btnMoreno)
        val btnT2 = requireView().findViewById<ImageButton>(R.id.btnMorenoClaro)
        val btnT3 = requireView().findViewById<ImageButton>(R.id.btnBlancoMoreno)
        val btnT4 = requireView().findViewById<ImageButton>(R.id.btnBlancoClaro)

        btnReg.setOnClickListener{
            findNavController().navigate(R.id.action_cot10_to_cot2)
        }
        btnT1.setOnClickListener{
            sendNudes("Moreno")
        }
        btnT2.setOnClickListener{
            sendNudes("Moreno Claro")
        }
        btnT3.setOnClickListener{
            sendNudes("Blanco")
        }
        btnT4.setOnClickListener{
            sendNudes("Blanco Claro")
        }
    }
    private fun sendNudes(name:String){
        kotlin.run {
            CitaX.tono = name
            findNavController().navigate(R.id.action_cot10_to_cot11)
        }
    }
}