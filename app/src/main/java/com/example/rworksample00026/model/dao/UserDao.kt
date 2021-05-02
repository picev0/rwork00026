package com.example.rworksample00026.model.dao

import androidx.room.*
import com.example.rworksample00026.model.entity.User

@Dao
interface UserDao {


    @Query("SELECT * from user")
    fun loadUser(): List<User>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun saveUser(vararg user: User)

    @Insert
    fun insertAll(vararg user: User)

    @Delete
    fun deleteUser(user : User)

    @Query("SELECT * FROM user WHERE name = :name")
    fun findByName(name: String): List<User>

}