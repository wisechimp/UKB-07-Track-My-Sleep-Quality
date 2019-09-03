package com.example.android.trackmysleepquality.sleepdatarecyclerclasses

import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.android.trackmysleepquality.database.SleepNight
import com.example.android.trackmysleepquality.sleepdatarecyclerclasses.SleepDataRecyclerViewHolder.Companion

class SleepDataRecyclerViewAdapter : RecyclerView.Adapter<SleepDataRecyclerViewHolder>() {

    var data = listOf<SleepNight>()

    set(value) {
        field = value
        notifyDataSetChanged()
    }

    override fun getItemCount() = data.size

    override fun onBindViewHolder(holder: SleepDataRecyclerViewHolder, position: Int) {
        val item = data[position]
        holder.bindSleepViewHolderData(item)
    }

   override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SleepDataRecyclerViewHolder {
       return Companion.sleepDataRecyclerViewHolderInflating(parent)
   }
}