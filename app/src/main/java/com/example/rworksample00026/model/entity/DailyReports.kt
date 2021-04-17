package com.example.rworksample00026.model.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "daily_reports")
class DailyReports (
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id")
    val id : Int,
    @ColumnInfo(name = "title")
    var title: String,
    @ColumnInfo(name = "name")
    var name:String,
    @ColumnInfo(name = "date")
    var date: String,
    @ColumnInfo(name = "weeklyGoal")
    var weeklyGoal: String,
    @ColumnInfo(name = "commutingTimeBefore")
    var commutingTimeBefore: String,
    @ColumnInfo(name = "commutingTimeAfter")
    var commutingTimeAfter: String,
    @ColumnInfo(name = "participationProgram")
    var participationProgram: String,
    @ColumnInfo(name = "detailsOfEfforts")
    var detailsOfEfforts: String,
    @ColumnInfo(name = "impressions")
    var impressions: String,
    @ColumnInfo(name = "meal")
    var meal: String,
    @ColumnInfo(name = "sleep")
    var sleep: String,
    @ColumnInfo(name = "motion")
    var motion: String,
    @ColumnInfo(name = "tirednessAndStress")
    var tirednessAndStress: String,
    @ColumnInfo(name = "remarks")
    var remarks: String,
    @ColumnInfo(name = "lookingBack")
    var lookingBack: String,
    @ColumnInfo(name = "nextWeeksChallengeAndGoals")
    var nextWeeksChallengeAndGoals: String,
    @ColumnInfo(name = "submitFlag")
    var submitFlag: Boolean
        )