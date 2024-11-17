package ru.sug4chy.timetable.ui.adapter.model

import ru.sug4chy.timetable.model.TimetableItem

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

        fun ofString(string: String): TimetableItemOrStringWrapper =
            TimetableItemOrStringWrapper(
                string = string,
                type = Type.STRING
            )

        fun ofTimetableItem(item: TimetableItem): TimetableItemOrStringWrapper =
            TimetableItemOrStringWrapper(
                timetableItem = item,
                type = Type.TIMETABLE_ITEM
            )
    }
}