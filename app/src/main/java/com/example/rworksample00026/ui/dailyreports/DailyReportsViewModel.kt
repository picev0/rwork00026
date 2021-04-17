package com.example.rworksample00026.ui.dailyreports

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import com.example.rworksample00026.RworkDatabase
import com.example.rworksample00026.model.dao.DailyReportsDao
import com.example.rworksample00026.model.entity.DailyReports
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class DailyReportsViewModel(application: Application) :AndroidViewModel(application){
    private val reportsDao: DailyReportsDao

    init {
        val db = RworkDatabase.buildDatabase(application)
        reportsDao = db.reportsDao()
    }

    val reportsData = reportsDao.loadAllReports()
    val reportsDataAll = reportsDao.loadAllReportsLiveData()

    //val lastData = reportsData.last()

    fun insertReportParam(title: String, weeklyGoal: String, participationProgram: String, detailsOfEfforts: String){
        viewModelScope.launch (Dispatchers.IO){
            reportsDao.saveReports(
                DailyReports(
                    id = 0,
                    title = title,
                    name ="",
                    date = "",
                    weeklyGoal = weeklyGoal,
                    commutingTimeBefore = "",
                    commutingTimeAfter = "",
                    participationProgram = participationProgram,
                    detailsOfEfforts = detailsOfEfforts,
                    impressions = "",
                    meal = "",
                    sleep = "",
                    motion = "",
                    tirednessAndStress = "",
                    remarks = "",
                    lookingBack = "",
                    nextWeeksChallengeAndGoals = "",
                    submitFlag = false
                )
            )
        }
    }

    fun insertReport(date: String){
        viewModelScope.launch (Dispatchers.IO){
            reportsDao.saveReports(
                DailyReports(
                    id = 0,
                    title = "",
                    name ="",
                    date = date,
                    weeklyGoal = "",
                    commutingTimeBefore = "",
                    commutingTimeAfter = "",
                    participationProgram = "",
                    detailsOfEfforts = "",
                    impressions = "",
                    meal = "",
                    sleep = "",
                    motion = "",
                    tirednessAndStress = "",
                    remarks = "",
                    lookingBack = "",
                    nextWeeksChallengeAndGoals = "",
                    submitFlag = false
                )
            )
        }
    }

    fun updateTitle(title:String){
        viewModelScope.launch (Dispatchers.IO){
            val reportData = reportsData.last()
            reportData.title = title
            reportsDao.update(reportData)
        }
    }

    fun updateName(name: String) {
        viewModelScope.launch (Dispatchers.IO){
            val reportData = reportsData.last()
            reportData.name = name
            reportsDao.update(reportData)
        }
    }

    fun updateDate(date: String){
        viewModelScope.launch (Dispatchers.IO){
            val reportData = reportsData.last()
            reportData.date = date
            reportsDao.update(reportData)
        }
    }

    fun updateWeeklyGoal(weeklyGoal: String) {
        viewModelScope.launch(Dispatchers.IO) {
            val reportData = reportsData.last()
            reportData.weeklyGoal = weeklyGoal
            reportsDao.update(reportData)
        }
    }

    fun updateCommutingTimeBefore(commutingTimeBefore: String){
        viewModelScope.launch (Dispatchers.IO){
            val reportData = reportsData.last()
            reportData.commutingTimeBefore = commutingTimeBefore
            reportsDao.update(reportData)
        }
    }

    fun updateCommutingTimeAfter(commutingTimeAfter: String) {
        viewModelScope.launch (Dispatchers.IO){
            val reportData = reportsData.last()
            reportData.commutingTimeAfter = commutingTimeAfter
            reportsDao.update(reportData)
        }
    }

    fun updateParticipationProgram(participationProgram: String) {
        viewModelScope.launch (Dispatchers.IO){
            val reportData = reportsData.last()
            reportData.participationProgram = participationProgram
            reportsDao.update(reportData)
        }
    }

    fun updateDetailsOfEffects(detailsOfEfforts: String) {
        viewModelScope.launch (Dispatchers.IO){
            val reportData = reportsData.last()
            reportData.detailsOfEfforts = detailsOfEfforts
            reportsDao.update(reportData)
        }
    }

    fun updateImpressions(impressions: String) {
        viewModelScope.launch (Dispatchers.IO){
            val reportData = reportsData.last()
            reportData.impressions = impressions
            reportsDao.update(reportData)
        }
    }

    fun updateMeal(meal: String) {
        viewModelScope.launch (Dispatchers.IO){
            val reportData = reportsData.last()
            reportData.meal = meal
            reportsDao.update(reportData)
        }
    }

    fun updateSleep(sleep: String) {
        viewModelScope.launch (Dispatchers.IO){
            val reportData = reportsData.last()
            reportData.sleep = sleep
            reportsDao.update(reportData)
        }
    }

    fun updateMotion(motion: String) {
        viewModelScope.launch (Dispatchers.IO){
            val reportData = reportsData.last()
            reportData.motion = motion
            reportsDao.update(reportData)
        }
    }

    fun updateTirednessAndStress(tirednessAndStress: String) {
        viewModelScope.launch (Dispatchers.IO) {
            val reportData = reportsData.last()
            reportData.tirednessAndStress = tirednessAndStress
            reportsDao.update(reportData)
        }
    }

    fun updateRemarks(remarks: String){
        viewModelScope.launch (Dispatchers.IO){
            val reportData = reportsData.last()
            reportData.remarks = remarks
            reportsDao.update(reportData)
        }
    }

    fun updateLookingBack(lookingBack: String) {
        viewModelScope.launch (Dispatchers.IO){
            val reportData = reportsData.last()
            reportData.lookingBack = lookingBack
            reportsDao.update(reportData)
        }
    }

    fun updateNextWeekChallengeAndGoals(nextWeekChallengeAndGoals: String) {
        viewModelScope.launch (Dispatchers.IO){
            val reportData = reportsData.last()
            reportData.nextWeeksChallengeAndGoals = nextWeekChallengeAndGoals
            reportsDao.update(reportData)
        }
    }

    fun updateSubmitFlag(submitFlag: Boolean){
        viewModelScope.launch (Dispatchers.IO){
            val reportData = reportsData.last()
            reportData.submitFlag = submitFlag
            reportsDao.update(reportData)
        }
    }
}