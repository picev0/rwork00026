package com.example.rworksample00026.model.dao

import androidx.lifecycle.LiveData
import androidx.room.*
import com.example.rworksample00026.model.entity.RequestDocumentsPersonInfo

@Dao
interface RequestDocumentsPersonInfoDao {

    // データ取得メソッド
    @Query("SELECT * FROM request_documents_person_info")
    fun loadAllRequestDocumentsPersonInfo(): List<RequestDocumentsPersonInfo>

    @Query("SELECT * FROM request_documents_person_info")
    fun loadAllRequestDocumentsPersonInfoLiveData(): LiveData<List<RequestDocumentsPersonInfo>>

    // 挿入メソッド
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun saveRequestDocumentsPersonInfo(vararg requestDocumentsPersonInfo: RequestDocumentsPersonInfo)

    // 更新メソッド
    @Update(onConflict = OnConflictStrategy.REPLACE)
    fun updateRequestDocumentsPersonInfo(requestDocumentsPersonInfo: RequestDocumentsPersonInfo)

    // 削除メソッド
    @Delete
    fun deleteRequestDocumentsPersonInfo(requestDocumentsPersonInfo: RequestDocumentsPersonInfo)

}