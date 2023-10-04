package com.example.paulina.menuadmi.tarifasadmmenu

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.paulina.R

class Tarifa : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.fragment_tarifas)
        supportActionBar?.hide()
    }
}