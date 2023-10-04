package com.example.paulina.cotizar

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.paulina.R
import com.example.paulina.cotizar.citax.CitaX
import com.example.paulina.cotizar.controllers.Imgcontroller
import com.example.paulina.cotizar.imgEstilo.ImgEstilo
import com.example.paulina.database.BD.RegisterDatabase
import com.example.paulina.databinding.FragmentCot11Binding
import kotlinx.coroutines.*

class Cot11 : Fragment(R.layout.fragment_cot11) {
    private lateinit var adapterImg: Imgcontroller
    private lateinit var appDb: RegisterDatabase
    lateinit var binding: FragmentCot11Binding
    lateinit var recyclerView: RecyclerView
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        return inflater.inflate(R.layout.fragment_cot11, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        appDb = RegisterDatabase.getInstance(requireContext())
        binding = FragmentCot11Binding.inflate(layoutInflater)
        initRecyclerView()
        val btnReg = requireView().findViewById<ImageButton>(R.id.btnReg)
        btnReg.setOnClickListener {
            findNavController().navigate(R.id.action_cot11_to_cot10)
        }
    }
    private fun initRecyclerView(){
        val layoutManager= LinearLayoutManager(context)
        recyclerView= requireView().findViewById(R.id.ImgsRec)
        recyclerView.layoutManager = layoutManager
        recyclerView.setHasFixedSize(true)
        adapterImg= Imgcontroller(getItems()){imgEstilo ->onItemSelected(imgEstilo)}
        recyclerView.adapter= adapterImg
    }
    private fun onItemSelected(imgEstilo: ImgEstilo){
        if (imgEstilo.estilo.equals(null)){
            Toast.makeText(requireContext(), "Estilo esta vacio", Toast.LENGTH_SHORT).show()
        }else {
            sendNudes(imgEstilo.estilo)
        }
    }
    private fun sendNudes(name:String){
        kotlin.run {
            CitaX.Estilo = name
            findNavController().navigate(R.id.action_cot11_to_cot12)
        }
    }

    @OptIn(DelicateCoroutinesApi::class)
    private fun getItems(): MutableList<ImgEstilo> {
        val coroutineExceptionHandler = CoroutineExceptionHandler { _, throwable ->
            throwable.printStackTrace()
        }
        val imgs: MutableList<ImgEstilo> = mutableListOf()
        GlobalScope.launch(Dispatchers.IO + coroutineExceptionHandler) {
            val tatootipe = appDb.TATOOTIPEDao.vista(1)
            tatootipe.forEach { style ->
                val txt = style.STYLE
                when (txt) {
                    "3D" -> {
                        imgs.add(ImgEstilo(estilo = txt, R.drawable.tres, R.drawable.tresd))
                    }
                    "Acuarela" -> {
                        imgs.add(
                            ImgEstilo(
                                estilo = txt,
                                R.drawable.acua,
                                R.drawable.acuarela
                            )
                        )
                    }
                    "Black Gray" -> {
                        imgs.add(
                            ImgEstilo(
                                estilo = txt,
                                R.drawable.bygray,
                                R.drawable.blackygray
                            )
                        )
                    }
                    "Biomecanico" -> {
                        imgs.add(
                            ImgEstilo(
                                estilo = txt,
                                R.drawable.bio,
                                R.drawable.biomecanico
                            )
                        )
                    }
                    "Black Work" -> {
                        imgs.add(
                            ImgEstilo(
                                estilo = txt,
                                R.drawable.blackw,
                                R.drawable.blackwork
                            )
                        )
                    }
                    "Brush" -> {
                        imgs.add(
                            ImgEstilo(
                                estilo = txt,
                                R.drawable.brush,
                                R.drawable.brushd
                            )
                        )
                    }
                    "Dot Work" -> {
                        imgs.add(
                            ImgEstilo(
                                estilo = txt,
                                R.drawable.dont,
                                R.drawable.dontwork
                            )
                        )
                    }
                    "Geometrico" -> {
                        imgs.add(
                            ImgEstilo(
                                estilo = txt,
                                R.drawable.gep,
                                R.drawable.geometrico
                            )
                        )
                    }
                    "Gotico" -> {
                        imgs.add(
                            ImgEstilo(
                                estilo = txt,
                                R.drawable.gotic,
                                R.drawable.gotico
                            )
                        )
                    }
                    "Japones" -> {
                        imgs.add(
                            ImgEstilo(
                                estilo = txt,
                                R.drawable.jap,
                                R.drawable.japones
                            )
                        )
                    }
                    "Kawaii" -> {
                        imgs.add(ImgEstilo(estilo = txt, R.drawable.kaw, R.drawable.kawaii))
                    }
                    "Lettering" -> {
                        imgs.add(
                            ImgEstilo(
                                estilo = txt,
                                R.drawable.let,
                                R.drawable.lettering
                            )
                        )
                    }
                    "Minimalista" -> {
                        imgs.add(
                            ImgEstilo(
                                estilo = txt,
                                R.drawable.mini,
                                R.drawable.minimalismo
                            )
                        )
                    }
                    "Neotradicional" -> {
                        imgs.add(
                            ImgEstilo(
                                estilo = txt,
                                R.drawable.neot,
                                R.drawable.neotradicional
                            )
                        )
                    }
                    "Ornamental" -> {
                        imgs.add(
                            ImgEstilo(
                                estilo = txt,
                                R.drawable.ornam,
                                R.drawable.ornamental
                            )
                        )
                    }
                    "Realismo" -> {
                        imgs.add(
                            ImgEstilo(
                                estilo = txt,
                                R.drawable.real,
                                R.drawable.realismo
                            )
                        )
                    }
                    "Thin Linner" -> {
                        imgs.add(
                            ImgEstilo(
                                estilo = txt,
                                R.drawable.thinl,
                                R.drawable.thinlinner
                            )
                        )
                    }
                    "Tradicional" -> {
                        imgs.add(
                            ImgEstilo(
                                estilo = txt,
                                R.drawable.tradi,
                                R.drawable.tradicional
                            )
                        )
                    }
                    "Trash Polka" -> {
                        imgs.add(
                            ImgEstilo(
                                estilo = txt,
                                R.drawable.trashpol,
                                R.drawable.trashpolka
                            )
                        )
                    }
                    "Tribal" -> {
                        imgs.add(ImgEstilo(estilo = txt, R.drawable.tri, R.drawable.tribal))
                    }
                }
            }

        }
        return imgs
    }
}


