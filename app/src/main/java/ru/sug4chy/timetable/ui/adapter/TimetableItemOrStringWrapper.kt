package ru.sug4chy.timetable.ui.adapter

import ru.sug4chy.timetable.domain.model.TimetableItem

data class TimetableItemOrStringWrapper(
    val string: String? = null,
    val timetableItem: TimetableItem? = null,
    val type: Type
) {
    enum class Type {
        STRING,
        TIMETABLE_ITEM
    }

    companion object {

        @JvmStatic
        fun ofString(string: String): TimetableItemOrStringWrapper =
            TimetableItemOrStringWrapper(
                string = string,
                type = Type.STRING
            )

        @JvmStatic
        fun ofTimetableItem(day: TimetableItem): TimetableItemOrStringWrapper =
            TimetableItemOrStringWrapper(
                timetableItem = day,
                type = Type.TIMETABLE_ITEM
            )
    }
}