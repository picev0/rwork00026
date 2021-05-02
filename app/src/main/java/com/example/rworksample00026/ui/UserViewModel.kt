package com.example.rworksample00026.ui

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import com.example.rworksample00026.RworkDatabase
import com.example.rworksample00026.model.dao.UserDao
import com.example.rworksample00026.model.entity.User
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class UserViewModel(application: Application): AndroidViewModel(application) {

    private val userDao: UserDao

    init {

            val db = RworkDatabase.buildDatabase(application)
            userDao = db.userDao()

    }

    val emailList = userDao.loadUser()
    //val user = emailList.last()

    fun insert(name: String,gmail: String){
        viewModelScope.launch (Dispatchers.IO){
            userDao.saveUser(
                User(
                    id = 0,
                    name = name,
                    gmail = gmail
                )
            )
        }
    }

    fun deleteUser(){
        val userData = emailList.first()
        userDao.deleteUser(userData)
    }
}