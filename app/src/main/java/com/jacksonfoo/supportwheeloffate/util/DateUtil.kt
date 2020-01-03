package com.jacksonfoo.supportwheeloffate.util

import org.threeten.bp.DayOfWeek
import org.threeten.bp.LocalDate
import org.threeten.bp.temporal.TemporalAdjusters
import java.util.*


object DateUtil {
    val nextMonday: LocalDate
        get() = LocalDate.now()
            .with(TemporalAdjusters.next(DayOfWeek.MONDAY))

    fun isWeekend(localDate: LocalDate): Boolean {
        val weekend: Set<DayOfWeek> =
            EnumSet.of(
                DayOfWeek.SATURDAY,
                DayOfWeek.SUNDAY
            )
        return weekend.contains(localDate.dayOfWeek)
    }
}
