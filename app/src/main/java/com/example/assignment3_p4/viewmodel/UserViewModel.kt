package com.example.assignment3_p4.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import com.example.assignment3_p4.database.AppDatabase
import com.example.assignment3_p4.models.User
import kotlinx.coroutines.launch

//class UserViewModel : ViewModel() {
//    private val _users = MutableLiveData<List<String>>()
//    val users: LiveData<List<String>> get() = _users
//    private val _inputText = MutableLiveData<String>()
//    val inputText: LiveData<String> get() = _inputText
//
//    init {
//        _users.value = listOf("Torebek", "Bob", "Anna")
//    }
//
//    fun addUser() {
//        val newUser = _inputText.value ?: return
//        _users.value = _users.value?.plus(newUser)
//        _inputText.value = ""
//    }
//
//    fun updateInputText(newText: String) {
//        _inputText.value = newText
//    }
//}

class UserViewModel(application: Application) : AndroidViewModel(application) {

    private val userDao = AppDatabase.getDatabase(application).userDao()
    val users: LiveData<List<User>> = userDao.getAllUsers()

    fun addUser(name: String) {
        viewModelScope.launch {
            userDao.insert(User(name = name))
        }
    }
}


