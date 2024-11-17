package ru.sug4chy.timetable.utils

import ru.sug4chy.timetable.model.TimetableDay
import ru.sug4chy.timetable.model.TimetableItem
import ru.sug4chy.timetable.utils.DateTimeUtils.formatDayOfWeek
import java.time.DayOfWeek

object TimetableData {

    private val data: Map<Int, Map<DayOfWeek, TimetableDay>> =
        mapOf(
            1 to mapOf(
                DayOfWeek.MONDAY to TimetableDay(
                    formatDayOfWeek(DayOfWeek.MONDAY),
                    listOf(
                        TimetableItem(
                            lessonName = "Базы и хранилища данных (лек.)",
                            startTime = "18.20",
                            endTime = "19.50",
                            classroomName = "А-17",
                            teacherFullName = "Барабанщиков"
                        ),
                        TimetableItem(
                            lessonName = "Базы и хранилища данных (пр.)",
                            startTime = "19.55",
                            endTime = "21.25",
                            classroomName = "132",
                            teacherFullName = "Барабанщиков"
                        ),
                    )
                ),
                DayOfWeek.TUESDAY to TimetableDay(
                    formatDayOfWeek(DayOfWeek.TUESDAY),
                    listOf(
                        TimetableItem(
                            lessonName = "Управление IT-проектами (лек.)",
                            startTime = "18.20",
                            endTime = "19.50",
                            classroomName = "А-21",
                            teacherFullName = "Воробьёв, Пущев"
                        ),
                        TimetableItem(
                            lessonName = "Управление IT-проектами (пр.)",
                            startTime = "19.55",
                            endTime = "21.25",
                            classroomName = "А-21",
                            teacherFullName = "Воробьёв, Пущев"
                        ),
                    )
                ),
                DayOfWeek.WEDNESDAY to TimetableDay(
                    formatDayOfWeek(DayOfWeek.WEDNESDAY),
                    emptyList()
                ),
                DayOfWeek.THURSDAY to TimetableDay(
                    formatDayOfWeek(DayOfWeek.THURSDAY),
                    listOf(
                        TimetableItem(
                            lessonName = "Разработка интернет-приложений (лек.)",
                            startTime = "19.30",
                            endTime = "19.50",
                            classroomName = "132",
                            teacherFullName = "Павличенко"
                        ),
                        TimetableItem(
                            lessonName = "Разработка интернет-приложений (пр.)",
                            startTime = "19.55",
                            endTime = "21.25",
                            classroomName = "132",
                            teacherFullName = "Павличенко"
                        ),
                    )
                ),
                DayOfWeek.FRIDAY to TimetableDay(
                    formatDayOfWeek(DayOfWeek.FRIDAY),
                    listOf(
                        TimetableItem(
                            lessonName = "Экономика ПрИ (пр.)",
                            startTime = "13.15",
                            endTime = "14.45",
                            classroomName = "215 (2 корпус)",
                            teacherFullName = "Ткач"
                        ),
                        TimetableItem(
                            lessonName = "Экономика ПрИ (лек.)",
                            startTime = "15.00",
                            endTime = "16.30",
                            classroomName = "120 (2 корпус)",
                            teacherFullName = "Ткач"
                        ),
                        TimetableItem(
                            lessonName = "Экономика ПрИ (пр.)",
                            startTime = "16.30",
                            endTime = "18.10",
                            classroomName = "120 (2 корпус)",
                            teacherFullName = "Ткач"
                        ),
                        TimetableItem(
                            lessonName = "Тестирование ПО, 2 - 10 нед. (лек.)",
                            startTime = "19.30",
                            endTime = "21.00",
                            classroomName = "Дистант",
                            teacherFullName = "Булавин"
                        ),
                    )
                ),
                DayOfWeek.SATURDAY to TimetableDay(
                    formatDayOfWeek(DayOfWeek.SATURDAY),
                    listOf(
                        TimetableItem(
                            lessonName = "Тестирование ПО, 1 - 9 нед. (пр.)",
                            startTime = "11.20",
                            endTime = "12.50",
                            classroomName = "132",
                            teacherFullName = "Булавин"
                        ),
                        TimetableItem(
                            lessonName = "Тестирование ПО, 1 - 9 нед. (пр.)",
                            startTime = "13.15",
                            endTime = "14.45",
                            classroomName = "132",
                            teacherFullName = "Булавин"
                        ),
                        TimetableItem(
                            lessonName = "ТПП (лек.)",
                            startTime = "15.00",
                            endTime = "16.30",
                            classroomName = "326",
                            teacherFullName = "Веригин"
                        ),
                        TimetableItem(
                            lessonName = "ТПП (пр.)",
                            startTime = "16.40",
                            endTime = "18.10",
                            classroomName = "326",
                            teacherFullName = "Веригин"
                        ),
                    )
                )
            ),
            2 to mapOf(
                DayOfWeek.MONDAY to TimetableDay(
                    formatDayOfWeek(DayOfWeek.MONDAY),
                    listOf(
                        TimetableItem(
                            lessonName = "Анализ данных (лек.)",
                            startTime = "16.40",
                            endTime = "18.10",
                            classroomName = "А-17",
                            teacherFullName = "Мирасов"
                        ),
                        TimetableItem(
                            lessonName = "Базы и хранилища данных (лек.)",
                            startTime = "18.20",
                            endTime = "19.50",
                            classroomName = "А-17",
                            teacherFullName = "Барабанщиков"
                        ),
                    )
                ),
                DayOfWeek.TUESDAY to TimetableDay(
                    formatDayOfWeek(DayOfWeek.TUESDAY),
                    listOf(
                        TimetableItem(
                            lessonName = "Управление IT-проектами (лек.)",
                            startTime = "18.20",
                            endTime = "19.50",
                            classroomName = "А-21",
                            teacherFullName = "Воробьёв, Пущев"
                        ),
                        TimetableItem(
                            lessonName = "Управление IT-проектами (пр.)",
                            startTime = "19.55",
                            endTime = "21.25",
                            classroomName = "А-21",
                            teacherFullName = "Воробьёв, Пущев"
                        ),
                    )
                ),
                DayOfWeek.WEDNESDAY to TimetableDay(
                    formatDayOfWeek(DayOfWeek.WEDNESDAY),
                    listOf(
                        TimetableItem(
                            lessonName = "Базы и хранилища данных (пр.)",
                            startTime = "18.20",
                            endTime = "19.50",
                            classroomName = "132",
                            teacherFullName = "Барабанщиков"
                        ),
                        TimetableItem(
                            lessonName = "Базы и хранилища данных (пр.)",
                            startTime = "19.55",
                            endTime = "21.25",
                            classroomName = "132",
                            teacherFullName = "Барабанщиков"
                        ),
                    )
                ),
                DayOfWeek.THURSDAY to TimetableDay(
                    formatDayOfWeek(DayOfWeek.THURSDAY),
                    listOf(
                        TimetableItem(
                            lessonName = "Разработка интернет-приложений (лек.)",
                            startTime = "19.30",
                            endTime = "19.50",
                            classroomName = "132",
                            teacherFullName = "Павличенко"
                        ),
                        TimetableItem(
                            lessonName = "Разработка интернет-приложений (пр.)",
                            startTime = "19.55",
                            endTime = "21.25",
                            classroomName = "132",
                            teacherFullName = "Павличенко"
                        ),
                    )
                ),
                DayOfWeek.FRIDAY to TimetableDay(
                    formatDayOfWeek(DayOfWeek.FRIDAY),
                    listOf(
                        TimetableItem(
                            lessonName = "Анализ данных (пр.)",
                            startTime = "15.00",
                            endTime = "16.30",
                            classroomName = "132",
                            teacherFullName = "Мирасов"
                        ),
                        TimetableItem(
                            lessonName = "Анализ данных (пр.)",
                            startTime = "16.30",
                            endTime = "18.10",
                            classroomName = "132",
                            teacherFullName = "Мирасов"
                        ),
                        TimetableItem(
                            lessonName = "Тестирование ПО, 2 - 10 нед. (лек.)",
                            startTime = "19.30",
                            endTime = "21.00",
                            classroomName = "Дистант",
                            teacherFullName = "Булавин"
                        ),
                    )
                ),
                DayOfWeek.SATURDAY to TimetableDay(
                    formatDayOfWeek(DayOfWeek.SATURDAY),
                    listOf(
                        TimetableItem(
                            lessonName = "Тестирование ПО, 1 - 9 нед. (пр.)",
                            startTime = "11.20",
                            endTime = "12.50",
                            classroomName = "132",
                            teacherFullName = "Булавин"
                        ),
                        TimetableItem(
                            lessonName = "Тестирование ПО, 1 - 9 нед. (пр.)",
                            startTime = "13.15",
                            endTime = "14.45",
                            classroomName = "132",
                            teacherFullName = "Булавин"
                        ),
                        TimetableItem(
                            lessonName = "ТПП (лек.)",
                            startTime = "15.00",
                            endTime = "16.30",
                            classroomName = "326",
                            teacherFullName = "Веригин"
                        ),
                        TimetableItem(
                            lessonName = "ТПП (пр.)",
                            startTime = "16.40",
                            endTime = "18.10",
                            classroomName = "326",
                            teacherFullName = "Веригин"
                        ),
                    )
                )
            )
        )

    operator fun get(isOddWeek: Boolean = true): Map<DayOfWeek, TimetableDay>? =
        if (isOddWeek) {
            data[1]
        } else {
            data[2]
        }

    operator fun get(isOddWeek: Boolean = true, dayOfWeek: DayOfWeek = DayOfWeek.MONDAY): TimetableDay? =
        this[isOddWeek]?.let { week ->
            week[dayOfWeek]
        }
}