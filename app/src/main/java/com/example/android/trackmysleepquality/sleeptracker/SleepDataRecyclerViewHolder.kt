package com.example.android.trackmysleepquality.sleeptracker

import android.graphics.Color
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.android.trackmysleepquality.R
import com.example.android.trackmysleepquality.convertDurationToFormatted
import com.example.android.trackmysleepquality.convertNumericQualityToString
import com.example.android.trackmysleepquality.database.SleepNight

class SleepDataRecyclerViewHolder private constructor(itemView: View): RecyclerView.ViewHolder(itemView) {

    val sleepLength: TextView = itemView.findViewById(R.id.sleep_length)
    val sleepQuality: TextView = itemView.findViewById(R.id.sleep_quality)
    val qualityImage: ImageView = itemView.findViewById(R.id.quality_image)

    fun bindSleepViewHolderData(item: SleepNight) {
        val res = itemView.context.resources

        if (item.sleepQuality <= 1) {
            sleepQuality.setTextColor(Color.RED)
        } else {
            //reset the colour when the view is reused
            sleepQuality.setTextColor(Color.BLACK)
        }
        sleepQuality.text = convertNumericQualityToString(item.sleepQuality, res)
        sleepLength.text = convertDurationToFormatted(item.startTimeMillis, item.endTimeMillis, res)

        qualityImage.setImageResource(when (item.sleepQuality) {
            0 -> R.drawable.ic_sleep_0
            1 -> R.drawable.ic_sleep_1
            2 -> R.drawable.ic_sleep_2
            3 -> R.drawable.ic_sleep_3
            4 -> R.drawable.ic_sleep_4
            5 -> R.drawable.ic_sleep_5
            else -> R.drawable.ic_sleep_active
        })
    }

    companion object {
        fun sleepDataRecyclerViewHolderInflating(parent: ViewGroup): SleepDataRecyclerViewHolder {
            val layoutInflater = LayoutInflater.from(parent.context)
            val view = layoutInflater.inflate(R.layout.recycler_view_cell, parent, false)
            return SleepDataRecyclerViewHolder(view)
        }
    }
}