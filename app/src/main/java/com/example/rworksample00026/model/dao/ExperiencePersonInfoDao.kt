package com.example.rworksample00026.model.dao

import androidx.lifecycle.LiveData
import androidx.room.*
import com.example.rworksample00026.model.entity.ExperiencePersonInfo

@Dao
interface ExperiencePersonInfoDao {

    // データ取得メソッド
    @Query("SELECT * FROM experience_person_info")
    fun loadAllExperiencePersonInfo(): List<ExperiencePersonInfo>

    @Query("SELECT * FROM experience_person_info")
    fun loadAllExperiencePersonInfoLiveData(): LiveData<List<ExperiencePersonInfo>>

    // 挿入メソッド
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun saveExperiencePersonInfo(vararg experiencePersonInfo: ExperiencePersonInfo)

    // 更新メソッド
    @Update(onConflict = OnConflictStrategy.REPLACE)
    fun updateExperiencePersonInfo(experiencePersonInfo: ExperiencePersonInfo)

    // 削除メソッド
    @Delete
    fun deleteExperiencePersonInfo(experiencePersonInfo: ExperiencePersonInfo)

}