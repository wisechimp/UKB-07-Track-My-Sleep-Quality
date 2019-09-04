package com.example.android.trackmysleepquality.sleeptracker

import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import com.example.android.trackmysleepquality.database.SleepNight
import com.example.android.trackmysleepquality.sleeptracker.SleepDataRecyclerViewHolder.Companion

//private const val ITEM_VIEW_TYPE_HEADER = 0
//private const val ITEM_VIEW_TYPE_ITEM = 1

class SleepDataRecyclerViewAdapter(val clickListener:SleepNightListener) : ListAdapter<SleepNight, SleepDataRecyclerViewHolder>(SleepNightDiffCallback()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SleepDataRecyclerViewHolder {
        return Companion.sleepDataRecyclerViewHolderInflating(parent)
    }

    override fun onBindViewHolder(holder: SleepDataRecyclerViewHolder, position: Int) {
        val item = getItem(position)
        holder.bindSleepViewHolderData(item, clickListener)
    }
}

class SleepNightListener(val clickListener: (sleepId: Long) -> Unit){
    fun onClick(night: SleepNight) = clickListener(night.nightId)
}