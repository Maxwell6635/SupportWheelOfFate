package com.jacksonfoo.supportwheeloffate.data.model

import org.threeten.bp.LocalDate

data class TimeTable(
    var id: Int,
    var engineers: ArrayList<Engineer>?,
    var shiftDate: LocalDate,
    var shiftDay: String
)