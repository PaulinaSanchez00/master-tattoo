package com.example.paulina.preinicio_tarifas

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.navigation.fragment.findNavController
import com.example.paulina.R
import com.example.paulina.database.BD.RegisterDatabase
import kotlinx.coroutines.DelicateCoroutinesApi
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import java.util.concurrent.Executors
import java.util.concurrent.TimeUnit

class PreTarifa11 : Fragment(R.layout.fragment_pre_tarifa11) {

    private lateinit var appDb: RegisterDatabase

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        appDb = RegisterDatabase.getInstance(requireContext())
        val btnCot = requireView().findViewById<Button>(R.id.btnContinuar)
        readStyle()

        Executors.newSingleThreadScheduledExecutor().schedule({
            btnCot.setOnClickListener {
                guardar()
            }
        }, 2, TimeUnit.SECONDS)
    }
    @OptIn(DelicateCoroutinesApi::class)
    private fun readStyle(){
        val precioTattoo = requireView().findViewById<EditText>(R.id.txPrecio)
        val style = "Japones"
        GlobalScope.launch {
            val precio = appDb.TATOOTIPEDao.getPrecio(style)
            precioTattoo.setText(precio.toString())
        }
    }
    @OptIn(DelicateCoroutinesApi::class)
    private fun guardar(){
        val precioTattoo = requireView().findViewById<EditText>(R.id.txPrecio)
        val precio = precioTattoo.text.toString()
        if(precio == ""){
            Toast.makeText(requireContext(),"Ingresa un precio", Toast.LENGTH_SHORT).show()
        }else{
            val prec = precio.toDouble()
            val style = "Japones"
            GlobalScope.launch {
                appDb.TATOOTIPEDao.getupdatePrecio(prec,style)
            }
            precioTattoo.setText("")
            Toast.makeText(requireContext(),"Precio ingresado", Toast.LENGTH_SHORT).show()
            findNavController().navigate(R.id.action_pre_Tarifa11_to_pre_Tarifa12)
        }
    }
}