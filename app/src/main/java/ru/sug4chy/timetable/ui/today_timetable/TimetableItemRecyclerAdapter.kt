package ru.sug4chy.timetable.ui.today_timetable

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import ru.sug4chy.timetable.databinding.ViewholderTimetableItemBinding
import ru.sug4chy.timetable.domain.model.TimetableItem
import ru.sug4chy.timetable.ui.view_holder.TimetableItemViewHolder

class TimetableItemRecyclerAdapter(
    private val data: List<TimetableItem>
) : RecyclerView.Adapter<TimetableItemViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TimetableItemViewHolder {
        val context = parent.context
        val inflater = LayoutInflater.from(context)
        val binding = ViewholderTimetableItemBinding.inflate(
            inflater, parent, false
        )

        return TimetableItemViewHolder(binding)
    }

    override fun getItemCount(): Int =
        data.size

    override fun onBindViewHolder(holder: TimetableItemViewHolder, position: Int) {
        holder.bind(data[position])
    }
}