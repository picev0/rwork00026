package com.example.rworksample00026.ui.util

import android.app.DatePickerDialog
import android.app.Dialog
import android.content.Context
import android.os.Bundle
import android.widget.DatePicker
import androidx.fragment.app.DialogFragment
import com.example.rworksample00026.R
import com.example.rworksample00026.ui.experience.ExperienceFormFirstActivity
import java.util.*

class DatePickExperience: DialogFragment(), DatePickerDialog.OnDateSetListener{

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {

        val c = Calendar.getInstance()
        val year = c.get(Calendar.YEAR)
        val month = c.get(Calendar.MONTH)
        val day = c.get(Calendar.DAY_OF_MONTH)

        return DatePickerDialog(
            this.context as Context,
            R.style.DatePickerDialog_Spinner,
            activity as ExperienceFormFirstActivity,
            year,
            month,
            day
        )
    }

    override fun onDateSet(p0: DatePicker?, year: Int, month: Int, day: Int) {

    }
}