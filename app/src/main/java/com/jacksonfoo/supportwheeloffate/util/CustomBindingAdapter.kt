package com.jacksonfoo.supportwheeloffate.util

import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import com.jacksonfoo.supportwheeloffate.data.model.Engineer
import com.jacksonfoo.supportwheeloffate.data.model.TimeTable
import com.jacksonfoo.supportwheeloffate.ui.main.MainViewModel
import com.jacksonfoo.supportwheeloffate.ui.main.adapter.EngineerAdapter
import com.jacksonfoo.supportwheeloffate.ui.schedule.ScheduleViewModel
import com.jacksonfoo.supportwheeloffate.ui.schedule.adapter.ScheduleAdapter


@BindingAdapter(value = ["repositories", "viewModel"])
fun setEngineerList(
    view: RecyclerView,
    items: ArrayList<Engineer>,
    vm: MainViewModel
) {
    view.adapter?.run {
        if (this is EngineerAdapter) {
            this.items = items
            this.notifyDataSetChanged()
        }
    } ?: run {
        EngineerAdapter(items, vm).apply { view.adapter = this }
    }
}

@BindingAdapter(value = ["repositories", "viewModel"])
fun setTimeTableList(
    view: RecyclerView,
    items: ArrayList<TimeTable>,
    vm: ScheduleViewModel
) {
    view.adapter?.run {
        if (this is ScheduleAdapter) {
            this.items = items
            this.notifyDataSetChanged()
        }
    } ?: run {
        ScheduleAdapter(items, vm).apply { view.adapter = this }
    }
}