package com.example.paulina.preinicio

import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.example.paulina.R
class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        supportActionBar?.hide()

        val buttonOpen : Button = findViewById(R.id.btnIr)
        buttonOpen.setOnClickListener{
            val myFRagment = Bienvenida1()
            val fragment : Fragment? =
                supportFragmentManager.findFragmentByTag(Bienvenida1::class.java.simpleName)
            if(fragment !is Bienvenida1){
                supportFragmentManager.beginTransaction()
                    .add(R.id.LinearFragment_Container,myFRagment, Bienvenida1::class.java.simpleName)
                    .commit()
            }
            buttonOpen.visibility = View.GONE
        }
    }

}