package com.example.android.trackmysleepquality.sleepdatarecyclerclasses

import android.graphics.Color
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.android.trackmysleepquality.R
import com.example.android.trackmysleepquality.convertDurationToFormatted
import com.example.android.trackmysleepquality.convertNumericQualityToString
import com.example.android.trackmysleepquality.database.SleepNight

class SleepDataRecyclerViewAdapter : RecyclerView.Adapter<SleepDataRecyclerViewHolder>() {

    var data = listOf<SleepNight>()

    set(value) {
        field = value
        notifyDataSetChanged()
    }

    override fun getItemCount() = data.size

    override fun onBindViewHolder(holder: SleepDataRecyclerViewHolder, position: Int) {
        val item = data[position]
        val res = holder.itemView.context.resources
        if (item.sleepQuality <= 1){
            holder.sleepQuality.setTextColor(Color.RED)
        } else {
            //reset the colour when the view is reused
            holder.sleepQuality.setTextColor(Color.BLACK)
        }
        holder.sleepQuality.text = convertNumericQualityToString(item.sleepQuality, res)
        holder.sleepLength.text = convertDurationToFormatted(item.startTimeMillis, item.endTimeMillis, res)

        holder.qualityImage.setImageResource(when (item.sleepQuality) {
            0 -> R.drawable.ic_sleep_0
            1 -> R.drawable.ic_sleep_1
            2 -> R.drawable.ic_sleep_2
            3 -> R.drawable.ic_sleep_3
            4 -> R.drawable.ic_sleep_4
            5 -> R.drawable.ic_sleep_5
            else -> R.drawable.ic_sleep_active
        })
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SleepDataRecyclerViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val view = layoutInflater.inflate(R.layout.recycler_view_cell, parent, false)
        return SleepDataRecyclerViewHolder(view)
    }
}