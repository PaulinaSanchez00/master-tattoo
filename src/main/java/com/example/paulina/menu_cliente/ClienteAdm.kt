package com.example.paulina.menu_cliente

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ProgressBar
import androidx.fragment.app.Fragment
import com.example.paulina.R
import java.util.concurrent.Executors
import java.util.concurrent.TimeUnit

class ClienteAdm : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_cliente_adm)

        Executors.newSingleThreadScheduledExecutor().schedule({
            val myFRagment = ContenedorComprobanteAdm()
            val fragment : Fragment? =
                supportFragmentManager.findFragmentByTag(ContenedorComprobanteAdm::class.java.simpleName)
            if(fragment !is ContenedorComprobanteAdm){
                supportFragmentManager.beginTransaction()
                    .add(R.id.LinearFragment_Container,myFRagment, ContenedorComprobanteAdm::class.java.simpleName)
                    .commit()
            }
            View.GONE
        }, 3, TimeUnit.SECONDS)

    }
}