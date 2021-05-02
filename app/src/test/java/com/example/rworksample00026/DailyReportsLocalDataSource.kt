package com.example.rworksample00026

import com.example.rworksample00026.model.entity.DailyReports
import com.example.rworksample00026.model.entity.RequestDocumentsPersonInfo

class DailyReportsLocalDataSource(val db: RworkDatabase){

    fun insertAll(vararg dailyReports: DailyReports) {
        db.dailyReportsDao().insertAll(*dailyReports)
    }

    fun findByName(name: String): List<DailyReports> {
        return db.dailyReportsDao().findByName(name)
    }
}