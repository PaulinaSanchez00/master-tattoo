package com.example.paulina.comprobador



import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.example.paulina.R
import com.example.paulina.database.BD.RegisterDatabase
import com.example.paulina.database.repositoryes.RegisterRepository
import com.example.paulina.databinding.FragmentComprobadorBinding

class ComprobadorFragment : Fragment() {

    private lateinit var registerViewModel: ComprobadorViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val binding: FragmentComprobadorBinding = DataBindingUtil.inflate(
            inflater,
            R.layout.fragment_comprobador, container, false
        )

        val application = requireNotNull(this.activity).application

        val dao = RegisterDatabase.getInstance(application).registerDatabaseDao

        val repository = RegisterRepository(dao)

        val factory = ComprobadorViewModelFactory(repository, application)

        registerViewModel = ViewModelProvider(this, factory)[ComprobadorViewModel::class.java]
        binding.myViewModel = registerViewModel

        binding.lifecycleOwner = this

        registerViewModel.getCount()?.observe(viewLifecycleOwner) { integer ->

            val wordcount = requireView().findViewById<TextView>(R.id.word_count)
            wordcount.text = integer.toString()
            val i = wordcount.text.toString()
            if (i == "0") {
                val btnCot = requireView().findViewById<Button>(R.id.btnContinuar)

                btnCot.setOnClickListener {
                    @Suppress("UNUSED VARIABLE")
                    findNavController().navigate(R.id.action_bienvenida32_to_registerFragment)
                }
            } else {
                val btnCot = requireView().findViewById<Button>(R.id.btnContinuar)

                btnCot.setOnClickListener {
                    findNavController().navigate(R.id.action_bienvenida32_to_loginFragment)
                }
            }
        }



        return binding.root
    }
}

