package com.example.android.trackmysleepquality.sleeptracker

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.android.trackmysleepquality.database.SleepNight
import com.example.android.trackmysleepquality.databinding.RecyclerViewCellBinding

class SleepDataRecyclerViewHolder private constructor(val binding: RecyclerViewCellBinding): RecyclerView.ViewHolder(binding.root) {

    fun bindSleepViewHolderData(item: SleepNight) {
        val res = itemView.context.resources

        binding.sleep = item
        binding.executePendingBindings()
    }

    companion object {
        fun sleepDataRecyclerViewHolderInflating(parent: ViewGroup): SleepDataRecyclerViewHolder {
            val layoutInflater = LayoutInflater.from(parent.context)
            val binding = RecyclerViewCellBinding.inflate(layoutInflater, parent, false)
            return SleepDataRecyclerViewHolder(binding)
        }
    }
}