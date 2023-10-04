package com.example.paulina.menu_cliente.estudio

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.View
import android.widget.ImageButton
import android.widget.TextView
import androidx.fragment.app.Fragment
import com.example.paulina.R
import com.example.paulina.database.BD.RegisterDatabase
import kotlinx.coroutines.DelicateCoroutinesApi
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class EstudioFragment : Fragment(R.layout.fragment_estudio){

    private lateinit var appDb: RegisterDatabase

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        appDb = RegisterDatabase.getInstance(requireContext())
        readInfo()

        val mapa = requireView().findViewById<ImageButton>(R.id.Mapa)


        val link = requireView().findViewById<TextView>(R.id.link)
        val id6 = 1
        @OptIn(DelicateCoroutinesApi::class)
        GlobalScope.launch { val des = appDb.ESTUDIODao.getLink(id6)
            link.text = des
        }

        mapa.setOnClickListener{
            val openURL= Intent(Intent.ACTION_VIEW)
            openURL.data= Uri.parse(link.text.toString())
            startActivity(openURL)
        }
    }
    @OptIn(DelicateCoroutinesApi::class)
    private fun readInfo(){
        val domicilio = requireView().findViewById<TextView>(R.id.domicilio)
        val id4 = 1
        GlobalScope.launch { val dom = appDb.ESTUDIODao.getDireccion(id4)
            domicilio.text = dom
        }
        val estudio = requireView().findViewById<TextView>(R.id.estudio)
        val id5 = 1
        GlobalScope.launch { val est = appDb.ESTUDIODao.getNombre(id5)
            estudio.text = est
        }
        val descripcion = requireView().findViewById<TextView>(R.id.descripcion)
        val id6 = 1
        GlobalScope.launch { val des = appDb.ESTUDIODao.getDescripcion(id6)
            descripcion.text = des
        }
    }
}