package ru.sug4chy.timetable.extensions

fun String.capitalizeFirstChar() =
    this.replaceFirstChar { it.uppercaseChar() }