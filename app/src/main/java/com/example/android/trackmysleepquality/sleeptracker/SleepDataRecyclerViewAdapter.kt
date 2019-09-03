package com.example.android.trackmysleepquality.sleeptracker

import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import com.example.android.trackmysleepquality.database.SleepNight
import com.example.android.trackmysleepquality.sleeptracker.SleepDataRecyclerViewHolder.Companion

class SleepDataRecyclerViewAdapter : ListAdapter<SleepNight, SleepDataRecyclerViewHolder>(SleepNightDiffCallback()) {

    override fun onBindViewHolder(holder: SleepDataRecyclerViewHolder, position: Int) {
        val item = getItem(position)
        holder.bindSleepViewHolderData(item)
    }

   override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SleepDataRecyclerViewHolder {
       return Companion.sleepDataRecyclerViewHolderInflating(parent)
   }
}