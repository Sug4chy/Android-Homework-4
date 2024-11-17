package ru.sug4chy.timetable.ui.today_timetable

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import by.kirich1409.viewbindingdelegate.viewBinding
import ru.sug4chy.timetable.R
import ru.sug4chy.timetable.databinding.FragmentTimetableBinding
import ru.sug4chy.timetable.ui.adapter.TimetableRecyclerAdapter
import ru.sug4chy.timetable.utils.DateTimeUtils
import ru.sug4chy.timetable.utils.TimetableData

class TodayTimetableFragment private constructor() : Fragment(R.layout.fragment_timetable) {

    private val binding: FragmentTimetableBinding by viewBinding()
    private val adapter: TimetableRecyclerAdapter = TimetableRecyclerAdapter(
        data = TimetableData[
            DateTimeUtils.isCurrentWeekOdd(),
            DateTimeUtils.currentDayOfWeek
        ]?.let { listOf(it) } ?: emptyList()
    )

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        // Default setup
        super.onViewCreated(view, savedInstanceState)

        with(binding.lessonsRecycler) {
            layoutManager = LinearLayoutManager(requireContext())
            adapter = this@TodayTimetableFragment.adapter
        }
    }

    companion object {

        fun createNew(): TodayTimetableFragment =
            TodayTimetableFragment()
    }
}