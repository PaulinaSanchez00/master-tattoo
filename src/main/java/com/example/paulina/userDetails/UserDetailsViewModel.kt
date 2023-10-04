package com.example.paulina.userDetails

import android.app.Application
import android.util.Log
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.paulina.database.repositoryes.RegisterRepository

class UserDetailsViewModel (repository: RegisterRepository, application: Application):AndroidViewModel(application){

    val users = repository.users
    init {
        Log.i("MYTAG","inside_users_Lisrt_init")
    }


    private val _navigateto = MutableLiveData<Boolean>()

    val navigateto: LiveData<Boolean>
        get() = _navigateto

    fun doneNavigating(){
        _navigateto.value=false
    }

    fun backButtonclicked(){
        _navigateto.value = true
    }

}