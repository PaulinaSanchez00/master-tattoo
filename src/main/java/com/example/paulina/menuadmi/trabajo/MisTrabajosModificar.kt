package com.example.paulina.menuadmi.trabajo

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import androidx.lifecycle.LiveData
import com.example.paulina.R
import com.example.paulina.database.BD.RegisterDatabase
import com.example.paulina.database.Entity.IMG
import com.example.paulina.menuadmi.imagenes.ImageController
import com.example.paulina.menuadmi.imagenes.NuevaImagen
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MisTrabajosModificar : AppCompatActivity() {

    //Producto Activity

    private lateinit var database: RegisterDatabase
    private lateinit var imagen: IMG
    private lateinit var imagenLiveData: LiveData<IMG>
    private val editactivity = 49

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_mis_trabajos_modificar)

        database = RegisterDatabase.getInstance(this)

        val idImagen = intent.getIntExtra("id",0)

        val imageUri = ImageController.getImageUri(this,idImagen.toLong())
        val trabajo = findViewById<ImageView>(R.id.trabajo)
        trabajo.setImageURI(imageUri)

        imagenLiveData = database.IMG().get(idImagen)

        imagenLiveData.observe(this) {
            imagen = it

        }

        val modificar = findViewById<Button>(R.id.Modificar)
        modificar.setOnClickListener{
            val intent = Intent(this, NuevaImagen::class.java)
            intent.putExtra("imagen",imagen)
            startActivityForResult(intent, editactivity)
        }
        val eliminar = findViewById<Button>(R.id.Eliminar)
        eliminar.setOnClickListener{
            imagenLiveData.removeObservers(this)
            CoroutineScope(Dispatchers.IO).launch {
                database.IMG().delete(imagen)
                this@MisTrabajosModificar.finish()
            }
        }
        val regresar = findViewById<Button>(R.id.regresar)
        regresar.setOnClickListener {
            this@MisTrabajosModificar.finish()
        }
    }

    @Deprecated("Deprecated in Java")
    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        val imageSelectiv = findViewById<ImageView>(R.id.trabajo)
        when {
            requestCode == editactivity && resultCode == Activity.RESULT_OK -> {
                imageSelectiv.setImageURI(data!!.data)
            }
        }
    }
}