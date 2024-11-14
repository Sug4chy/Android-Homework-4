package ru.sug4chy.timetable.domain.model

data class TimetableDay(
    val dayOfWeek: String,
    val lessons: List<TimetableItem>
)