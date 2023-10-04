package com.example.paulina.menuadmi.imagenes

import android.annotation.SuppressLint
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.ImageView
import com.example.paulina.R
import com.example.paulina.database.Entity.IMG

class ImagenAdapter(private val mContext: Context, private val listaProductos: List<IMG>) : ArrayAdapter<IMG>(mContext,0, listaProductos) {
    @SuppressLint("ViewHolder")
    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        val layout = LayoutInflater.from(mContext).inflate(R.layout.item_imagen, parent, false)
        val image = listaProductos[position]
        val imageV = layout.findViewById<ImageView>(R.id.imageView)


        val imageUri = ImageController.getImageUri(mContext, image.ID.toLong())
        imageV.setImageURI(imageUri)
        return layout
    }
}
