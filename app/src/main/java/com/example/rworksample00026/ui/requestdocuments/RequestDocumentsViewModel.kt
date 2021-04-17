package com.example.rworksample00026.ui.requestdocuments

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import com.example.rworksample00026.RworkDatabase
import com.example.rworksample00026.model.dao.RequestDocumentsPersonInfoDao
import com.example.rworksample00026.model.entity.RequestDocumentsPersonInfo
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class RequestDocumentsViewModel(application: Application):AndroidViewModel(application) {

    private val requestDocumentsPersonInfoDao: RequestDocumentsPersonInfoDao


    init {
        //val query = SimpleSQLiteQuery("PRAGMA key = 'passphrase'")
        val db = RworkDatabase.buildDatabase(application)
        requestDocumentsPersonInfoDao = db.requestDocumentsPersonInfoDao()


    }

    val personData = requestDocumentsPersonInfoDao.loadAllRequestDocumentsPersonInfo()
    val personDataAll = requestDocumentsPersonInfoDao.loadAllRequestDocumentsPersonInfoLiveData()
    //val count = requestDocumentsPersonInfoDao.recordsCount()


    fun insert(name: String, phoneticGuides: String, birthday: String, mailAddress: String, phoneNumber: String) {
        viewModelScope.launch(Dispatchers.IO) {
            requestDocumentsPersonInfoDao.saveRequestDocumentsPersonInfo(
                    RequestDocumentsPersonInfo(
                            id = 0,
                            name = name,
                            phoneticGuides = phoneticGuides,
                            birthday = birthday,
                            mailAddress = mailAddress,
                            phoneNumber = phoneNumber,
                            zipStr = "",
                            prefecture = "",
                            city = "",
                            address = "",
                            disableCertifidate = "",
                            sendingMaterials = "",
                            remarks = ""
                    )
            )
        }
    }

    fun updateProfile(name: String, phoneticGuides: String, birthday: String, mailAddress: String, phoneNumber: String) {
        viewModelScope.launch (Dispatchers.Unconfined) {
            val editPersonInfo = personData.first()
            editPersonInfo.name = name
            editPersonInfo.phoneticGuides = phoneticGuides
            editPersonInfo.birthday = birthday
            editPersonInfo.mailAddress = mailAddress
            editPersonInfo.phoneNumber = phoneNumber
            requestDocumentsPersonInfoDao.updateRequestDocumentsPersonInfo(editPersonInfo)
        }
    }

    fun updateAddress(zipStr: String, prefecture: String, city: String, address: String) {
        viewModelScope.launch (Dispatchers.Unconfined) {
            val editPersonInfo = personData.first()
            editPersonInfo.zipStr = zipStr
            editPersonInfo.prefecture = prefecture
            editPersonInfo.city = city
            editPersonInfo.address = address
            requestDocumentsPersonInfoDao.updateRequestDocumentsPersonInfo(editPersonInfo)
        }
    }

    fun updateParam(disableCertificate: String, sendingMaterials: String, remarks: String) {
        viewModelScope.launch (Dispatchers.Unconfined) {
            val editPersonInfo = personData.first()
            editPersonInfo.disableCertifidate = disableCertificate
            editPersonInfo.sendingMaterials = sendingMaterials
            editPersonInfo.remarks = remarks
            requestDocumentsPersonInfoDao.updateRequestDocumentsPersonInfo(editPersonInfo)
        }
    }

    fun updateName(name: String) {
        viewModelScope.launch (Dispatchers.IO){
            val editPersonInfo = personData.first()
            editPersonInfo.name = name
            requestDocumentsPersonInfoDao.updateRequestDocumentsPersonInfo(editPersonInfo)
        }
    }

    fun updatePhoneticGuides(phoneticGuides: String) {
        viewModelScope.launch (Dispatchers.IO) {
            val editPersonInfo = personData.first()
            editPersonInfo.phoneticGuides = phoneticGuides
            requestDocumentsPersonInfoDao.updateRequestDocumentsPersonInfo(editPersonInfo)
        }
    }

    fun updateBirthday(birthday: String) {
        viewModelScope.launch (Dispatchers.IO) {
            val editPersonInfo = personData.first()
            editPersonInfo.birthday = birthday
            requestDocumentsPersonInfoDao.updateRequestDocumentsPersonInfo(editPersonInfo)
        }
    }

    fun updateMailAddress(mailAddress: String) {
        viewModelScope.launch(Dispatchers.IO) {
            val editPersonInfo = personData.first()
            editPersonInfo.mailAddress = mailAddress
            requestDocumentsPersonInfoDao.updateRequestDocumentsPersonInfo(editPersonInfo)
        }
    }

    fun updatePhoneNumber(phoneNumber: String) {
        val editPersonInfo = personData.first()
        editPersonInfo.phoneNumber = phoneNumber
        requestDocumentsPersonInfoDao.updateRequestDocumentsPersonInfo(editPersonInfo)
    }

    fun updateZipStr(zipStr: String) {
        val editPersonInfo = personData.first()
        editPersonInfo.zipStr = zipStr
        requestDocumentsPersonInfoDao.updateRequestDocumentsPersonInfo(editPersonInfo)
    }

    fun updatePrefecture(prefecture: String) {
        val editPersonInfo = personData.first()
        editPersonInfo.prefecture = prefecture
        requestDocumentsPersonInfoDao.updateRequestDocumentsPersonInfo(editPersonInfo)
    }

    fun updateCity(city: String) {
        val editPersonInfo = personData.first()
        editPersonInfo.city = city
        requestDocumentsPersonInfoDao.updateRequestDocumentsPersonInfo(editPersonInfo)
    }

    fun updateAddressMod(address: String) {
        val editPersonInfo = personData.first()
        editPersonInfo.address = address
        requestDocumentsPersonInfoDao.updateRequestDocumentsPersonInfo(editPersonInfo)
    }

    fun updateDisableCertificate(disableCertificate: String) {
        val editPersonInfo = personData.first()
        editPersonInfo.disableCertifidate = disableCertificate
        requestDocumentsPersonInfoDao.updateRequestDocumentsPersonInfo(editPersonInfo)
    }

    fun updateSendingMaterials(sendingMaterials: String) {
        val editPersonInfo = personData.first()
        editPersonInfo.sendingMaterials = sendingMaterials
        requestDocumentsPersonInfoDao.updateRequestDocumentsPersonInfo(editPersonInfo)
    }

    fun updateRemarks (remarks: String) {
        val editPersonInfo = personData.first()
        editPersonInfo.remarks = remarks
        requestDocumentsPersonInfoDao.updateRequestDocumentsPersonInfo(editPersonInfo)
    }

    fun deleteLastRecord(){
        val deletePersonInfo = personData.last()
        requestDocumentsPersonInfoDao.deleteRequestDocumentsPersonInfo(deletePersonInfo)
    }

    fun deleteFirstRecord(){
        val deletePersonInfo = personData.first()
        requestDocumentsPersonInfoDao.deleteRequestDocumentsPersonInfo(deletePersonInfo)
    }

}