package com.example.rworksample00026.ui.util

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.rworksample00026.R
import com.example.rworksample00026.databinding.ListBinding
import com.example.rworksample00026.model.entity.DailyReports

class CustomAdapter (private val dailyReportsList: List<DailyReports>): RecyclerView.Adapter<CustomAdapter.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.list, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: CustomAdapter.ViewHolder, position: Int) {
        with(holder){
            val reports = dailyReportsList[position]
            //https://stackoverflow.com/questions/60491966/how-to-do-latest-jetpack-view-binding-in-adapter-bind-the-views/60492228
            // AdapterでのViewBindingの使い方
            binding.name.text = reports.title
            binding.body.text = reports.impressions
        }
    }

    override fun getItemCount(): Int = dailyReportsList.size

    class ViewHolder(view: View): RecyclerView.ViewHolder(view){
        val binding = ListBinding.bind(view)
        val name: TextView
        val body: TextView

        init {
            name = binding.name
            body = binding.body
        }
    }
}