package com.jacksonfoo.supportwheeloffate.ui.base

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.disposables.Disposable

open class BaseViewModel : ViewModel() {
    private val disposables: CompositeDisposable = CompositeDisposable()
    val _refreshing: MutableLiveData<Boolean> = MutableLiveData(false)

    val refreshing: LiveData<Boolean>
        get() = _refreshing

    fun addToDisposable(disposable: Disposable) {
        disposables.add(disposable)
    }

    override fun onCleared() {
        disposables.clear()
        super.onCleared()
    }
}