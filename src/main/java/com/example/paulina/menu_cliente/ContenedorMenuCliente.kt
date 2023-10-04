package com.example.paulina.menu_cliente

import android.content.Context
import android.net.Uri
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.View
import android.widget.Button
import android.widget.ImageView
import androidx.navigation.fragment.findNavController
import com.example.paulina.R
import java.io.File

class ContenedorMenuCliente : Fragment(R.layout.fragment_menuc2) {
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val imageUri = getImageUri(requireContext(),2,"logo")
        val mostrar =requireView().findViewById<ImageView>(R.id.logo)
        mostrar.setImageURI(imageUri)

        val btnCliente =requireView().findViewById<Button>(R.id.btnAdministrador)
        btnCliente.setOnClickListener{
            findNavController().navigate(R.id.action_menuc2_to_cliente_Adm)
        }
    }
    private fun getImageUri(context: Context, id:Long,nombre:String): Uri {
        val file = File(context.filesDir, id.toString() + nombre)
        return  if (file.exists()) Uri.fromFile(file)
        else Uri.parse("android.resource://com.example.paulina/drawable/logo")
    }
}