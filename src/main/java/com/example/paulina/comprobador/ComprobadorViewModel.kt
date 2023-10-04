package com.example.paulina.comprobador

import android.app.Application
import androidx.databinding.*
import androidx.lifecycle.*
import com.example.paulina.database.repositoryes.RegisterRepository


class ComprobadorViewModel(private val repository: RegisterRepository, application: Application) :
    AndroidViewModel(application), Observable {

    fun getCount(): LiveData<Int?>? {
        return repository.getNumFiles()
    }

    override fun removeOnPropertyChangedCallback(callback: Observable.OnPropertyChangedCallback?) {

    }

    override fun addOnPropertyChangedCallback(callback: Observable.OnPropertyChangedCallback?) {

    }


}







