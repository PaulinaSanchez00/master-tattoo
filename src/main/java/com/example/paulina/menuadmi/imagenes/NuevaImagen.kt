package com.example.paulina.menuadmi.imagenes

import android.app.Activity
import android.content.Intent
import android.content.pm.PackageManager
import android.net.Uri
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.Toast
import androidx.core.content.ContextCompat
import com.example.paulina.R
import com.example.paulina.database.BD.RegisterDatabase
import com.example.paulina.database.Entity.IMG
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class NuevaImagen : AppCompatActivity() {

    private lateinit var appDb: RegisterDatabase
    private val selectActivity = 50
    private var imageUri: Uri? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_nueva_imagen)

        var idImagen: Int? = null

        if(intent.hasExtra("imagen")){
            val producto = intent.extras?.getSerializable("imagen") as IMG
            idImagen = producto.ID

            val imageUri = ImageController.getImageUri(this, idImagen.toLong())
            val imageSelectiv = findViewById<ImageView>(R.id.imageSelect_iv)
            imageSelectiv.setImageURI(imageUri)
        }

        appDb = RegisterDatabase.getInstance(this)

        val guardar = findViewById<Button>(R.id.guardar)
        guardar.setOnClickListener{
            val imagen = IMG(1, R.drawable.logo)

            if(idImagen != null){
                CoroutineScope(Dispatchers.IO).launch {
                    imagen.ID = idImagen

                    appDb.IMG().update(imagen)

                    imageUri?.let {
                        val intent = Intent()
                        intent.data = it
                        setResult(Activity.RESULT_OK,intent)
                        ImageController.saveImage(this@NuevaImagen, idImagen.toLong(), it)

                    }

                    this@NuevaImagen.finish()
                }
            }else{
                CoroutineScope(Dispatchers.IO).launch {
                    val id = appDb.IMG().insert(imagen)[0]

                    imageUri?.let {
                        ImageController.saveImage(this@NuevaImagen, id, it)

                    }

                    this@NuevaImagen.finish()
                }
            }
        }
        val imageSelectiv = findViewById<ImageView>(R.id.imageSelect_iv)
        imageSelectiv.setOnClickListener{
            if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.M){
                if (this.applicationContext?.let { it1 -> ContextCompat.checkSelfPermission(it1,android.Manifest.permission.READ_EXTERNAL_STORAGE) } == PackageManager.PERMISSION_DENIED){
                    val permisoArchivos = arrayOf(android.Manifest.permission.READ_EXTERNAL_STORAGE)
                    requestPermissions(permisoArchivos,selectActivity)
                }else{
                    ImageController.selectPhotoFromGallery(this, selectActivity)
                }
            }else{
                ImageController.selectPhotoFromGallery(this, selectActivity)
            }
        }
    }

    @Deprecated("Deprecated in Java")
    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        val imageSelectiv = findViewById<ImageView>(R.id.imageSelect_iv)
        when {
            requestCode == selectActivity && resultCode == Activity.RESULT_OK ->{
                imageUri = data!!.data

                imageSelectiv.setImageURI(imageUri)
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
            selectActivity ->{
                if(grantResults[0] == PackageManager.PERMISSION_GRANTED)
                    ImageController.selectPhotoFromGallery(this, selectActivity)
                else
                    Toast.makeText(this.applicationContext ,"No puedes acceder a tus imagenes.",
                        Toast.LENGTH_SHORT).show()
            }
        }
    }

}