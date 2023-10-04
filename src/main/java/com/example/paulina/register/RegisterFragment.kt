package com.example.paulina.register

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.NavHostFragment
import com.example.paulina.R
import com.example.paulina.database.BD.RegisterDatabase
import com.example.paulina.database.repositoryes.RegisterRepository
import com.example.paulina.databinding.RegisterHomeFragmentBinding

class RegisterFragment : Fragment() {

    private lateinit var registerViewModel: RegisterViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val binding: RegisterHomeFragmentBinding = DataBindingUtil.inflate(
            inflater,
            R.layout.register_home_fragment, container, false
        )

        val application = requireNotNull(this.activity).application

        val dao = RegisterDatabase.getInstance(application).registerDatabaseDao

        val repository = RegisterRepository(dao)

        val factory = RegisterViewModelFactory(repository, application)

        registerViewModel = ViewModelProvider(this, factory)[RegisterViewModel::class.java]
        binding.myViewModel = registerViewModel

        binding.lifecycleOwner = this
        
        registerViewModel.navigateto.observe(viewLifecycleOwner) { hasFinished ->
            if (hasFinished == true) {
                Log.i("MYTAG", "insidi observe")
                displayUsersList()
                registerViewModel.doneNavigating()
            }
        }

        registerViewModel.userDetailsLiveData.observe(viewLifecycleOwner) {
            Log.i("MYTAG", it.toString() + "000000000000000000000000")
        }

        registerViewModel.errotoast.observe(viewLifecycleOwner) { hasError ->
            if (hasError == true) {
                Toast.makeText(
                    requireContext(),
                    "Por favor llene todos los campos",
                    Toast.LENGTH_SHORT
                ).show()
                registerViewModel.donetoast()
            }
        }
        return binding.root
    }

    private fun displayUsersList() {
        Log.i("MYTAG","insidisplayUsersList")
        val action = RegisterFragmentDirections.actionRegisterFragmentToBienvenida32()
        NavHostFragment.findNavController(this).navigate(action)

    }
}
