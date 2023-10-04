package com.example.paulina.menuadmi.estilos

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.widget.SwitchCompat
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.paulina.R
import com.example.paulina.database.BD.RegisterDatabase
import kotlinx.coroutines.*

class EstilosFragment : Fragment(R.layout.fragment_estilos) {
    private val TAG = "EstilosFragment"

    private lateinit var appDb: RegisterDatabase

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val btn = requireView().findViewById<Button>(R.id.btnSave)
        appDb = RegisterDatabase.getInstance(requireContext())
        setGetE()
        btn.setOnClickListener {
            chekedE()
        }
    }

    private fun swListEx(): List<SwitchCompat> {
        val swReal = requireView().findViewById<SwitchCompat>(R.id.SWRealism)
        val swTrash = requireView().findViewById<SwitchCompat>(R.id.SWTrash)
        val swTrad = requireView().findViewById<SwitchCompat>(R.id.SWTrad)
        val swTrib = requireView().findViewById<SwitchCompat>(R.id.SWTribal)
        val swBio = requireView().findViewById<SwitchCompat>(R.id.SWBiome)
        val swAcua = requireView().findViewById<SwitchCompat>(R.id.SWAcuarela)
        val swBYW = requireView().findViewById<SwitchCompat>(R.id.SWBlackGray)
        val swBrush = requireView().findViewById<SwitchCompat>(R.id.SWBrush)
        val sw3D = requireView().findViewById<SwitchCompat>(R.id.SW3D)
        val swGeo = requireView().findViewById<SwitchCompat>(R.id.SWGeome)
        val swGot = requireView().findViewById<SwitchCompat>(R.id.SWGotic)
        val swJap = requireView().findViewById<SwitchCompat>(R.id.SWJapones)
        val swKaw = requireView().findViewById<SwitchCompat>(R.id.SWKawai)
        val swDot = requireView().findViewById<SwitchCompat>(R.id.SWDotWork)
        val swNeo = requireView().findViewById<SwitchCompat>(R.id.SWNeotrad)
        val swMin = requireView().findViewById<SwitchCompat>(R.id.SWMinim)
        val swLett = requireView().findViewById<SwitchCompat>(R.id.SWLetter)
        val swOrnam = requireView().findViewById<SwitchCompat>(R.id.SWOrnam)
        val swThL = requireView().findViewById<SwitchCompat>(R.id.SWThinL)
        val swBlack = requireView().findViewById<SwitchCompat>(R.id.SWBlack)
        return listOf(
            sw3D, swAcua, swBio, swBYW, swBlack, swBrush, swDot, swGeo, swGot, swJap,
            swKaw, swLett, swMin, swNeo, swOrnam, swReal, swThL, swTrad, swTrash, swTrib
        )
    }

    @OptIn(DelicateCoroutinesApi::class)
    fun swListE(): MutableList<SwitchCompat> {
        val coroutineExceptionHandler = CoroutineExceptionHandler { _, throwable ->
            throwable.printStackTrace()
        }
        val mut: MutableList<SwitchCompat> = mutableListOf()
        val swReal = requireView().findViewById<SwitchCompat>(R.id.SWRealism)
        val swTrash = requireView().findViewById<SwitchCompat>(R.id.SWTrash)
        val swTrad = requireView().findViewById<SwitchCompat>(R.id.SWTrad)
        val swTrib = requireView().findViewById<SwitchCompat>(R.id.SWTribal)
        val swBio = requireView().findViewById<SwitchCompat>(R.id.SWBiome)
        val swAcua = requireView().findViewById<SwitchCompat>(R.id.SWAcuarela)
        val swBYW = requireView().findViewById<SwitchCompat>(R.id.SWBlackGray)
        val swBrush = requireView().findViewById<SwitchCompat>(R.id.SWBrush)
        val sw3D = requireView().findViewById<SwitchCompat>(R.id.SW3D)
        val swGeo = requireView().findViewById<SwitchCompat>(R.id.SWGeome)
        val swGot = requireView().findViewById<SwitchCompat>(R.id.SWGotic)
        val swJap = requireView().findViewById<SwitchCompat>(R.id.SWJapones)
        val swKaw = requireView().findViewById<SwitchCompat>(R.id.SWKawai)
        val swDot = requireView().findViewById<SwitchCompat>(R.id.SWDotWork)
        val swNeo = requireView().findViewById<SwitchCompat>(R.id.SWNeotrad)
        val swMin = requireView().findViewById<SwitchCompat>(R.id.SWMinim)
        val swLett = requireView().findViewById<SwitchCompat>(R.id.SWLetter)
        val swOrnam = requireView().findViewById<SwitchCompat>(R.id.SWOrnam)
        val swThL = requireView().findViewById<SwitchCompat>(R.id.SWThinL)
        val swBlack = requireView().findViewById<SwitchCompat>(R.id.SWBlack)

        GlobalScope.launch(Dispatchers.IO + coroutineExceptionHandler) {
            val list = appDb.TATOOTIPEDao.vista(1)
            list.forEach { style ->
                when (style.STYLE) {
                    "3D" -> {
                        mut.add(sw3D)
                    }
                    "Acuarela" -> {
                        mut.add(swAcua)
                    }
                    "Biomecanico" -> {
                        mut.add(swBio)
                    }
                    "Black Gray" -> {
                        mut.add(swBYW)
                    }
                    "Black Work" -> {
                        mut.add(swBlack)
                    }
                    "Brush" -> {
                        mut.add(swBrush)
                    }
                    "Dot Work" -> {
                        mut.add(swDot)
                    }
                    "Geometrico" -> {
                        mut.add(swGeo)
                    }
                    "Gotico" -> {
                        mut.add(swGot)
                    }
                    "Japones" -> {
                        mut.add(swJap)
                    }
                    "Kawaii" -> {
                        mut.add(swKaw)
                    }
                    "Lettering" -> {
                        mut.add(swLett)
                    }
                    "Minimalista" -> {
                        mut.add(swMin)
                    }
                    "Neotradicional" -> {
                        mut.add(swNeo)
                    }
                    "Ornamental" -> {
                        mut.add(swOrnam)
                    }
                    "Realismo" -> {
                        mut.add(swReal)
                    }
                    "Thin Linner" -> {
                        mut.add(swThL)
                    }
                    "Tradicional" -> {
                        mut.add(swTrad)
                    }
                    "Trash Polka" -> {
                        mut.add(swTrash)
                    }
                    "Tribal" -> {
                        mut.add(swTrib)
                    }
                }

            }
        }
        return mut
    }

    /*@OptIn(DelicateCoroutinesApi::class)
    private fun validacion():MutableList<SwitchCompat>{
        val swn:MutableList<SwitchCompat> = mutableListOf()
        GlobalScope.launch {
            val lista = appDb.TATOOTIPEDao.vista(1)
            var i=0
            sw.forEach{sw1->
                if (sw1.text.toString()==lista[i].STYLE){
                    swn.add(sw1)
                    println(sw1.text.toString())
                }
                i++
            }

        }
        println(swn)
        return swn

    }*/

    @OptIn(DelicateCoroutinesApi::class)
    private fun setGetE() {
        val coroutineExceptionHandler = CoroutineExceptionHandler { _, throwable ->
            throwable.printStackTrace()
        }
        val sw = swListE()
        GlobalScope.launch(Dispatchers.IO + coroutineExceptionHandler) {
            val tatootipe = appDb.TATOOTIPEDao.vista(1)
            var i = 0
            tatootipe.forEach { style ->
                sw[i].isChecked = style.STYLE == sw[i].text.toString()
                i++
            }
        }
    }

    @OptIn(DelicateCoroutinesApi::class)
    private fun chekedE() {
        val coroutineExceptionHandler = CoroutineExceptionHandler { _, throwable ->
            throwable.printStackTrace()
        }
        val sw = swListEx()
        GlobalScope.launch(Dispatchers.IO + coroutineExceptionHandler) {
            sw.forEach { swp ->
                if (!swp.isChecked) {
                    appDb.TATOOTIPEDao.ocultar(swp.text.toString())
                } else {
                    appDb.TATOOTIPEDao.mostrar(swp.text.toString())
                }
            }

        }
        Toast.makeText(requireContext(), "Estilos Guardados", Toast.LENGTH_SHORT).show()
        findNavController().navigate(R.id.action_nav_estilos_to_nav_menu)
    }

}
