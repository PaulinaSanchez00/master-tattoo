package com.example.paulina.userDetails

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.paulina.R
import com.example.paulina.database.Entity.RegisterEntity
import com.example.paulina.databinding.ListItemBinding

class MyRecycleViewAdapter(private val usersList :List<RegisterEntity>):RecyclerView.Adapter<MyviewHolder>(){
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyviewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val binding: ListItemBinding =
            DataBindingUtil.inflate(layoutInflater, R.layout.list_item,parent,false)
        return MyviewHolder(binding)
    }

    override fun getItemCount(): Int {
        return usersList.size
    }

    override fun onBindViewHolder(holder: MyviewHolder, position: Int) {
        holder.bind(usersList[position])

    }


}

class MyviewHolder(private val binding :ListItemBinding ):RecyclerView.ViewHolder(binding.root){

    fun bind(user : RegisterEntity){
        binding.userTextField.text = user.userName
    }

}