package ru.sug4chy.timetable.model

data class TimetableItem(
    val lessonName: String,
    val startTime: String,
    val endTime: String,
    val classroomName: String,
    val teacherFullName: String,
) {
    lateinit var dayOfWeek: String
}