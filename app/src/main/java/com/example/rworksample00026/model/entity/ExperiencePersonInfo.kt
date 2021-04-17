package com.example.rworksample00026.model.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "experience_person_info")
class ExperiencePersonInfo (

    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id")
    val id: Int,
    @ColumnInfo(name = "applicationForm")
    val applicationForm: String,
    @ColumnInfo(name = "name")
    var name : String,
    @ColumnInfo(name = "phoneticGuides")
    var phoneticGuides: String,
    @ColumnInfo(name = "birthday")
    var birthday: String,
    @ColumnInfo(name = "zipStr")
    var zipStr: String,
    @ColumnInfo(name = "prefecture")
    var prefecture: String,
    @ColumnInfo(name = "city")
    var city: String,
    @ColumnInfo(name = "address")
    var address :String,
    @ColumnInfo(name = "phoneNumber")
    var phoneNumber: String,
    @ColumnInfo(name="mailAddress")
    var mailAddress: String,
    @ColumnInfo(name="disableCertifidate")
    var disableCertifidate: String,
    @ColumnInfo(name="desiredDateFirstCandidate")
    var desiredDateFirstCandidate: String,
    @ColumnInfo(name="desiredDateSecondCandidate")
    var desiredDateSecondCandidate: String,
    @ColumnInfo(name="desiredDateThirdCandidate")
    var desiredDateThirdCandidate: String,
    @ColumnInfo(name="remarks")
    var remarks: String
)