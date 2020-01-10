package com.jacksonfoo.supportwheeloffate.ui.main

import android.content.Context
import android.content.Intent
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.google.gson.Gson
import com.jacksonfoo.supportwheeloffate.data.api.API
import com.jacksonfoo.supportwheeloffate.data.model.Engineer
import com.jacksonfoo.supportwheeloffate.ui.base.BaseViewModel
import com.jacksonfoo.supportwheeloffate.ui.schedule.ScheduleActivity
import com.jacksonfoo.supportwheeloffate.util.with

class MainViewModel(val context: Context, private val api: API, val gson: Gson) : BaseViewModel() {

    private val engineerListMutableLiveData =
        MutableLiveData<ArrayList<Engineer>>(arrayListOf())

    val engineerList: LiveData<ArrayList<Engineer>>
        get() = engineerListMutableLiveData

    fun getEngineerList() {
        addToDisposable(
            api.getEngineerList().with()
                .doOnSubscribe { _refreshing.value = true }
                .doOnSuccess { _refreshing.value = false }
                .doOnError { _refreshing.value = false }
                .subscribe({
                    engineerListMutableLiveData.value = it.engineerList
                }, {
                    // handle errors
                })
        )
    }

    fun navigateToScheduleListScreen() {
        val intent = Intent(context, ScheduleActivity::class.java)
        intent.putExtra("objects", gson.toJson(engineerList.value))
        context.startActivity(intent)
    }
}