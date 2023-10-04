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

class Cot5 : Fragment(R.layout.fragment_cot5) {
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        return inflater.inflate(R.layout.fragment_cot5, container, false)
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val btnReg = requireView().findViewById<ImageButton>(R.id.btnReg)
        val btnCoxis = requireView().findViewById<Button>(R.id.btnCoxis)
        val btnCadera= requireView().findViewById<Button>(R.id.btnCadera)
        val btnGluteo = requireView().findViewById<Button>(R.id.btnGluteo)

        btnReg.setOnClickListener{
            findNavController().navigate(R.id.action_cot5_to_cot2)
        }
        btnCoxis.setOnClickListener{
           sendNudes("Coxis")
        }
        btnCadera.setOnClickListener{
            sendNudes("Cadera")
        }
        btnGluteo.setOnClickListener{
            sendNudes("Gluteo")
        }
    }

    fun sendNudes(name:String){
        kotlin.run {
            CitaX.zona1 = name
            findNavController().navigate(R.id.action_cot5_to_cot10)
        }
    }
}