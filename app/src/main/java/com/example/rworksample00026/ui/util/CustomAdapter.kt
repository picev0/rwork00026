package com.example.rworksample00026.ui.util

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.rworksample00026.R
import com.example.rworksample00026.databinding.ListBinding
import com.example.rworksample00026.model.entity.DailyReports
import org.w3c.dom.Text


class CustomAdapter (private val dailyReportsList: List<DailyReports>): RecyclerView.Adapter<CustomAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        // create a new view
        val view = LayoutInflater.from(parent.context).inflate(R.layout.list, parent, false)
        //view.setOnClickListener(ItemClickListener())
        return ViewHolder(view)
    }

    var point : Int = 0

    // リスナー格納変数
    lateinit var listener: OnItemClickListener

    // インターフェースの作成
    interface OnItemClickListener{
        fun onItemClickListener(view: View, position: Int, reports: DailyReports)
    }

    // リスナー
    fun setOnItemClickListener( listener: OnItemClickListener){
        this.listener = listener
    }
    /*
    inner class ItemClickListener: View.OnClickListener{
        override fun onClick(v: View) {
            var context = v.context
            val intent = Intent(context, SentDailyReportsDetailActivity::class.java)
            intent.putExtra("point", point)
            Log.d("[point]", point.toString())
            context.startActivity(intent)
        }
    }
    */

    override fun onBindViewHolder(holder: CustomAdapter.ViewHolder, position: Int) {
        /*
        *   https://qiita.com/ngsw_taro/items/d29e3080d9fc8a38691e
        *   withはletとは異なり拡張関数ではありません。
        *   第一引数に任意の型Tを取ります。
        *    第二引数に関数を取りますが、Tをレシーバとするメソッドである必要があります。
        *
         */
        // タップしたとき
        holder.itemView.setOnClickListener {
            listener.onItemClickListener(it, position, dailyReportsList[position])
        }

        with(holder){
            /*
            *
            *    positionは項目の位置
            *   https://hirauchi-genta.com/kotlin-listview/
             */

            //日報データベースから1レコード取り出す
            val reports = dailyReportsList[position]
            //https://stackoverflow.com/questions/60491966/how-to-do-latest-jetpack-view-binding-in-adapter-bind-the-views/60492228
            // AdapterでのViewBindingの使い方
            binding.title.text = reports.title
            binding.date.text = reports.date
            binding.commutingTimeBefore.text = reports.commutingTimeBefore
            binding.commutingTimeAfter.text = reports.commutingTimeAfter
            binding.participationProgram.text = reports.participationProgram
            binding.detailsOfEfforts.text = reports.detailsOfEfforts
            binding.impressions.text = reports.impressions
            binding.meal.text = reports.meal
            binding.sleep.text = reports.sleep
            binding.motion.text = reports.motion
            binding.tirednessAndStress.text = reports.tirednessAndStress
            binding.lookingBack.text = reports.lookingBack
            binding.nextWeekChallengeAndGoals.text = reports.nextWeeksChallengeAndGoals

        }
        //this.point = position

    }

    override fun getItemCount(): Int = dailyReportsList.size

    class ViewHolder(view: View): RecyclerView.ViewHolder(view){
        val binding = ListBinding.bind(view)
        val title: TextView
        val date: TextView
        val commutingTimeBefore: TextView
        val commutingTimeAfter: TextView
        val participationProgram : TextView
        val detailsOfEfforts: TextView
        val impressions: TextView
        val meal: TextView
        val sleep : TextView
        val motion: TextView
        val tirednessAndStress: TextView
        val remarks: TextView
        val lookingBack : TextView
        val nextWeekChallengeAndGoals: TextView



        init {
            title = binding.title
            date = binding.date
            commutingTimeBefore = binding.commutingTimeBefore
            commutingTimeAfter = binding.commutingTimeAfter
            participationProgram = binding.participationProgram
            detailsOfEfforts = binding.detailsOfEfforts
            impressions = binding.impressions
            meal = binding.meal
            sleep = binding.sleep
            motion = binding.motion
            tirednessAndStress = binding.tirednessAndStress
            remarks = binding.remarks
            lookingBack = binding.lookingBack
            nextWeekChallengeAndGoals = binding.nextWeekChallengeAndGoals
        }
    }
}