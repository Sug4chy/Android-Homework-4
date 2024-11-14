package ru.sug4chy.timetable.ui.week_timetable

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import ru.sug4chy.timetable.databinding.ViewholderDayOfWeekBinding
import ru.sug4chy.timetable.databinding.ViewholderTimetableItemBinding
import ru.sug4chy.timetable.domain.model.TimetableDay
import ru.sug4chy.timetable.ui.view_holder.DayOfWeekViewHolder
import ru.sug4chy.timetable.ui.view_holder.TimetableItemViewHolder

class TimetableDayRecyclerAdapter(
    timetableForWeek: List<TimetableDay>
) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    private val data: List<TimetableItemOrStringWrapper> =
        timetableForWeek
            .flatMap { day ->
                listOf(TimetableItemOrStringWrapper.ofString(day.dayOfWeek)) +
                        if (day.lessons.isEmpty()) {
                            listOf(TimetableItemOrStringWrapper.ofString("Сегодня пар нет!"))
                        } else {
                            day.lessons
                                .map { lesson -> TimetableItemOrStringWrapper.ofTimetableItem(lesson) }
                        }
            }

    override fun getItemViewType(position: Int): Int =
        when (data[position].type) {
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
        data.size

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        when (holder) {
            is DayOfWeekViewHolder -> holder.bind(data[position].string ?: return)
            is TimetableItemViewHolder -> holder.bind(data[position].timetableItem ?: return)
        }
    }
}