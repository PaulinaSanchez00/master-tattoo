package com.example.paulina.menuadmi.informacion

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.content.pm.PackageManager
import android.net.Uri
import android.os.Build
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.Toast
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import com.example.paulina.R
import com.example.paulina.database.BD.RegisterDatabase
import com.example.paulina.menuadmi.MenuAdm
import kotlinx.coroutines.DelicateCoroutinesApi
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import java.io.File

class InformacionFragment : Fragment(R.layout.fragment_informacion) {

    private val requestGallery = 1001
    private var imagenUr: Uri? = null

    private lateinit var appDb: RegisterDatabase

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        abreGaleriaClick()
        appDb = RegisterDatabase.getInstance(requireContext())
        readInfo()
        val btnGuardar =requireView().findViewById<Button>(R.id.btnAgregar)
        btnGuardar.setOnClickListener{
            guardar()
        }
    }
    private fun regresar() {
        val next = Intent(requireContext(), MenuAdm::class.java)
        startActivity(next)
    }
    @OptIn(DelicateCoroutinesApi::class)
    private fun readInfo(){
        val facebook = requireView().findViewById<EditText>(R.id.facebook)
        val id = 1
        GlobalScope.launch { val face = appDb.INFODao.getContacto(id)
            facebook.setText(face)
        }
        val instagram = requireView().findViewById<EditText>(R.id.instagram)
        val id2 = 2
        GlobalScope.launch { val ins = appDb.INFODao.getContacto(id2)
            instagram.setText(ins)
        }
        val whatsapp = requireView().findViewById<EditText>(R.id.whatsapp)
        val id3 = 3
        GlobalScope.launch { val whats = appDb.INFODao.getContacto(id3)
            whatsapp.setText(whats)
        }
        val domicilio = requireView().findViewById<EditText>(R.id.domicilio)
        val id4 = 1
        GlobalScope.launch { val dom = appDb.ESTUDIODao.getDireccion(id4)
            domicilio.setText(dom)
        }
        val estudio = requireView().findViewById<EditText>(R.id.estudio)
        val id5 = 1
        GlobalScope.launch { val est = appDb.ESTUDIODao.getNombre(id5)
            estudio.setText(est)
        }
        val descripcion = requireView().findViewById<EditText>(R.id.descripción)
        val id6 = 1
        GlobalScope.launch { val des = appDb.ESTUDIODao.getDescripcion(id6)
            descripcion.setText(des)
        }
        val link = requireView().findViewById<EditText>(R.id.Link)
        val id7 = 1
        GlobalScope.launch { val li = appDb.ESTUDIODao.getLink(id7)
            link.setText(li)
        }
    }
    private fun abreGaleriaClick(){
        val btnSubir =requireView().findViewById<Button>(R.id.btnSubir)
        btnSubir.setOnClickListener{
            if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.M){
                if (activity?.applicationContext?.let { it1 -> ContextCompat.checkSelfPermission(it1,android.Manifest.permission.READ_EXTERNAL_STORAGE) } == PackageManager.PERMISSION_DENIED){
                    val permisoArchivos = arrayOf(android.Manifest.permission.READ_EXTERNAL_STORAGE)
                    requestPermissions(permisoArchivos,requestGallery)
                }else{
                    galeria()
                }
            }else{
                galeria()
            }
        }
    }

    @Deprecated("Deprecated in Java")
    override fun onRequestPermissionsResult(
        requestCode: Int,
        permissions: Array<out String>,
        grantResults: IntArray
    ) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
        when(requestCode){
            requestGallery ->{
                if(grantResults[0] == PackageManager.PERMISSION_GRANTED)
                    galeria()
                else
                    Toast.makeText(activity?.applicationContext ,"No puedes acceder a tus imagenes.",
                        Toast.LENGTH_SHORT).show()
            }
        }
    }

    private fun galeria() {
        val intentGaleria = Intent(Intent.ACTION_PICK)
        intentGaleria.type = "image/*"
        startActivityForResult(intentGaleria,requestGallery)
    }

    //Listo
    @Deprecated("Deprecated in Java")
    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {

        super.onActivityResult(requestCode, resultCode, data)
        val imgFoto = requireView().findViewById<ImageView>(R.id.imgFoto)
        when {
            requestCode == requestGallery && resultCode == Activity.RESULT_OK ->{
                imagenUr = data!!.data
                imgFoto.setImageURI(imagenUr)
            }

        }
    }
    @OptIn(DelicateCoroutinesApi::class)
    private fun saveImage(context: Context, id: Long,nombre: String, uri: Uri) {
        val file = File(context.filesDir, id.toString() + nombre)
        val bytes = context.contentResolver.openInputStream(uri)?.readBytes()!!
        val imag = file.writeBytes(bytes)

        val imagen = imag.toString()
        if (imagen == "") {
            Toast.makeText(requireContext(), "Coloca una imagen", Toast.LENGTH_SHORT).show()
        } else {
            val id2 = 1
            GlobalScope.launch {
                appDb.ESTUDIODao.updateInfo2(imagen,id2)
            }
        }
        Toast.makeText(requireContext(),"Guardado", Toast.LENGTH_SHORT).show()
    }
    @OptIn(DelicateCoroutinesApi::class)
    private fun guardar() {
        imagenUr?.let {
            saveImage(requireContext(), 1, "logo", it)
        }
        val facebook = requireView().findViewById<EditText>(R.id.facebook)
        val face = facebook.text.toString()
        val instagram = requireView().findViewById<EditText>(R.id.instagram)
        val insta = instagram.text.toString()
        val whatsapp = requireView().findViewById<EditText>(R.id.whatsapp)
        val whats = whatsapp.text.toString()
        val nombreEstudio = requireView().findViewById<EditText>(R.id.estudio)
        val estu = nombreEstudio.text.toString()
        val direccion = requireView().findViewById<EditText>(R.id.domicilio)
        val domicilio = direccion.text.toString()
        val descripcion = requireView().findViewById<EditText>(R.id.descripción)
        val des = descripcion.text.toString()
        val link= requireView().findViewById<EditText>(R.id.Link)
        val li = link.text.toString()

        if(estu == "" && domicilio == "" && face == "" && insta == "" && whats == "" && des == "" && li == ""){
            Toast.makeText(requireContext(),"Llena todos los campos", Toast.LENGTH_SHORT).show()
        }else{
            val id = 1
            val id2 = 2
            val id3 = 3
            GlobalScope.launch {
                appDb.ESTUDIODao.updateInfo(estu,domicilio,des,li,id)
            }
            GlobalScope.launch {
                appDb.INFODao.updateContacto(face,id)
            }
            GlobalScope.launch {
                appDb.INFODao.updateContacto(insta,id2)
            }
            GlobalScope.launch {
                appDb.INFODao.updateContacto(whats,id3)
            }
            nombreEstudio.setText("")
            direccion.setText("")
            facebook.setText("")
            instagram.setText("")
            whatsapp.setText("")
            descripcion.setText("")
            link.setText("")
        }
        regresar()
    }
}