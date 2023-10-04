package com.example.paulina.menu_cliente.galeria

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.ListView
import androidx.fragment.app.Fragment
import com.example.paulina.database.Entity.IMG
import com.example.paulina.menuadmi.imagenes.ImagenAdapter
import com.example.paulina.menuadmi.trabajo.MisTrabajosModificar
import com.example.paulina.R
import com.example.paulina.database.BD.RegisterDatabase

class GaleriaFragment : Fragment(R.layout.fragment_galeria) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        var lista = emptyList<IMG>()
        val database = RegisterDatabase.getInstance(requireContext())
        database.IMG().getAll().observe(viewLifecycleOwner) {
            lista = it

            val listaimagenes = requireView().findViewById<ListView>(R.id.listaimagenes)
            val adapter = ImagenAdapter(requireContext(), lista)
            listaimagenes.adapter = adapter
        }


        val listaimagenes = requireView().findViewById<ListView>(R.id.listaimagenes)


    }
}