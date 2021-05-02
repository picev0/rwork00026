package com.example.rworksample00026

import com.example.rworksample00026.model.entity.RequestDocumentsPersonInfo
import com.example.rworksample00026.model.entity.User

class RequestDocumentsLocalDataSource(val db: RworkDatabase) {

    fun insertAll(vararg requestDocumentsPersonInfo: RequestDocumentsPersonInfo) {
        db.requestDocumentsPersonInfoDao().insertAll(*requestDocumentsPersonInfo)
    }

    fun findByName(name: String): List<RequestDocumentsPersonInfo> {
        return db.requestDocumentsPersonInfoDao().findByName(name)
    }
}