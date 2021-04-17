package com.example.rworksample00026.model.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "request_documents_person_info")
class RequestDocumentsPersonInfo (
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id")
    val id: Int,
    @ColumnInfo(name = "name")
    var name : String,
    @ColumnInfo(name="phoneticGuides")
    var phoneticGuides: String,
    @ColumnInfo(name="birthday")
    var birthday: String,
    @ColumnInfo(name="zipStr")
    var zipStr: String,
    @ColumnInfo(name="prefecture")
    var prefecture: String,
    @ColumnInfo(name="city")
    var city: String,
    @ColumnInfo(name="address")
    var address :String,
    @ColumnInfo(name="phoneNumber")
    var phoneNumber: String,
    @ColumnInfo(name="mailAddress")
    var mailAddress: String,
    @ColumnInfo(name="disableCertificate")
    var disableCertifidate: String,
    @ColumnInfo(name="sendingMaterials")
    var sendingMaterials : String,
    @ColumnInfo(name="remarks")
    var remarks: String
        )
