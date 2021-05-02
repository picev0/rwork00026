package com.example.rworksample00026.ui.dailyreports

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.rworksample00026.databinding.ActivitySentDailyReportsListBinding
import com.example.rworksample00026.ui.util.CustomAdapter

class SentDailyReportsListActivity : AppCompatActivity() {

    private lateinit var binding : ActivitySentDailyReportsListBinding
    private val viewModel: DailyReportsViewModel by viewModels()
    lateinit var mAdapter: CustomAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySentDailyReportsListBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // RecyclerViewの取得
        //https://hirauchi-genta.com/kotlin-recyclerview/
        val recyclerView = binding.recyclerView

        val dividerItemDecoration = DividerItemDecoration(this, LinearLayoutManager(this).orientation)
        recyclerView.addItemDecoration(dividerItemDecoration)

        // LayoutManagerの設定
        recyclerView.layoutManager = LinearLayoutManager(this)

        // CustomAdapterの生成と設定
        mAdapter = CustomAdapter(viewModel.reportsData)
        recyclerView.adapter = mAdapter
    }
}