package com.example.paulina.preinicio

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.paulina.R
import com.example.paulina.database.BD.RegisterDatabase
import com.example.paulina.database.Entity.ESTUDIO
import com.example.paulina.database.Entity.INFO
import com.example.paulina.database.Entity.TATOOTIPE
import com.example.paulina.database.Entity.VAR
import kotlinx.coroutines.DelicateCoroutinesApi
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class Bienvenida2 :  Fragment(R.layout.fragment_bienvenida2) {

    private lateinit var appDb: RegisterDatabase

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        appDb = RegisterDatabase.getInstance(requireContext())
        val btnCot = requireView().findViewById<Button>(R.id.btnIr)
        ingresar()
        btnCot.setOnClickListener {
            wriData()
        }
    }
    @OptIn(DelicateCoroutinesApi::class)
    private fun wriData(){
        val estudio = requireView().findViewById<EditText>(R.id.EdtEstudioName)
        val nombre = estudio.text.toString()
        if (nombre == ""){
            Toast.makeText(requireContext(),"Ingresa el nombre", Toast.LENGTH_SHORT).show()
        }else{
            val nombreE = ESTUDIO(
                0,nombre,"Manuel J. Clothier 3993","Local azul, arriba de un six de Tecate","https://www.google.com/maps/place/Deposito+Six+Chelitas/@23.2455962,-106.388567,19z/data=!4m12!1m6!3m5!1s0x869f52e0ae8ef207:0xd165ad1d632d9648!2sSIX+CHELITA!8m2!3d23.2455913!4d-106.3880198!3m4!1s0x0:0xb31c32344942c6d6!8m2!3d23.2459873!4d-106.3876191",""
            )
            GlobalScope.launch(Dispatchers.IO) {
                appDb.ESTUDIODao.insert(nombreE)
            }
            estudio.setText("")
            Toast.makeText(requireContext(),"Nombre Registrado", Toast.LENGTH_SHORT).show()
            findNavController().navigate(R.id.action_bienvenida2_to_selectEstilos2)
        }
    }
    @OptIn(DelicateCoroutinesApi::class)
    private fun ingresar(){
        //estilos
        val tattoo3D = TATOOTIPE(0,"3D",2500.00,1)
        GlobalScope.launch(Dispatchers.IO) { appDb.TATOOTIPEDao.insert(tattoo3D) }
        val tattooAcuarela = TATOOTIPE(0,"Acuarela",1500.00, 1)
        GlobalScope.launch(Dispatchers.IO) { appDb.TATOOTIPEDao.insert(tattooAcuarela) }
        val tattooBiomecanico = TATOOTIPE(0,"Biomecanico", 4000.00, 1)
        GlobalScope.launch(Dispatchers.IO) { appDb.TATOOTIPEDao.insert(tattooBiomecanico) }
        val tattooBG = TATOOTIPE(0,"Black Gray",1800.00,1)
        GlobalScope.launch(Dispatchers.IO) { appDb.TATOOTIPEDao.insert(tattooBG) }
        val tattooBW = TATOOTIPE(0,"Black Work", 3500.00, 1)
        GlobalScope.launch(Dispatchers.IO) {appDb.TATOOTIPEDao.insert(tattooBW) }
        val tattooBrush = TATOOTIPE(0,"Brush",2500.00,1)
        GlobalScope.launch(Dispatchers.IO) {appDb.TATOOTIPEDao.insert(tattooBrush) }
        val tattooDW = TATOOTIPE(0,"Dot Work",900.00,1)
        GlobalScope.launch(Dispatchers.IO) {appDb.TATOOTIPEDao.insert(tattooDW) }
        val tattooTL = TATOOTIPE(0,"Thin Linner", 500.00,1)
        GlobalScope.launch(Dispatchers.IO) {appDb.TATOOTIPEDao.insert(tattooTL) }
        val tattooGeo = TATOOTIPE(0,"Geometrico",1500.00,1)
        GlobalScope.launch(Dispatchers.IO) { appDb.TATOOTIPEDao.insert(tattooGeo) }
        val tattooGotico = TATOOTIPE(0,"Gotico",3200.00,1)
        GlobalScope.launch(Dispatchers.IO) {appDb.TATOOTIPEDao.insert(tattooGotico) }
        val tattooJap = TATOOTIPE(0,"Japones",4800.00,1)
        GlobalScope.launch(Dispatchers.IO) { appDb.TATOOTIPEDao.insert(tattooJap) }
        val tattooKawaii = TATOOTIPE(0,"Kawaii",2900.00,1)
        GlobalScope.launch(Dispatchers.IO) { appDb.TATOOTIPEDao.insert(tattooKawaii) }
        val tattooLet = TATOOTIPE(0,"Lettering",1500.00,1)
        GlobalScope.launch(Dispatchers.IO) {appDb.TATOOTIPEDao.insert(tattooLet) }
        val tattooMin = TATOOTIPE(0,"Minimalista",1200.00,1)
        GlobalScope.launch(Dispatchers.IO) {appDb.TATOOTIPEDao.insert(tattooMin) }
        val tattooNeo = TATOOTIPE(0,"Neotradicional",2500.00,1)
        GlobalScope.launch(Dispatchers.IO) {appDb.TATOOTIPEDao.insert(tattooNeo) }
        val tattooOrn = TATOOTIPE(0,"Ornamental",9000.00,1)
        GlobalScope.launch(Dispatchers.IO) {appDb.TATOOTIPEDao.insert(tattooOrn) }
        val tattooReal = TATOOTIPE(0,"Realismo",3000.00,1)
        GlobalScope.launch(Dispatchers.IO) {appDb.TATOOTIPEDao.insert(tattooReal) }
        val tattooTra = TATOOTIPE(0,"Tradicional",3500.00, 1)
        GlobalScope.launch(Dispatchers.IO) {appDb.TATOOTIPEDao.insert(tattooTra) }
        val tattooTrash = TATOOTIPE(0,"Trash Polka",3000.00,1)
        GlobalScope.launch(Dispatchers.IO) {appDb.TATOOTIPEDao.insert(tattooTrash) }
        val tattooTribal = TATOOTIPE(0,"Tribal",3000.00,1)
        GlobalScope.launch(Dispatchers.IO) {appDb.TATOOTIPEDao.insert(tattooTribal)}

        //informacion
        val facebook = INFO(0,1,"Paulina Hau", 1)
        GlobalScope.launch(Dispatchers.IO) {appDb.INFODao.insert(facebook)}
        val instagram = INFO(0,1,"HauTattoo", 1)
        GlobalScope.launch(Dispatchers.IO) {appDb.INFODao.insert(instagram)}
        val whatsapp = INFO(0,1,"6692691625", 1)
        GlobalScope.launch(Dispatchers.IO) {appDb.INFODao.insert(whatsapp)}

        //Variables
        //3d
        val val1 = VAR(0,1,18.00,1.5,10.0,1.11)
        GlobalScope.launch(Dispatchers.IO){appDb.VARDao.Insert(val1)}
        //acua
        val val2 = VAR(0,2,14.0,1.5,10.71,2.06)
        GlobalScope.launch(Dispatchers.IO){appDb.VARDao.Insert(val2)}
        //Bio
        val val3 = VAR(0,3,30.00,1.5,13.33,1.35)
        GlobalScope.launch(Dispatchers.IO){appDb.VARDao.Insert(val3)}
        //Black and Gray
        val val4 = VAR(0,4,12.00,1.5,10.0,1.33)
        GlobalScope.launch(Dispatchers.IO){appDb.VARDao.Insert(val4)}
        //BlackWork
        val val5 = VAR(0,5,25.00,1.6,10.0,1.12)
        GlobalScope.launch(Dispatchers.IO){appDb.VARDao.Insert(val5)}
        //Brush
        val val6 = VAR(0,6,30.00,1.5,10.0,1.11)
        GlobalScope.launch(Dispatchers.IO){appDb.VARDao.Insert(val6)}
        //Dot work
        val val7 = VAR(0,7,10.00,1.5,10.0,1.11)
        GlobalScope.launch(Dispatchers.IO){appDb.VARDao.Insert(val7)}
        //thin Linner
        val val8 = VAR(0,8,8.00,1.5,10.0,1.11)
        GlobalScope.launch(Dispatchers.IO){appDb.VARDao.Insert(val8)}
        //Geometrico
        val val9 = VAR(0,9,17.00,1.5,10.0,1.1)
        GlobalScope.launch(Dispatchers.IO){appDb.VARDao.Insert(val9)}
        //Gotico
        val val10 = VAR(0,10,23.00,1.5,10.0,1.12)
        GlobalScope.launch(Dispatchers.IO){appDb.VARDao.Insert(val10)}
        //Japones
        val val11 = VAR(0,11,46.00,1.5,10.0,1.32)
        GlobalScope.launch(Dispatchers.IO){appDb.VARDao.Insert(val11)}
        //Kawaii
        val val12 = VAR(0,12,18.00,1.89,16.11,1.89)
        GlobalScope.launch(Dispatchers.IO){appDb.VARDao.Insert(val12)}
        //Letrering
        val val13 = VAR(0,13,23.00,1.5,6.52,1.18)
        GlobalScope.launch(Dispatchers.IO){appDb.VARDao.Insert(val13)}
        //Minimalista
        val val14 = VAR(0,14,12.00,1.6,6.66,1.17)
        GlobalScope.launch(Dispatchers.IO){appDb.VARDao.Insert(val14)}
        //Neotradicional
        val va15 = VAR(0,15,20.00,1.5,15.62,2.2)
        GlobalScope.launch(Dispatchers.IO){appDb.VARDao.Insert(va15)}
        //Ornamental
        val val16 = VAR(0,16,90.00,1.5,10.0,1.11)
        GlobalScope.launch(Dispatchers.IO){appDb.VARDao.Insert(val16)}
        //Realismo
        val val17 = VAR(0,17,20.00,1.6,10.0,1.37)
        GlobalScope.launch(Dispatchers.IO){appDb.VARDao.Insert(val17)}
        //Tradicional
        val val18 = VAR(0,18,30.00,1.5,14.58,1.37)
        GlobalScope.launch(Dispatchers.IO){appDb.VARDao.Insert(val18)}
        //Trash polka
        val val19 = VAR(0,19,20.00,1.6,10.0,1.37)
        GlobalScope.launch(Dispatchers.IO){appDb.VARDao.Insert(val19)}
        //Tribal
        val val20 = VAR(0,20,20.00,1.6,10.0,1.5)
        GlobalScope.launch(Dispatchers.IO){appDb.VARDao.Insert(val20)}
    }
}