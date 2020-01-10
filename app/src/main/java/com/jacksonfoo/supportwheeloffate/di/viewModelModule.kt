package com.jacksonfoo.supportwheeloffate.di

import com.jacksonfoo.supportwheeloffate.ui.main.MainViewModel
import com.jacksonfoo.supportwheeloffate.ui.schedule.ScheduleViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val viewModelModule = module {
    viewModel { MainViewModel(get(), get(), get()) }
    viewModel { ScheduleViewModel(get()) }
}