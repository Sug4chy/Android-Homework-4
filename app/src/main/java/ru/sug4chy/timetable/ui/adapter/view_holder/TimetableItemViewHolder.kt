package ru.sug4chy.timetable.ui.adapter.view_holder

import androidx.recyclerview.widget.RecyclerView
import ru.sug4chy.timetable.databinding.ViewholderTimetableItemBinding
import ru.sug4chy.timetable.model.TimetableItem
import ru.sug4chy.timetable.utils.DateTimeUtils

class TimetableItemViewHolder(
    private val binding: ViewholderTimetableItemBinding
) : RecyclerView.ViewHolder(binding.root) {

    private var _isForCurrentDayOfWeek: Boolean? = null
    val isForCurrentDayOfWeek: Boolean
        get() = requireNotNull(_isForCurrentDayOfWeek)

    fun bind(timetableItem: TimetableItem) {
        _isForCurrentDayOfWeek = timetableItem.dayOfWeek == DateTimeUtils.currentDayOfWeekFormatted
        with(binding) {
            lessonNameTxv.text = timetableItem.lessonName
            teacherNameTxv.text = timetableItem.teacherFullName
            startEndTimeTxv.text =
                String.format("%s - %s", timetableItem.startTime, timetableItem.endTime)
            classromNameTxv.text = timetableItem.classroomName
        }
    }
}