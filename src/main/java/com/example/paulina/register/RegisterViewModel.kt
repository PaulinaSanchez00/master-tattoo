package com.example.paulina.register

import android.app.Application
import android.util.Log
import androidx.databinding.*
import androidx.lifecycle.*
import com.example.paulina.database.Entity.RegisterEntity
import com.example.paulina.database.repositoryes.RegisterRepository
import kotlinx.coroutines.*


class RegisterViewModel(private val repository: RegisterRepository, application: Application) :
    AndroidViewModel(application), Observable {



    init {
        Log.i("MYTAG", "init")
    }
    var userDetailsLiveData = MutableLiveData<Array<RegisterEntity>>()

    @Bindable
    val inputUsername = MutableLiveData<String?>()

    @Bindable
    val inputPassword = MutableLiveData<String?>()

    private val viewModelJob = Job()
    private val uiScope = CoroutineScope(Dispatchers.Main + viewModelJob)


    private val _navigateto = MutableLiveData<Boolean>()

    val navigateto: LiveData<Boolean>
        get() = _navigateto

    private val _errorToast = MutableLiveData<Boolean>()

    val errotoast: LiveData<Boolean>
        get() = _errorToast

    private val _errorToastUsername = MutableLiveData<Boolean>()

    fun sumbitButton() {
        Log.i("MYTAG", "Inside SUBMIT BUTTON")
        if (inputUsername.value == null || inputPassword.value == null) {
            _errorToast.value = true
        } else {
            uiScope.launch {
//            withContext(Dispatchers.IO) {
                val usersNames = repository.getUserName(inputUsername.value!!)
                Log.i("MYTAG", usersNames.toString() + "------------------")
                if (usersNames != null) {
                    _errorToastUsername.value = true
                    Log.i("MYTAG", "Inside if Not null")
                } else {
                    Log.i("MYTAG", userDetailsLiveData.value.toString() + "ASDFASDFASDFASDF")
                    Log.i("MYTAG", "OK im in")
                    val email = inputUsername.value!!
                    val password = inputPassword.value!!
                    Log.i("MYTAG", "insidi Sumbit")
                    insert(RegisterEntity(0, email, password))
                    inputUsername.value = null
                    inputPassword.value = null
                    _navigateto.value = true
                }
            }
        }
    }


    fun doneNavigating() {
        _navigateto.value = false
        Log.i("MYTAG", "Done navigating ")
    }

    fun donetoast() {
        _errorToast.value = false
        Log.i("MYTAG", "Done taoasting ")
    }
    private fun insert(user: RegisterEntity): Job = viewModelScope.launch {
        repository.insert(user)
    }

//    fun clearALl():Job = viewModelScope.launch {
//        repository.deleteAll()
//    }

    override fun removeOnPropertyChangedCallback(callback: Observable.OnPropertyChangedCallback?) {

    }

    override fun addOnPropertyChangedCallback(callback: Observable.OnPropertyChangedCallback?) {

    }


}







