package ru.sug4chy.timetable.ui.adapter.view_holder

import androidx.recyclerview.widget.RecyclerView
import ru.sug4chy.timetable.databinding.ViewholderDayOfWeekBinding
import ru.sug4chy.timetable.utils.DateTimeUtils

class DayOfWeekViewHolder(
    private val binding: ViewholderDayOfWeekBinding
) : RecyclerView.ViewHolder(binding.root) {

    private var _isForCurrentDayOfWeek: Boolean? = null
    val isForCurrentDayOfWeek: Boolean
        get() = requireNotNull(_isForCurrentDayOfWeek)

    fun bind(dayOfWeek: String) {
        _isForCurrentDayOfWeek = dayOfWeek == DateTimeUtils.currentDayOfWeekFormatted
        binding.currentDayOfWeekTxv.text = dayOfWeek
    }
}