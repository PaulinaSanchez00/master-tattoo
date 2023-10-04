package com.example.paulina.cotizar.controllers

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.paulina.R
import com.example.paulina.cotizar.controllers.Imgcontroller.*
import com.example.paulina.cotizar.imgEstilo.ImgEstilo
import com.example.paulina.databinding.ItemEstilosBinding

class Imgcontroller( private val ImgList:MutableList<ImgEstilo>, private val onClickListener:(ImgEstilo)->Unit) : RecyclerView.Adapter<ImgHolder>() {
    lateinit var context: Context
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ImgHolder {
        val layoutInflater= LayoutInflater.from(parent.context).inflate(R.layout.item_estilos,parent, false)
        return ImgHolder(layoutInflater)
    }

    override fun onBindViewHolder(holder: ImgHolder, position: Int) {
        val item=ImgList[position]
        holder.render(item, onClickListener)
    }

    override fun getItemCount(): Int = ImgList.size

    class ImgHolder(view: View, ):RecyclerView.ViewHolder(view){
        val binding = ItemEstilosBinding.bind(view)
            fun render(imgEstiloModel: ImgEstilo,onClickListener: (ImgEstilo) -> Unit){
                binding.Estilo.text = imgEstiloModel.estilo
                binding.img1.setImageResource(imgEstiloModel.img)
                binding.img2.setImageResource(imgEstiloModel.img1)
                binding.Estilo.setOnClickListener { onClickListener(imgEstiloModel)}
                binding.img2.setOnClickListener { onClickListener(imgEstiloModel) }
                binding.img1.setOnClickListener { onClickListener(imgEstiloModel) }
        }




    }


}