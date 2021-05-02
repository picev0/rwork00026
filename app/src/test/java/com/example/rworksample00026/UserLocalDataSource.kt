package com.example.rworksample00026

import com.example.rworksample00026.model.entity.User

class UserLocalDataSource(val db: RworkDatabase) {
    fun insertAll(vararg users: User) {
        db.userDao().insertAll(*users)
    }

    fun findByName(name: String): List<User> {
        return db.userDao().findByName(name)
    }
}