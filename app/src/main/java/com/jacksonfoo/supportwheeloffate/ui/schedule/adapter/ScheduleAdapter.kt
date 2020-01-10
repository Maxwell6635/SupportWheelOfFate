package com.jacksonfoo.supportwheeloffate.ui.schedule.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.jacksonfoo.supportwheeloffate.R
import com.jacksonfoo.supportwheeloffate.data.model.TimeTable
import com.jacksonfoo.supportwheeloffate.databinding.ItemTimetableBinding
import com.jacksonfoo.supportwheeloffate.ui.base.BindingViewHolder
import com.jacksonfoo.supportwheeloffate.ui.schedule.ScheduleViewModel

class ScheduleAdapter(
    var items: List<TimeTable> = arrayListOf(),
    val vm: ScheduleViewModel
) :
    RecyclerView.Adapter<ScheduleAdapter.EngineerViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): EngineerViewHolder {
        return EngineerViewHolder(
            LayoutInflater.from(parent.context).inflate(
                R.layout.item_timetable,
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: EngineerViewHolder, position: Int) {
        holder.binding.item = items[position]
        holder.binding.vm = vm
    }

    override fun getItemCount() = items.size


    class EngineerViewHolder(view: View) :
        BindingViewHolder<ItemTimetableBinding>(view)

}