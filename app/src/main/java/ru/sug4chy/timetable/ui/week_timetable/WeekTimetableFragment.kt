package ru.sug4chy.timetable.ui.week_timetable

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import by.kirich1409.viewbindingdelegate.viewBinding
import ru.sug4chy.timetable.R
import ru.sug4chy.timetable.databinding.FragmentTimetableBinding
import ru.sug4chy.timetable.ui.adapter.TimetableRecyclerAdapter
import ru.sug4chy.timetable.ui.adapter.item_decoration.BorderCurrentDayItemDecoration
import ru.sug4chy.timetable.utils.DateTimeUtils
import ru.sug4chy.timetable.utils.TimetableData

class WeekTimetableFragment private constructor() : Fragment(R.layout.fragment_timetable) {

    private val binding: FragmentTimetableBinding by viewBinding()
    private val adapter: TimetableRecyclerAdapter = TimetableRecyclerAdapter(
        data = TimetableData[
            DateTimeUtils.isCurrentWeekOdd()
        ]?.map { entry -> entry.value } ?: emptyList()
    )

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        // Default setup
        super.onViewCreated(view, savedInstanceState)

        binding.lessonsRecycler.apply {
            layoutManager = LinearLayoutManager(requireContext())
            adapter = this@WeekTimetableFragment.adapter
            addItemDecoration(BorderCurrentDayItemDecoration())
        }
    }

    companion object {

        fun createNew(): WeekTimetableFragment =
            WeekTimetableFragment()
    }
}