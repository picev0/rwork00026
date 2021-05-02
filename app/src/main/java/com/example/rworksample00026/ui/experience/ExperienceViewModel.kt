package com.example.rworksample00026.ui.experience

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import com.example.rworksample00026.RworkDatabase
import com.example.rworksample00026.model.dao.ExperiencePersonInfoDao
import com.example.rworksample00026.model.dao.RequestDocumentsPersonInfoDao
import com.example.rworksample00026.model.entity.ExperiencePersonInfo
import com.example.rworksample00026.model.entity.RequestDocumentsPersonInfo
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class ExperienceViewModel(application: Application): AndroidViewModel(application){
    private val experiencePersonInfoDao: ExperiencePersonInfoDao


    init {
        //val query = SimpleSQLiteQuery("PRAGMA key = 'passphrase'")
        val db = RworkDatabase.buildDatabase(application)
        experiencePersonInfoDao = db.experiencePersonInfoDao()


    }

    val personData = experiencePersonInfoDao.loadAllExperiencePersonInfo()
    val personDataAll = experiencePersonInfoDao.loadAllExperiencePersonInfoLiveData()
    //val count = requestDocumentsPersonInfoDao.recordsCount()


    fun insert(applicationForm: String, name: String, phoneticGuides: String, birthday: String, phoneNumber: String) {
        viewModelScope.launch(Dispatchers.IO) {
            experiencePersonInfoDao.saveExperiencePersonInfo(
                ExperiencePersonInfo(
                    id = 0,
                    name = name,
                    applicationForm = applicationForm,
                    phoneticGuides = phoneticGuides,
                    birthday = birthday,
                    mailAddress = "",
                    phoneNumber = phoneNumber,
                    zipStr = "",
                    prefecture = "",
                    city = "",
                    address = "",
                    disableCertifidate = "",
                    desiredDateFirstCandidate = "",
                    desiredDateSecondCandidate = "",
                    desiredDateThirdCandidate = "",
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
            experiencePersonInfoDao.updateExperiencePersonInfo(editPersonInfo)
        }
    }

    fun updateAddress(zipStr: String, prefecture: String, city: String, address: String) {
        viewModelScope.launch (Dispatchers.Unconfined) {
            val editPersonInfo = personData.first()
            editPersonInfo.zipStr = zipStr
            editPersonInfo.prefecture = prefecture
            editPersonInfo.city = city
            editPersonInfo.address = address
            experiencePersonInfoDao.updateExperiencePersonInfo(editPersonInfo)
        }
    }

    fun updateParam(disableCertificate: String, desiredDateFirstCandidate: String, desiredDateSecondCandidate: String, desiredDateThirdCandidate: String, remarks: String) {
        viewModelScope.launch (Dispatchers.Unconfined) {
            val editPersonInfo = personData.first()
            editPersonInfo.disableCertifidate = disableCertificate
            editPersonInfo.desiredDateFirstCandidate = desiredDateFirstCandidate
            editPersonInfo.desiredDateSecondCandidate = desiredDateSecondCandidate
            editPersonInfo.desiredDateThirdCandidate = desiredDateThirdCandidate
            editPersonInfo.remarks = remarks
            experiencePersonInfoDao.updateExperiencePersonInfo(editPersonInfo)
        }
    }

    fun updateName(name: String) {
        viewModelScope.launch (Dispatchers.IO){
            val editPersonInfo = personData.first()
            editPersonInfo.name = name
            experiencePersonInfoDao.updateExperiencePersonInfo(editPersonInfo)
        }
    }

    fun updatePhoneticGuides(phoneticGuides: String) {
        viewModelScope.launch (Dispatchers.IO) {
            val editPersonInfo = personData.first()
            editPersonInfo.phoneticGuides = phoneticGuides
            experiencePersonInfoDao.updateExperiencePersonInfo(editPersonInfo)
        }
    }

    fun updateBirthday(birthday: String) {
        viewModelScope.launch (Dispatchers.IO) {
            val editPersonInfo = personData.first()
            editPersonInfo.birthday = birthday
            experiencePersonInfoDao.updateExperiencePersonInfo(editPersonInfo)
        }
    }

    fun updateMailAddress(mailAddress: String) {
        viewModelScope.launch(Dispatchers.IO) {
            val editPersonInfo = personData.first()
            editPersonInfo.mailAddress = mailAddress
            experiencePersonInfoDao.updateExperiencePersonInfo(editPersonInfo)
        }
    }

    fun updatePhoneNumber(phoneNumber: String) {
        val editPersonInfo = personData.first()
        editPersonInfo.phoneNumber = phoneNumber
        experiencePersonInfoDao.updateExperiencePersonInfo(editPersonInfo)
    }

    fun updateZipStr(zipStr: String) {
        val editPersonInfo = personData.first()
        editPersonInfo.zipStr = zipStr
        experiencePersonInfoDao.updateExperiencePersonInfo(editPersonInfo)
    }

    fun updatePrefecture(prefecture: String) {
        val editPersonInfo = personData.first()
        editPersonInfo.prefecture = prefecture
        experiencePersonInfoDao.updateExperiencePersonInfo(editPersonInfo)
    }

    fun updateCity(city: String) {
        val editPersonInfo = personData.first()
        editPersonInfo.city = city
        experiencePersonInfoDao.updateExperiencePersonInfo(editPersonInfo)
    }

    fun updateAddressMod(address: String) {
        val editPersonInfo = personData.first()
        editPersonInfo.address = address
        experiencePersonInfoDao.updateExperiencePersonInfo(editPersonInfo)
    }

    fun updateDisableCertificate(disableCertificate: String) {
        val editPersonInfo = personData.first()
        editPersonInfo.disableCertifidate = disableCertificate
        experiencePersonInfoDao.updateExperiencePersonInfo(editPersonInfo)
    }

    fun updateDesiredDateFirstCandidate(desiredDateFirstCandidate: String) {
        val editPersonInfo = personData.first()
        editPersonInfo.desiredDateFirstCandidate = desiredDateFirstCandidate
        experiencePersonInfoDao.updateExperiencePersonInfo(editPersonInfo)
    }

    fun updateDesiredDateSecondCandidate(desiredDateSecondCandidate: String) {
        val editPersonInfo = personData.first()
        editPersonInfo.desiredDateSecondCandidate = desiredDateSecondCandidate
        experiencePersonInfoDao.updateExperiencePersonInfo(editPersonInfo)
    }

    fun updateDesiredDateThirdCandidate(desiredDateThirdCandidate: String) {
        val editPersonInfo = personData.first()
        editPersonInfo.desiredDateThirdCandidate = desiredDateThirdCandidate
        experiencePersonInfoDao.updateExperiencePersonInfo(editPersonInfo)
    }

    fun updateRemarks (remarks: String) {
        val editPersonInfo = personData.first()
        editPersonInfo.remarks = remarks
        experiencePersonInfoDao.updateExperiencePersonInfo(editPersonInfo)
    }

    fun deleteLastRecord(){
        val deletePersonInfo = personData.last()
        experiencePersonInfoDao.deleteExperiencePersonInfo(deletePersonInfo)
    }

    fun deleteFirstRecord(){
        val deletePersonInfo = personData.first()
        experiencePersonInfoDao.deleteExperiencePersonInfo(deletePersonInfo)
    }

}