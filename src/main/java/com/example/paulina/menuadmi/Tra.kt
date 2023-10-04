package com.example.paulina.menuadmi

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.View
import android.widget.ListView
import com.example.paulina.database.Entity.IMG
import com.example.paulina.menuadmi.imagenes.ImagenAdapter
import com.example.paulina.menuadmi.trabajo.MisTrabajosModificar
import com.example.paulina.menuadmi.imagenes.NuevaImagen
import com.example.paulina.R
import com.example.paulina.database.BD.RegisterDatabase
import com.google.android.material.floatingactionbutton.FloatingActionButton

class Tra : Fragment(R.layout.fragment_tra) {

    /*private val requestGallery = 1001
    private var imagenUr: Uri? = null*/

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

        listaimagenes.setOnItemClickListener { _, _, position, _ ->
            val intent = Intent(requireContext(), MisTrabajosModificar::class.java)
            intent.putExtra("id", lista[position].ID)
            startActivity(intent)
        }

        val floatingActionButton2 =
            requireView().findViewById<FloatingActionButton>(R.id.floatingActionButton2)
        floatingActionButton2.setOnClickListener {
            val intent = Intent(requireContext(), NuevaImagen::class.java)
            startActivity(intent)
        }

    }
}