package com.example.rworksample00026.ui.util

import android.app.DatePickerDialog
import android.app.Dialog
import android.content.Context
import android.os.Bundle
import android.widget.DatePicker
import androidx.fragment.app.DialogFragment
import com.example.rworksample00026.R
import com.example.rworksample00026.ui.requestdocuments.RequestDocumentsFormFirstActivity
import java.util.*

class DatePickRequestDocuments: DialogFragment(), DatePickerDialog.OnDateSetListener {

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {

        val c = Calendar.getInstance()
        val year = c.get(Calendar.YEAR)
        val month = c.get(Calendar.MONTH)
        val day = c.get(Calendar.DAY_OF_MONTH)

        return DatePickerDialog(
            this.context as Context,
            R.style.DatePickerDialog_Spinner,
            activity as RequestDocumentsFormFirstActivity,
            year,
            month,
            day
        )
    }

    override fun onDateSet(view: DatePicker?, year: Int, month: Int, dayOfMonth: Int) {

    }
}