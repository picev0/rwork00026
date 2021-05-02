package com.example.rworksample00026.model.dao

import androidx.lifecycle.LiveData
import androidx.room.*
import com.example.rworksample00026.model.entity.DailyReports
import com.example.rworksample00026.model.entity.User

@Dao
interface DailyReportsDao {

    // データ取得メソッド
    @Query("SELECT * FROM daily_reports")
    fun loadAllReports(): List<DailyReports>

    @Query("SELECT * FROM daily_reports")
    fun loadAllReportsLiveData(): LiveData<List<DailyReports>>

    // 挿入メソッド
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun saveReports(vararg dailyReports: DailyReports)

    // 更新メソッド
    @Update(onConflict = OnConflictStrategy.REPLACE)
    fun update(dailyReports: DailyReports)

    // 削除メソッド
    @Delete
    fun delete(dailyReports: DailyReports)

    // Test
    @Insert
    fun insertAll(vararg dailyReports: DailyReports )

    @Query("SELECT * FROM daily_reports WHERE name = :name")
    fun findByName(name: String): List<DailyReports>

}