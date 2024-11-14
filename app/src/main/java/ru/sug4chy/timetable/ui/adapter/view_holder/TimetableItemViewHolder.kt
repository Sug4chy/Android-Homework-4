package ru.sug4chy.timetable.ui.adapter.view_holder

import androidx.recyclerview.widget.RecyclerView
import ru.sug4chy.timetable.databinding.ViewholderTimetableItemBinding
import ru.sug4chy.timetable.domain.model.TimetableItem

class TimetableItemViewHolder(
    private val binding: ViewholderTimetableItemBinding
) : RecyclerView.ViewHolder(binding.root) {

    fun bind(timetableItem: TimetableItem) {
        with(binding) {
            lessonNameTxv.text = timetableItem.lessonName
            teacherNameTxv.text = timetableItem.teacherFullName
            startEndTimeTxv.text =
                String.format("%s - %s", timetableItem.startTime, timetableItem.endTime)
            classromNameTxv.text = timetableItem.classroomName
        }
    }
}