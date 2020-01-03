package com.jacksonfoo.supportwheeloffate.ui.main.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.jacksonfoo.supportwheeloffate.R
import com.jacksonfoo.supportwheeloffate.data.model.Engineer
import com.jacksonfoo.supportwheeloffate.databinding.ItemEngineerBinding
import com.jacksonfoo.supportwheeloffate.ui.base.BindingViewHolder
import com.jacksonfoo.supportwheeloffate.ui.main.MainViewModel

class EngineerAdapter(
    var items: List<Engineer> = arrayListOf(),
    val vm: MainViewModel
) :
    RecyclerView.Adapter<EngineerAdapter.EngineerViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): EngineerViewHolder {
        return EngineerViewHolder(
            LayoutInflater.from(parent.context).inflate(
                R.layout.item_engineer,
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
        BindingViewHolder<ItemEngineerBinding>(view)

}