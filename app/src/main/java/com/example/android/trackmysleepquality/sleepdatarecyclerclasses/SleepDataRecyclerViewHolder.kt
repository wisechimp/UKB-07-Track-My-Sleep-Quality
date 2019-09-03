package com.example.android.trackmysleepquality.sleepdatarecyclerclasses

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.android.trackmysleepquality.R

class SleepDataRecyclerViewHolder (itemView: View): RecyclerView.ViewHolder(itemView) {

    val sleepLength: TextView = itemView.findViewById(R.id.sleep_length)
    val sleepQuality: TextView = itemView.findViewById(R.id.sleep_quality)
    val qualityImage: ImageView = itemView.findViewById(R.id.quality_image)
}