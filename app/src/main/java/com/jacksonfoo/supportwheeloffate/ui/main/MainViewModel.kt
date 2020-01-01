package com.jacksonfoo.supportwheeloffate.ui.main

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.google.gson.Gson
import com.jacksonfoo.supportwheeloffate.data.api.API
import com.jacksonfoo.supportwheeloffate.data.model.Engineer
import com.jacksonfoo.supportwheeloffate.ui.base.BaseViewModel
import com.jacksonfoo.supportwheeloffate.util.with

class MainViewModel(private val api: API, val gson: Gson) : BaseViewModel() {

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
}