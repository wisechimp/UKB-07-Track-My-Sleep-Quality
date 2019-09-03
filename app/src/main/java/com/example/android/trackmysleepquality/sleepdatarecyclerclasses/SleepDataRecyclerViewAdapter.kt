package com.example.android.trackmysleepquality.sleepdatarecyclerclasses

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.android.trackmysleepquality.R
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
        holder.bindSleepViewHolderData(item)
    }

   override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SleepDataRecyclerViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val view = layoutInflater.inflate(R.layout.recycler_view_cell, parent, false)
        return SleepDataRecyclerViewHolder(view)
    }
}