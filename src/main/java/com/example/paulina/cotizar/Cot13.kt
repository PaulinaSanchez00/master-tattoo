package com.example.paulina.cotizar

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.paulina.R
import com.example.paulina.cotizar.citax.CitaX
import com.example.paulina.database.BD.RegisterDatabase
import com.example.paulina.database.Entity.RESULTADO
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class Cot13 : Fragment(R.layout.fragment_cot13) {

    private lateinit var appDb: RegisterDatabase
    private lateinit var data: String
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        return inflater.inflate(R.layout.fragment_cot13, container, false)
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        appDb = RegisterDatabase.getInstance(requireContext())
        val btnReg = requireView().findViewById<ImageButton>(R.id.btnReg)
        val btnContinuar = requireView().findViewById<Button>(R.id.btnContinuar)
        val seekBar = requireView().findViewById<SeekBar>(R.id.seekBar)
        data = CitaX.Estilo.toString()
        println(data)
        limitaciones(seekBar, data)



        btnReg.setOnClickListener {
            findNavController().navigate(R.id.action_cot13_to_cot12)
        }
        btnContinuar.setOnClickListener {
            val i = seekBar!!.progress
            if(i == 0){
                Toast.makeText(requireContext(),"Debes seleccionar un tamaño", Toast.LENGTH_SHORT).show()
            }else{
                var resultado: Double
                println(CitaX.precio)
                if (CitaX.precio == null) {
                    GlobalScope.launch(Dispatchers.IO) {
                        var negro = 0
                        var colors = 0
                        CitaX.colors!!.forEach { color ->
                            if (color == "Negro") {
                                negro += 1
                            } else {
                                colors += 1
                            }
                        }
                        println("negro: $negro colores: $colors")

                        val CMX: Double = CitaX.tamano!!.toDouble()
                        val TATOOTIPE = appDb.TATOOTIPEDao
                        val VAR = appDb.VARDao
                        val ID_TATOO = TATOOTIPE.getID(CitaX.Estilo.toString())
                        val PRECIO: Double = TATOOTIPE.getPrecio(CitaX.Estilo.toString())
                        val CM: Double = VAR.getCM(ID_TATOO)
                        val CM_NEGRO: Double = PRECIO / (CM * VAR.getCM_NEGRO(ID_TATOO))
                        val CM_ESTILO: Double = PRECIO / (CM * VAR.getCM_ESTILO(ID_TATOO))
                        val CM_COLOR: Double = CM_NEGRO * VAR.getCM_COlOR(ID_TATOO)
                        println("$CMX, $TATOOTIPE, $VAR, $ID_TATOO, $PRECIO, $CM, $CM_COLOR, $CM_ESTILO, $CM_NEGRO")

                        resultado = if (colors >= 1 && negro >= 1) {
                            (CM_ESTILO * CMX) + (CM_NEGRO * CMX) + ((CM_COLOR * CMX) * colors)
                        } else if (colors == 0 && negro >=1) {
                            (CM_ESTILO * CMX) + (CM_NEGRO * CMX)
                        } else if (colors >= 1 && negro == 0) {
                            (CM_ESTILO * CMX) + ((CM_COLOR * CMX) * colors)
                        } else {
                            0.00
                        }
                        println(resultado)
                        val final = RESULTADO(0,resultado)
                        GlobalScope.launch(Dispatchers.IO){appDb.RESULTADODao.insert(final)}
                    }
                }
                findNavController().navigate(R.id.action_cot13_to_cot14)
            }
        }
    }

    private fun limitaciones(seekBar: SeekBar, Estilo: String) {
        seekBar.setOnSeekBarChangeListener(object : SeekBar.OnSeekBarChangeListener {
            override fun onProgressChanged(seekBar: SeekBar?, progress: Int, fromUser: Boolean) {
                valido(Estilo, progress)
            }

            override fun onStartTrackingTouch(seekBar: SeekBar?) {
                valido( Estilo, progress = seekBar!!.progress)
            }

            override fun onStopTrackingTouch(seekBar: SeekBar?) {
                Toast.makeText(
                    requireContext(),
                    "Este es el tamaño que deseas ${seekBar!!.progress} Cm",
                    Toast.LENGTH_SHORT
                ).show()
            }
        })
    }

    fun valido(Estilo: String, progress: Int) {
        val txt = requireView().findViewById<TextView>(R.id.textView2)
        when (Estilo) {
            "3D" -> {
                if (progress > 7) {
                    txt.text = progress.toString()
                    sendNudes(progress.toDouble())
                }else{
                    Toast.makeText(
                        requireContext(),
                        "Estilo $Estilo no menor a 8 Cm",
                        Toast.LENGTH_SHORT
                    ).show()
                }

            }
            "Acuarela" -> {
                if (progress > 7) {
                    txt.text = progress.toString()
                    sendNudes(progress.toDouble())
                }else{
                    Toast.makeText(
                        requireContext(),
                        "Estilo $Estilo no menor a 8 Cm",
                        Toast.LENGTH_SHORT
                    ).show()
                }
            }
            "Black Gray" -> {
                if (progress >11) {
                    txt.text = progress.toString()
                    sendNudes(progress.toDouble())
                }else{
                    Toast.makeText(
                        requireContext(),
                        "Estilo $Estilo no menor a 12 Cm",
                        Toast.LENGTH_SHORT
                    ).show()
                }
            }
            "Biomecanico" -> {
                if (progress > 15) {
                    txt.text = progress.toString()
                    sendNudes(progress.toDouble())
                }else{
                    Toast.makeText(
                        requireContext(),
                        "Estilo $Estilo no menor a 16 Cm",
                        Toast.LENGTH_SHORT
                    ).show()
                }

            }
            "Black Work" -> {
                if (progress > 7) {
                    txt.text = progress.toString()
                    sendNudes(progress.toDouble())
                }else{
                    Toast.makeText(
                        requireContext(),
                        "Estilo $Estilo no menor a 8 Cm",
                        Toast.LENGTH_SHORT
                    ).show()
                }
            }
            "Brush" -> {
                if (progress > 7) {
                    txt.text = progress.toString()
                    sendNudes(progress.toDouble())
                }else{
                    Toast.makeText(
                        requireContext(),
                        "Estilo $Estilo no menor a 8 Cm",
                        Toast.LENGTH_SHORT
                    ).show()
                }
            }
            "Dot Work" -> {
                if (progress > 7) {
                    txt.text = progress.toString()
                    sendNudes(progress.toDouble())
                }else{
                    Toast.makeText(
                        requireContext(),
                        "Estilo $Estilo no menor a 8 Cm",
                        Toast.LENGTH_SHORT
                    ).show()
                }
            }
            "Geometrico" -> {
                if (progress > 11) {
                    txt.text = progress.toString()
                    sendNudes(progress.toDouble())
                }else{
                    Toast.makeText(
                        requireContext(),
                        "Estilo $Estilo no menor a 12 Cm",
                        Toast.LENGTH_SHORT
                    ).show()
                }
            }
            "Gotico" -> {
                if (progress > 9) {
                    txt.text = progress.toString()
                    sendNudes(progress.toDouble())
                }else{
                    Toast.makeText(
                        requireContext(),
                        "Estilo $Estilo no menor a 10 Cm",
                        Toast.LENGTH_SHORT
                    ).show()
                }

            }
            "Japones" -> {
                if (progress > 9) {
                    txt.text = progress.toString()
                    sendNudes(progress.toDouble())
                }else{
                    Toast.makeText(
                        requireContext(),
                        "Estilo $Estilo no menor a 10 Cm",
                        Toast.LENGTH_SHORT
                    ).show()
                }
            }
            "Kawaii" -> {
                if (progress > 9) {
                    txt.text = progress.toString()
                    sendNudes(progress.toDouble())
                }else{
                    Toast.makeText(
                        requireContext(),
                        "Estilo $Estilo no menor a 10 Cm",
                        Toast.LENGTH_SHORT
                    ).show()
                }
            }
            "Lettering" -> {
                if (progress > 9) {
                    txt.text = progress.toString()
                    sendNudes(progress.toDouble())

                }else{
                    Toast.makeText(
                        requireContext(),
                        "Estilo $Estilo no menor a 10 Cm",
                        Toast.LENGTH_SHORT
                    ).show()
                }
            }
            "Minimalista" -> {
                if (progress > 1) {
                    txt.text = progress.toString()
                }else if(progress in 2..7){
                    sendNudesP(400.00)
                    sendNudes(progress.toDouble())
                    txt.text = progress.toString()
                }else if(progress>8){
                    sendNudes(progress.toDouble())
                    txt.text = progress.toString()
                }else{
                    Toast.makeText(
                        requireContext(),
                        "Estilo $Estilo no menor a 2 Cm",
                        Toast.LENGTH_SHORT
                    ).show()
                }

            }
            "Neotradicional" -> {
                if (progress > 7) {
                    txt.text = progress.toString()
                    sendNudes(progress.toDouble())
                }else{
                    Toast.makeText(
                        requireContext(),
                        "Estilo $Estilo no menor a 8 Cm",
                        Toast.LENGTH_SHORT
                    ).show()
                }
            }
            "Ornamental" -> {
                if (progress > 15) {
                    txt.text = progress.toString()
                    sendNudes(progress.toDouble())
                }else{
                    Toast.makeText(
                        requireContext(),
                        "Estilo $Estilo no menor a 8 Cm",
                        Toast.LENGTH_SHORT
                    ).show()
                }
            }
            "Realismo" -> {
                if (progress > 4) {
                    txt.text = progress.toString()

                }else if(progress in 5..8){
                    sendNudesP(500.00)
                    sendNudes(progress.toDouble())
                    txt.text = progress.toString()
                }else if(progress>9){
                    sendNudes(progress.toDouble())
                    txt.text = progress.toString()
                }else{
                    Toast.makeText(
                        requireContext(),
                        "Estilo $Estilo no menor a 2 Cm",
                        Toast.LENGTH_SHORT
                    ).show()
                }
            }
            "Thin Linner" -> {
                if (progress > 1) {
                    txt.text = progress.toString()
                }else if(progress in 2..7){
                    sendNudes(progress.toDouble())
                    sendNudesP(400.00)
                    txt.text = progress.toString()
                }else if(progress>8){
                    sendNudes(progress.toDouble())
                    txt.text = progress.toString()
                }else{
                    Toast.makeText(
                        requireContext(),
                        "Estilo $Estilo no menor a 2 Cm",
                        Toast.LENGTH_SHORT
                    ).show()
                }

            }
            "Tradicional" -> {
                if (progress > 7) {
                    txt.text = progress.toString()
                    sendNudes(progress.toDouble())
                }else{
                    Toast.makeText(
                        requireContext(),
                        "Estilo $Estilo no menor a 8 Cm",
                        Toast.LENGTH_SHORT
                    ).show()
                }
            }
            "Trash Polka" -> {
                if (progress > 11) {
                    txt.text = progress.toString()
                    sendNudes(progress.toDouble())
                }else{
                    Toast.makeText(
                        requireContext(),
                        "Estilo $Estilo no menor a 12 Cm",
                        Toast.LENGTH_SHORT
                    ).show()
                }
            }
            "Tribal" -> {
                if (progress > 9) {
                    txt.text = progress.toString()
                    sendNudes(progress.toDouble())
                }else{
                    Toast.makeText(
                        requireContext(),
                        "Estilo $Estilo no menor a 10 Cm",
                        Toast.LENGTH_SHORT
                    ).show()
                }

            }
        }
    }

    private fun sendNudes(name: Double) {
        kotlin.run {
           CitaX.tamano=name
        }
    }

    private fun sendNudesP(name: Double) {
        kotlin.run {
            CitaX.precio=name
        }
    }
}