package ru.sug4chy.timetable.ui.view_holder

import androidx.recyclerview.widget.RecyclerView
import ru.sug4chy.timetable.databinding.ViewholderDayOfWeekBinding

class DayOfWeekViewHolder(
    private val binding: ViewholderDayOfWeekBinding
) : RecyclerView.ViewHolder(binding.root) {

    fun bind(dayOfWeek: String) {
        binding.currentDayOfWeekTxv.text = dayOfWeek
    }
}