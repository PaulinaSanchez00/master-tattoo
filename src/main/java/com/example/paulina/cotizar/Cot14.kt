package com.example.paulina.cotizar

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.ImageButton
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.paulina.R
import com.example.paulina.cotizar.citax.CitaX
import com.example.paulina.database.BD.RegisterDatabase
import com.example.paulina.database.Entity.RESULTADO
import kotlinx.coroutines.DelicateCoroutinesApi
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import kotlin.math.roundToInt

class Cot14 : Fragment(R.layout.fragment_cot14) {

    private lateinit var appBd: RegisterDatabase

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        appBd = RegisterDatabase.getInstance(requireContext())

        val res = requireView().findViewById<TextView>(R.id.txtResult)
        @OptIn(DelicateCoroutinesApi::class)
        GlobalScope.launch {
            val resp = appBd.RESULTADODao.getResul()
            val roundoff = (resp * 100.0).roundToInt() / 100.0
            res.text = roundoff.toString()
            println(roundoff)
        }
        val zon = requireView().findViewById<TextView>(R.id.txtZona)
        zon.text = "Zona: ${CitaX.zona}, ${CitaX.zona1}"

        val tamano = requireView().findViewById<TextView>(R.id.txtTamano)
        tamano.text = "Tamaño: ${CitaX.tamano.toString()} cm"

        val colores = requireView().findViewById<TextView>(R.id.txtColores)
        colores.text = "Colores: ${CitaX.colors.toString()}"

        val tono = requireView().findViewById<TextView>(R.id.txtTono)
        tono.text = "Tono de piel: ${CitaX.tono}"

        val estilo = requireView().findViewById<TextView>(R.id.txtEstilo)
        estilo.text = "Estilo: ${CitaX.Estilo}"

        val btnReg = requireView().findViewById<ImageButton>(R.id.btnReg)
        btnReg.setOnClickListener {
            findNavController().navigate(R.id.action_cot14_to_cot13)
        }

        val btnCancelar = requireView().findViewById<Button>(R.id.btnCancelar)
        btnCancelar.setOnClickListener {
            findNavController().navigate(R.id.action_cot14_to_cot)
            GlobalScope.launch {
                val precio = appBd.RESULTADODao.getResul()
                appBd.RESULTADODao.deleteAll()
            }

        }

    }
}