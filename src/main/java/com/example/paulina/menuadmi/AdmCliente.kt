package com.example.paulina.menuadmi

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.example.paulina.R
import com.example.paulina.menu_cliente.MenuCliente
import java.util.concurrent.Executors
import java.util.concurrent.TimeUnit

class AdmCliente : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_adm_cliente)
        supportActionBar?.hide()
        Executors.newSingleThreadScheduledExecutor().schedule({
            val siguiente = Intent(this, MenuCliente::class.java)
            startActivity(siguiente)
        }, 3, TimeUnit.SECONDS)
    }
}