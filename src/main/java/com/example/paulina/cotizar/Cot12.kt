package com.example.paulina.cotizar

import android.graphics.drawable.AnimationDrawable
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.View
import android.widget.*
import androidx.core.os.bundleOf
import androidx.navigation.fragment.findNavController
import com.example.paulina.R
import com.example.paulina.cotizar.citax.CitaX

class Cot12 : Fragment(R.layout.fragment_cot12) {

    private lateinit var rocketAnimation: AnimationDrawable
    private lateinit var rocketAnimation2: AnimationDrawable
    private lateinit var rocketAnimation3: AnimationDrawable
    private lateinit var rocketAnimation4: AnimationDrawable
    private lateinit var rocketAnimation5: AnimationDrawable
    private lateinit var rocketAnimation6: AnimationDrawable
    private lateinit var rocketAnimation7: AnimationDrawable
    private lateinit var rocketAnimation8: AnimationDrawable
    private lateinit var rocketAnimation9: AnimationDrawable
    private lateinit var rocketAnimation10: AnimationDrawable
    private lateinit var rocketAnimation11: AnimationDrawable

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val negro = requireView().findViewById<ImageView>(R.id.negro).apply {
            setBackgroundResource(R.drawable.rocket_thrust)
            rocketAnimation = background as AnimationDrawable
        }
        val rojo = requireView().findViewById<ImageView>(R.id.rojo).apply {
            setBackgroundResource(R.drawable.rocket_thrust2)
            rocketAnimation2 = background as AnimationDrawable
        }
        val naranja = requireView().findViewById<ImageView>(R.id.naranja).apply {
            setBackgroundResource(R.drawable.rocket_thrust3)
            rocketAnimation3 = background as AnimationDrawable
        }
        val amarillo = requireView().findViewById<ImageView>(R.id.amarillo).apply {
            setBackgroundResource(R.drawable.rocket_thrust4)
            rocketAnimation4 = background as AnimationDrawable
        }
        val verde = requireView().findViewById<ImageView>(R.id.verde).apply {
            setBackgroundResource(R.drawable.rocket_thrust5)
            rocketAnimation5 = background as AnimationDrawable
        }
        val cian = requireView().findViewById<ImageView>(R.id.cian).apply {
            setBackgroundResource(R.drawable.rocket_thrust6)
            rocketAnimation6 = background as AnimationDrawable
        }
        val azul = requireView().findViewById<ImageView>(R.id.azul).apply {
            setBackgroundResource(R.drawable.rocket_thrust7)
            rocketAnimation7 = background as AnimationDrawable
        }
        val marino = requireView().findViewById<ImageView>(R.id.marino).apply {
            setBackgroundResource(R.drawable.rocket_thrust8)
            rocketAnimation8 = background as AnimationDrawable
        }
        val lila = requireView().findViewById<ImageView>(R.id.lila).apply {
            setBackgroundResource(R.drawable.rocket_thrust9)
            rocketAnimation9 = background as AnimationDrawable
        }
        val rosa = requireView().findViewById<ImageView>(R.id.rosa).apply {
            setBackgroundResource(R.drawable.rocket_thrust10)
            rocketAnimation10 = background as AnimationDrawable
        }
        val blanco = requireView().findViewById<ImageView>(R.id.blanco).apply {
            setBackgroundResource(R.drawable.rocket_thrust11)
            rocketAnimation11 = background as AnimationDrawable
        }






        val colores:ArrayList<String> = arrayListOf()

        var num1: Int
        var num2: Int
        val resultadof = requireView().findViewById<TextView>(R.id.resultado)
        var resultado: Int
        negro.setOnClickListener {
            rocketAnimation.start()
            colores.add("Negro")
            num1 = resultadof.text.toString().toInt()
            if(num1 == 0){
                resultadof.text = "1"
            }else{
                num2 = resultadof.text.toString().toInt()
                resultado = 1 + num2
                resultadof.text = resultado.toString()
            }
            negro.isClickable = false;
        }
        rojo.setOnClickListener{
            colores.add("Rojo")
            rocketAnimation2.start()
            num1 = resultadof.text.toString().toInt()
            if(num1 == 0){
                resultadof.text = "1"
            }else{
                num2 = resultadof.text.toString().toInt()
                resultado = 1 + num2
                resultadof.text = resultado.toString()
            }
            rojo.isClickable = false;
        }
        naranja.setOnClickListener{
            colores.add("Naranja")
            rocketAnimation3.start()
            num1 = resultadof.text.toString().toInt()
            if(num1 == 0){
                resultadof.text = "1"
            }else{
                num2 = resultadof.text.toString().toInt()
                resultado = 1 + num2
                resultadof.text = resultado.toString()
            }
            naranja.isClickable = false;
        }
        amarillo.setOnClickListener{
            rocketAnimation4.start()
            colores.add("Amarillo")
            num1 = resultadof.text.toString().toInt()
            if(num1 == 0){
                resultadof.text = "1"
            }else{
                num2 = resultadof.text.toString().toInt()
                resultado = 1 + num2
                resultadof.text = resultado.toString()
            }
            amarillo.isClickable = false;
        }
        verde.setOnClickListener{
            rocketAnimation5.start()
            colores.add("Verde")
            num1 = resultadof.text.toString().toInt()
            if(num1 == 0){
                resultadof.text = "1"
            }else{
                num2 = resultadof.text.toString().toInt()
                resultado = 1 + num2
                resultadof.text = resultado.toString()
            }
            verde.isClickable = false;
        }
        cian.setOnClickListener{
            rocketAnimation6.start()
            colores.add("Cian")
            num1 = resultadof.text.toString().toInt()
            if(num1 == 0){
                resultadof.text = "1"
            }else{
                num2 = resultadof.text.toString().toInt()
                resultado = 1 + num2
                resultadof.text = resultado.toString()
            }
            cian.isClickable = false;
        }
        azul.setOnClickListener{
            rocketAnimation7.start()
            colores.add("azul")
            num1 = resultadof.text.toString().toInt()
            if(num1 == 0){
                resultadof.text = "1"
            }else{
                num2 = resultadof.text.toString().toInt()
                resultado = 1 + num2
                resultadof.text = resultado.toString()
            }
            azul.isClickable = false;
        }

        marino.setOnClickListener{
            rocketAnimation8.start()
            colores.add("Azul marino")
            num1 = resultadof.text.toString().toInt()
            if(num1 == 0){
                resultadof.text = "1"
            }else{
                num2 = resultadof.text.toString().toInt()
                resultado = 1 + num2
                resultadof.text = resultado.toString()
            }
            marino.isClickable = false;
        }
        lila.setOnClickListener{
            rocketAnimation9.start()
            colores.add("Lila")
            num1 = resultadof.text.toString().toInt()
            if(num1 == 0){
                resultadof.text = "1"
            }else{
                num2 = resultadof.text.toString().toInt()
                resultado = 1 + num2
                resultadof.text = resultado.toString()
            }
            lila.isClickable = false;
        }
        rosa.setOnClickListener{
            rocketAnimation10.start()
            colores.add("Rosa")
            num1 = resultadof.text.toString().toInt()
            if(num1 == 0){
                resultadof.text = "1"
            }else{
                num2 = resultadof.text.toString().toInt()
                resultado = 1 + num2
                resultadof.text = resultado.toString()
            }
            rosa.isClickable = false;
        }
        blanco.setOnClickListener{
            rocketAnimation11.start()
            colores.add("Blanco")
            num1 = resultadof.text.toString().toInt()
            if(num1 == 0){
                resultadof.text = "1"
            }else{
                num2 = resultadof.text.toString().toInt()
                resultado = 1 + num2
                resultadof.text = resultado.toString()
            }
            blanco.isClickable = false;
        }



        val btnReg = requireView().findViewById<ImageButton>(R.id.btnReg)
        val btnContinuar = requireView().findViewById<Button>(R.id.btnContinuar)

        btnReg.setOnClickListener{
            findNavController().navigate(R.id.action_cot12_to_cot11)
            resultadof.text = ""

        }
        btnContinuar.setOnClickListener{
            val i = resultadof.text
            if(i =="0"){
                Toast.makeText(requireContext(),"Debes seleccionar por lo menos un color", Toast.LENGTH_SHORT).show()
            }else{
                sendNudes(colores)
                findNavController().navigate(R.id.action_cot12_to_cot13)
                resultadof.text = ""
            }
        }
    }
    private fun sendNudes(name:ArrayList<String>){
        CitaX.colors = name
    }
}