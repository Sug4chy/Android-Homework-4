package ru.sug4chy.timetable.utils

import ru.sug4chy.timetable.extensions.capitalizeFirstChar
import java.time.DayOfWeek
import java.time.LocalDate
import java.time.format.TextStyle
import java.util.Calendar
import java.util.Locale

object DateTimeUtils {

    val currentDayOfWeek: DayOfWeek
        get() = LocalDate.now().dayOfWeek

    val currentDayOfWeekFormatted: String
        get() = formatDayOfWeek(currentDayOfWeek)

    fun formatDayOfWeek(dayOfWeek: DayOfWeek): String =
        dayOfWeek.getDisplayName(TextStyle.FULL, Locale.forLanguageTag("ru-RU"))
            .capitalizeFirstChar()

    fun isCurrentWeekOdd(): Boolean =
        Calendar.getInstance().get(Calendar.WEEK_OF_YEAR) % 2 == 0
}