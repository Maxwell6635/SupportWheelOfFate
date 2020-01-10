package com.jacksonfoo.supportwheeloffate.ui.schedule

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import com.jacksonfoo.supportwheeloffate.data.model.Engineer
import com.jacksonfoo.supportwheeloffate.data.model.TimeTable
import com.jacksonfoo.supportwheeloffate.ui.base.BaseViewModel
import com.jacksonfoo.supportwheeloffate.util.DateUtil
import org.threeten.bp.LocalDate

class ScheduleViewModel(val gson: Gson) : BaseViewModel() {

    private val timeTableListMutableLiveData =
        MutableLiveData<ArrayList<TimeTable>>(arrayListOf())

    val timeTableList: LiveData<ArrayList<TimeTable>>
        get() = timeTableListMutableLiveData

    fun retrieveTimeTable(engineerJson: String) {
        val engineers: ArrayList<Engineer> =
            gson.fromJson(engineerJson, object : TypeToken<ArrayList<Engineer>>() {}.type)
        val timeTable: ArrayList<TimeTable> = generateTimeTable()
        for (schedule in timeTable) {
            assignEngineers(engineers, timeTable, schedule)
        }
        timeTableListMutableLiveData.value = timeTable
    }

    private fun generateTimeTable(): ArrayList<TimeTable> {
        val schedule: ArrayList<TimeTable> = ArrayList()
        val nextMonday: LocalDate = DateUtil.nextMonday
        var id = 0
        for (i in 0 until 14) {
            val shiftDate = nextMonday.plusDays(i.toLong())
            if (DateUtil.isWeekend(shiftDate)) {
                continue
            }
            id++
            schedule.add(TimeTable(id, arrayListOf(), shiftDate, shiftDate.dayOfWeek.toString()))
        }
        return schedule
    }

    private fun assignEngineers(
        engineers: ArrayList<Engineer>,
        timeTable: ArrayList<TimeTable>,
        schedule: TimeTable
    ) {
        for (x in 0..engineers.size) {
            val randomNumber = (0 until engineers.size).random()
            if (!checkHalfDayRule(schedule, engineers[randomNumber])
                && checkConsecutiveDayRule(schedule, engineers[randomNumber], timeTable)
            ) {

//                if (!checkAllEngineerAlreadyHave2Slot(engineers)) {
                    if (engineers[randomNumber].shiftSlot < 2) {
                        engineers[randomNumber].shiftSlot = engineers[randomNumber].shiftSlot + 1
                        schedule.engineers.add(engineers[randomNumber])
                    } else {
                        continue
                    }
//                } else {
//                    schedule.engineers.add(engineers[randomNumber])
//                }
            }

            if (schedule.engineers.size == 2) {
                break
            } else if (checkAllEngineerAlreadyHave2Slot(engineers)) {
                assignEngineers(engineers, timeTable, schedule)
            }
        }
    }

    private fun checkAllEngineerAlreadyHave2Slot(engineers: ArrayList<Engineer>): Boolean {
        var max = false
        for (engineer in engineers) {
            if (engineer.shiftSlot == 2) {
                continue
            } else {
                max = false
                break
            }
        }
        return max
    }

    private fun checkConsecutiveDayRule(
        schedule: TimeTable, engineer: Engineer,
        timeTable: List<TimeTable>
    ): Boolean {

        if (schedule.id == 1) {
            return true
        }

        val previousDay = timeTable[timeTable.indexOf(schedule) - 1]
        val assigned = previousDay.engineers.stream().filter { it ->
            engineer.id == it.id
        }?.findAny()?.orElse(null)
        return assigned == null
    }

    private fun checkHalfDayRule(schedule: TimeTable, engineer: Engineer): Boolean {
        return schedule.engineers.contains(engineer)
    }
}