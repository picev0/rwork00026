package com.example.rworksample00026.ui.dailyreports

import android.content.ClipData
import android.content.ClipboardManager
import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.activity.viewModels
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.rworksample00026.databinding.ActivitySentDailyReportsListBinding
import com.example.rworksample00026.model.entity.DailyReports
import com.example.rworksample00026.ui.util.CustomAdapter

class SentDailyReportsListActivity : AppCompatActivity() {

    //private val clipboardManager: Any
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




    /*
        mAdapter.setOnItemClickListener(object : CustomAdapter.OnItemClickListener{
            override fun onItemClickListener(view: View, position: Int, ) {
                val intent = Intent(this@SentDailyReportsListActivity, SentDailyReportsDetailActivity::class.java)
                intent.putExtra("position", position)
                //Log.d("[position]", position.toString())
                startActivity(intent)
            }
        })
        */






    }

    //https://qiita.com/CUTBOSS/items/97669c712449510fe7f0
    // クリップボードにコピー
    fun copyToClipboard(context: Context, label: String, text: String){

        val clipboardManager = context.getSystemService(Context.CLIPBOARD_SERVICE) as ClipboardManager

        if (null == clipboardManager) {
            return
        }

        clipboardManager.setPrimaryClip(ClipData.newPlainText(label, text));
    }

}