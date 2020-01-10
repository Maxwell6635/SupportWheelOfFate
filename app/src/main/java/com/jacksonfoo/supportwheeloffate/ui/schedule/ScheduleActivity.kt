package com.jacksonfoo.supportwheeloffate.ui.schedule

import android.os.Bundle
import androidx.annotation.LayoutRes
import androidx.recyclerview.widget.DefaultItemAnimator
import androidx.recyclerview.widget.DividerItemDecoration
import com.jacksonfoo.supportwheeloffate.R
import com.jacksonfoo.supportwheeloffate.databinding.ActivityScheduleBinding
import com.jacksonfoo.supportwheeloffate.ui.base.BindingActivity
import org.koin.androidx.viewmodel.ext.android.getViewModel

class ScheduleActivity : BindingActivity<ActivityScheduleBinding>() {

    @LayoutRes
    override fun getLayoutResId() = R.layout.activity_schedule

    private lateinit var viewModel: ScheduleViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        mBinding.vm = getViewModel()
        viewModel = getViewModel()
        mBinding.lifecycleOwner = this

        mBinding.rvTimetable.apply {
            itemAnimator = DefaultItemAnimator()
            addItemDecoration(DividerItemDecoration(context, DividerItemDecoration.VERTICAL))
        }

        val objectJson = intent.extras?.getString("objects")
        if (objectJson.isNullOrEmpty()) {
            finish()
        }
        viewModel.retrieveTimeTable(objectJson!!)
    }
}
