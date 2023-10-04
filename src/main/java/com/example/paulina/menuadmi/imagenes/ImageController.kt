package com.example.paulina.menuadmi.imagenes

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.net.Uri
import java.io.File

object ImageController {
    fun selectPhotoFromGallery(activity: Activity,code:Int ) {
        val intentGaleria = Intent(Intent.ACTION_PICK)
        intentGaleria.type = "image/*"
        activity.startActivityForResult(intentGaleria,code)
    }
    fun saveImage(context: Context, id: Long, uri: Uri) {
        val file = File(context.filesDir, id.toString())
        val bytes = context.contentResolver.openInputStream(uri)?.readBytes()!!
        file.writeBytes(bytes)
    }
    fun getImageUri(context: Context, id:Long): Uri {
        val file = File(context.filesDir, id.toString())
        return  if (file.exists()) Uri.fromFile(file)
        else Uri.parse("android.resource://com.example.paulina/drawable/sinimagen")
    }
}