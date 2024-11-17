package ru.sug4chy.timetable.model

data class TimetableDay(
    val dayOfWeek: String,
    val lessons: List<TimetableItem>
)