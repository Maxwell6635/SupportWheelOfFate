package com.jacksonfoo.supportwheeloffate.ui.main.adapter

import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import com.jacksonfoo.supportwheeloffate.data.model.Engineer
import com.jacksonfoo.supportwheeloffate.ui.main.MainViewModel

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