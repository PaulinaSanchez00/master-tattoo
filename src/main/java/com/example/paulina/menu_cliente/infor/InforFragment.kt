package com.example.paulina.menu_cliente.infor

import android.content.Context
import android.net.Uri
import android.os.Bundle
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.fragment.app.Fragment
import com.example.paulina.R
import com.example.paulina.database.BD.RegisterDatabase
import kotlinx.coroutines.DelicateCoroutinesApi
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import java.io.File

class InforFragment : Fragment(R.layout.fragment_infor) {

    private lateinit var appDb: RegisterDatabase

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        appDb = RegisterDatabase.getInstance(requireContext())
        val imageUri = getImageUri(requireContext(),2, "logo")
        val mostrar =requireView().findViewById<ImageView>(R.id.imgMostrar)
        mostrar.setImageURI(imageUri)
        readInfo()
    }
    private fun getImageUri(context: Context, id:Long,nombre:String): Uri {
        val file = File(context.filesDir,id.toString()+nombre)
        return  if (file.exists()) Uri.fromFile(file)
        else Uri.parse("android.resource://com.example.paulina/drawable/sinimagen")
    }
    @OptIn(DelicateCoroutinesApi::class)
    private fun readInfo() {
        val facebook = requireView().findViewById<TextView>(R.id.facebook)
        val id = 1
        GlobalScope.launch {
            val face = appDb.INFODao.getContacto(id)
            facebook.text = face
        }
        val instagram = requireView().findViewById<TextView>(R.id.instagram)
        val id2 = 2
        GlobalScope.launch { val ins = appDb.INFODao.getContacto(id2)
            instagram.text = ins
        }
        val whatsapp = requireView().findViewById<TextView>(R.id.whatsapp)
        val id3 = 3
        GlobalScope.launch { val whats = appDb.INFODao.getContacto(id3)
            whatsapp.text = whats
        }
        val estudio = requireView().findViewById<TextView>(R.id.estudio)
        val id4 = 1
        GlobalScope.launch { val es = appDb.ESTUDIODao.getNombre(id4)
            estudio.text = es
        }
    }
}
