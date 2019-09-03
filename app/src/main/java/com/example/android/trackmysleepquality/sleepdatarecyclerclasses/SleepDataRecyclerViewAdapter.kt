package com.example.android.trackmysleepquality.sleepdatarecyclerclasses

import android.graphics.Color
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.TextView
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
        if (item.sleepQuality <= 1){
            holder.textView.setTextColor(Color.RED)
        } else {
            //reset the colour when the view is reused
            holder.textView.setTextColor(Color.BLACK)
        }
        holder.textView.text = item.sleepQuality.toString()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SleepDataRecyclerViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val view = layoutInflater.inflate(R.layout.recycler_view_cell, parent, false) as TextView
        return SleepDataRecyclerViewHolder(view)
    }
}