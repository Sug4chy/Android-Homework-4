package ru.sug4chy.timetable.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import ru.sug4chy.timetable.databinding.ViewholderDayOfWeekBinding
import ru.sug4chy.timetable.databinding.ViewholderTimetableItemBinding
import ru.sug4chy.timetable.model.TimetableDay
import ru.sug4chy.timetable.ui.adapter.model.TimetableItemOrStringWrapper
import ru.sug4chy.timetable.ui.adapter.view_holder.DayOfWeekViewHolder
import ru.sug4chy.timetable.ui.adapter.view_holder.TimetableItemViewHolder

class TimetableRecyclerAdapter(
    data: List<TimetableDay>
) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    private val internalData: List<TimetableItemOrStringWrapper> =
        data.flatMap { day ->
            listOf(TimetableItemOrStringWrapper.ofString(day.dayOfWeek)) +
                    if (day.lessons.isEmpty()) {
                        listOf(TimetableItemOrStringWrapper.ofString("Сегодня пар нет!"))
                    } else {
                        day.lessons
                            .map { lesson ->
                                TimetableItemOrStringWrapper.ofTimetableItem(
                                    item = lesson.apply {
                                        dayOfWeek = day.dayOfWeek
                                    }
                                )
                            }
                    }
        }

    override fun getItemViewType(position: Int): Int =
        when (internalData[position].type) {
            TimetableItemOrStringWrapper.Type.STRING -> 0
            TimetableItemOrStringWrapper.Type.TIMETABLE_ITEM -> 1
        }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val context = parent.context
        val inflater = LayoutInflater.from(context)

        return when (viewType) {
            0 -> DayOfWeekViewHolder(
                ViewholderDayOfWeekBinding.inflate(
                    inflater,
                    parent,
                    false
                )
            )

            else -> TimetableItemViewHolder(
                ViewholderTimetableItemBinding.inflate(
                    inflater,
                    parent,
                    false
                )
            )
        }
    }

    override fun getItemCount(): Int =
        internalData.size

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        when (holder) {
            is DayOfWeekViewHolder -> holder.bind(internalData[position].string ?: return)
            is TimetableItemViewHolder -> holder.bind(
                internalData[position].timetableItem ?: return
            )
        }
    }
}